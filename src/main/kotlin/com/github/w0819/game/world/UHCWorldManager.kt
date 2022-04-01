package com.github.w0819.game.world

import com.github.w0819.game.util.UHC
import com.github.w0819.plugin.UHCPlugin
import io.github.dolphin2410.worldgen.WorldUtils
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.WorldCreator
import org.bukkit.scheduler.BukkitRunnable
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ThreadLocalRandom

class UHCWorldManager : UHC {
    companion object {
        const val OVER_WORLD = "uhc"
        const val NETHER_WORLD = "uhc_nether"
        const val END_WORLD = "uhc_end"
        val seed: Long
            get() = ThreadLocalRandom.current().nextLong(4294967296) - 2147483648

        @JvmStatic
        fun generateWorld(): CompletableFuture<UHCWorld> {
            // TODO Cleaner structure
            val myseed = seed
            val future = CompletableFuture<UHCWorld>()
            WorldUtils.generateWorldStructureAsync(
                World.Environment.NETHER,
                NETHER_WORLD,
                myseed,
                Bukkit.getServer().pluginsFolder.parentFile,
                true
            ).thenAccept {
                WorldUtils.generateWorldStructureAsync(
                    World.Environment.THE_END,
                    END_WORLD,
                    myseed,
                    Bukkit.getServer().pluginsFolder.parentFile,
                    true
                ).thenAccept {
                    WorldUtils.generateWorldStructureAsync(
                        World.Environment.NORMAL,
                        OVER_WORLD,
                        myseed,
                        Bukkit.getServer().pluginsFolder.parentFile,
                        true
                    ).thenAccept {
                        object: BukkitRunnable() {
                            override fun run() {
                                val over = Bukkit.createWorld(WorldCreator(OVER_WORLD))!!
                                val nether = Bukkit.createWorld(WorldCreator(NETHER_WORLD))!!
                                val end = Bukkit.createWorld(WorldCreator(END_WORLD))!!
                                future.complete(UHCWorld(over, nether, end))
                            }
                        }.runTask(UHCPlugin.instance)
                    }
                }
            }
            return future
        }
    }
}
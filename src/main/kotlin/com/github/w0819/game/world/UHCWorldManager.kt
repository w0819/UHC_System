package com.github.w0819.game.world

import com.github.w0819.game.util.uhc.UHC
import org.bukkit.World
import org.bukkit.WorldCreator

class UHCWorldManager: UHC {
    companion object {
        const val OVER_WORLD = "uhc"
        const val NETHER_WORLD = "uhc_nether"
        const val END_WORLD = "uhc_end"
        
        // TODO Link portals

        @JvmStatic
        fun generateWorld(): UHCWorld {
            return UHCWorld(
                WorldCreator(OVER_WORLD).environment(World.Environment.NORMAL).createWorld()!!,
                WorldCreator(NETHER_WORLD).environment(World.Environment.NETHER).createWorld()!!,
                WorldCreator(END_WORLD).environment(World.Environment.THE_END).createWorld()!!
            )
        }
    }
}
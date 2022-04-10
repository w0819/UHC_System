package com.github.w0819.event

import com.github.w0819.game.resource.UHCResourceManager
import com.github.w0819.game.uhc.modifiers.TimeNight
import com.github.w0819.game.util.Item
import com.github.w0819.game.util.Item.recipeBook
import com.github.w0819.game.util.playersDefaultConfig
import com.github.w0819.plugin.UHCPlugin.Companion.game
import org.bukkit.Material
import org.bukkit.entity.*
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.*
import org.bukkit.event.player.PlayerItemBreakEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import kotlin.random.Random

class SystemEvent(private val plugin: JavaPlugin) : Listener {
    @EventHandler
    fun onItemBurn(event: EntityDamageEvent) {
        val ent = event.entity
        if (ent is org.bukkit.entity.Item) {
            if (event.cause == EntityDamageEvent.DamageCause.FIRE || event.cause == EntityDamageEvent.DamageCause.LAVA) {
                event.isCancelled = true
            }
        }
    }

    // 플레이어 조인
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        player.inventory.setItem(4,recipeBook)

        game?.addPlayer(player)
        event.player.addPotionEffect(PotionEffect(PotionEffectType.HEALTH_BOOST,1000000000,4,true,true,true))
        playersDefaultConfig(plugin.config,player)
    }
    @EventHandler
    fun onArrowShoot(e: ProjectileHitEvent) {
        val chance = Random
        val give = chance.nextFloat()
        if (e.entity.shooter is Player) {
            if((e.entity.shooter as Player).inventory.itemInMainHand == Item.Artemis_Bow) {
                if (give <= 0.15f) {
                    (e.entity.shooter as Player).inventory.addItem(ItemStack(Material.ARROW))
                }
            }
        }
    }
    @EventHandler
    fun onPlayerKill(event: PlayerDeathEvent) {
        val killer = event.entity.player?.killer
        killer?.let {
            UHCResourceManager.addCoin(it, 10)
        }
    }

    // time set
    @EventHandler
    fun onServerTimeSet(e: PlayerMoveEvent) {
        val player = e.player
        if (game?.modifier is TimeNight)
            TimeNight.playerNight((game ?: return).players)
        else
            player.world.time = 0
    }
    // 앙털
    @EventHandler
    fun onPlayerEntityInteract(event: EntityInteractEvent) {
        if (event.entity is Sheep) {
            val r = Random
            val chance: Float = r.nextFloat()
            if (chance <= 0.15f) {
                event.entity.world.dropItemNaturally(
                    event.entity.location, ItemStack(Material.STRING)
                )
            }
        }
    }
    // 블럭 드롭아이템
    @EventHandler
    fun onPlayerBreakBlack(event: PlayerItemBreakEvent) {
        if(event.brokenItem.isSimilar(ItemStack(Material.GRAVEL))) {
            val r = Random
            val chance: Float = r.nextFloat()
            if (chance <= 0.15f) {
                event.player.world.dropItemNaturally(
                    event.player.location, ItemStack(Material.FLINT)
                )
            }
        }
    }
    @EventHandler
    fun onPlayerDamage(event: EntityDamageEvent) {
        if (event.entity is Player) {
            if (event.cause == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
                event.isCancelled = true
            }
        }
    }

    // 엔티티 드롭아이템
    @EventHandler
    fun onEntityDeath(e: EntityDeathEvent) {
        if (e.entity is Spider) {
            e.entity.world.dropItemNaturally(
                e.entity.location, ItemStack(Material.STRING)
            )
        }
        if (e.entity is Chicken) {
                e.entity.world.dropItemNaturally(
                    e.entity.location, ItemStack(Material.FEATHER)
                )
        }
        if (e.entity is Spider) {
            val r = Random
            val chance: Float = r.nextFloat()
            if (chance <= 0.10f) {
                e.entity.world.dropItemNaturally(
                    e.entity.location, ItemStack(Material.SPIDER_EYE)
                )
            }
        }
        if (e.entity is Blaze) {
            e.entity.world.dropItemNaturally(
                e.entity.location, ItemStack(Material.BLAZE_ROD)
            )
        }
        if (e.entity is Ghast) {
            e.entity.world.dropItemNaturally(
                e.entity.location, ItemStack(Material.NETHER_WART)
            )
            e.entity.world.dropItemNaturally(
                e.entity.location, ItemStack(Material.ARROW)
            )
        }
        if (e.entity is Zombie) {
            val r = Random
            val chance: Float = r.nextFloat()
            if (chance <= 0.20f) {
                e.entity.killer?.giveExp(1000)
            }
        }
        if (e.entity is Skeleton) {
            val r = Random
            val chance: Float = r.nextFloat()
            if (chance <= 0.15f) {
                e.entity.world.dropItemNaturally(
                    e.entity.location, ItemStack(Material.BOW)
                )
            }
        }
        if (e.entity is Silverfish) {
            e.entity.world.dropItemNaturally(
                e.entity.location, ItemStack(Material.SLIME_BALL)
            )
        }
    }

    // 플레이어 죽을때의 효과
    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        val loc = event.entity.player?.location
        val world = loc?.world
        world?.dropItemNaturally(loc, ItemStack(Material.PLAYER_HEAD, 1))
        world?.strikeLightningEffect(loc)
    }

}
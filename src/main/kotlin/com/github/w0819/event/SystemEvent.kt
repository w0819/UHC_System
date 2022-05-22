package com.github.w0819.event

import com.github.w0819.game.resource.UHCResourceManager
import com.github.w0819.game.uhc.modifiers.TimeNight
import com.github.w0819.game.uhc.recipes.`Artemis'sBow`
import com.github.w0819.game.util.Util
import com.github.w0819.plugin.UHCPlugin.Companion.game
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.entity.*
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.entity.*
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.entity.Item as ItemEntity

class SystemEvent : Listener {
    
    // 아이템을 타지 못하게
    @EventHandler
    fun onItemBurn(event: EntityDamageEvent) {
        if (event.entity is ItemEntity) {
            if (event.cause == EntityDamageEvent.DamageCause.FIRE || event.cause == EntityDamageEvent.DamageCause.LAVA) {
                event.isCancelled = true
            }
        }
    }

    // 플레이어 참가
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        game.addPlayer(player)
    }
    
    // Artemis Bow 사용시 확률적으로 화살을 얻는다
    @EventHandler
    fun onArrowShoot(e: ProjectileHitEvent) {
        val shooter = e.entity.shooter
        if (shooter is Player && shooter.inventory.itemInMainHand == `Artemis'sBow`.result) {
            if (Util.percent(15)) {
                shooter.inventory.addItem(ItemStack(Material.ARROW))
            }
       }
    }

    // 플레이어 죽였을 때 +10코인
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
        if (game.modifier is TimeNight)
            TimeNight.playerNight(game.players)
        else
            player.world.time = 0
    }

    // 앙털 깎을 때 실 드롭
    @EventHandler
    fun onPlayerEntityInteract(event: EntityInteractEvent) {
        if (event.entity is Sheep) {
            if (Util.percent(15)) {
                event.entity.world.dropItemNaturally(
                    event.entity.location, ItemStack(Material.STRING)
                )
            }
        }
    }

    // 부싯돌 드롭 확률 up
    @EventHandler
    fun onPlayerBlockBreak(event: BlockBreakEvent) {
        if(event.block.type == Material.GRAVEL) {
            if (Util.percent(15)) {
                event.player.world.dropItemNaturally(
                    event.player.location, ItemStack(Material.FLINT)
                )
            }
        }
    }
    
    // 폭발로 인한 데미지 제거
    @EventHandler
    fun onPlayerDamage(event: EntityDamageEvent) {
        if (event.entity is Player) {
            if (event.cause == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
                event.isCancelled = true
            }
        }
    }

    // 엔티티별 드롭아이템
    @EventHandler
    fun onEntityDeath(e: EntityDeathEvent) {
        if (e.entity is Spider) {
            e.entity.world.dropItemNaturally(
                e.entity.location, ItemStack(Material.STRING)
            )

            if (Util.percent(10)) {
                e.entity.world.dropItemNaturally(
                    e.entity.location, ItemStack(Material.SPIDER_EYE)
                )
            }
        }
        
        if (e.entity is Chicken) {
            e.entity.world.dropItemNaturally(
                e.entity.location, ItemStack(Material.FEATHER)
            )
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
            if (Util.percent(20)) {
                e.entity.killer?.giveExp(1000)
            }
        }

        if (e.entity is Skeleton) {
            if (Util.percent(15)) {
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

    // 플레이어 죽을때 번개 효과
    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        val player = event.player
        val loc = player.location
        val world = player.world
        player.apply {
            gameMode = GameMode.SPECTATOR
        }
        world.dropItemNaturally(loc, ItemStack(Material.PLAYER_HEAD, 1))
        world.strikeLightningEffect(loc)
    }
}
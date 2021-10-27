package com.github.w0819.event

import com.github.w0819.Item
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.*
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.entity.EntityInteractEvent
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.inventory.CraftItemEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerItemBreakEvent
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import kotlin.random.Random

class Event : Listener {

    private var count = 0

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        val loc = player.location
        player.health + 20.0

        loc.world.time = 1000
    }
    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val player = event.player
        val item = ItemStack(Material.PLAYER_HEAD)
        if (event.action == Action.RIGHT_CLICK_AIR || event.action == Action.RIGHT_CLICK_BLOCK) {
            when(event.item) {
                item -> {
                    player.inventory.removeItem(item)
                    player.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION,100,1,true,true))
                }
            }

        }
    }
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
    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        val loc = event.entity.player?.location
        val world = loc?.world
        count = 0
        val killer = event.entity.player?.killer
        killer?.giveExp(50)
        val r = Random
        val chance: Float = r.nextFloat()
        if (chance <= 0.5f) {
            world?.dropItemNaturally(loc, ItemStack(Material.PLAYER_HEAD, 1))
        }
        world?.strikeLightningEffect(loc)
    }
    @EventHandler
    fun onPlayerItemConsume(event: PlayerItemConsumeEvent) {
        val item = event.item
        val player = event.player
        if (item == Item.golden_head) {
            player.health + 8.0
            event.player.addPotionEffect(PotionEffect(PotionEffectType.SPEED,200,1,true,false,true))
            event.player.addPotionEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200,1,true,false,true))
            event.player.addPotionEffect(PotionEffect(PotionEffectType.HEAL,100,1,true,false,true))
        }
    }
    @EventHandler
    fun onPlayerCraft(event: CraftItemEvent) {
        val item = event.recipe
        if (item == Item.apprentice_Sword) {
            Thread.sleep(6_0000)
            Item.apprentice_Sword.itemMeta.addEnchant(Enchantment.DAMAGE_ALL,1,true)
            Thread.sleep(6_0000)
            Item.dragon_sword.itemMeta.addEnchant(Enchantment.DAMAGE_ALL,1,true)
        }
        if (item == Item.apprentice_Bow) {
            Thread.sleep(6_000)
            Item.apprentice_Bow.itemMeta.addEnchant(Enchantment.ARROW_DAMAGE,1,true)
            Thread.sleep(3_000)
            Item.apprentice_Bow.itemMeta.addEnchant(Enchantment.ARROW_DAMAGE,1,true)
        }
    }
}




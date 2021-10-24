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
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import kotlin.random.Random


val apprentice_Sword_enchant: ItemMeta = Item.apprentice_Sword.itemMeta
val apprentice_Bow_enchant: ItemMeta = Item.apprentice_Bow.itemMeta
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
        val killer = event.entity.killer
        killer?.giveExp(50)

        world?.dropItemNaturally(loc, ItemStack(Material.PLAYER_HEAD, 1))
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
    fun onPlayerEat(event: PlayerItemConsumeEvent) {
        val item = event.item
        val player = event.player
        if (item == Item.golden_head) {
            player.addPotionEffect(PotionEffect(PotionEffectType.HEAL, 2400, 1, true, true, true))
            event.player.addPotionEffect(PotionEffect(PotionEffectType.SPEED, 200, 1, true, false, true))
            event.player.addPotionEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 1, true, false, true))
            event.player.addPotionEffect(PotionEffect(PotionEffectType.HEAL, 100, 1, true, false, true))
        }
    }
    @EventHandler
    fun onPlayerCraft(event: CraftItemEvent) {
        val item = event.recipe
        if (item == Item.apprentice_Sword) {
            Thread.sleep(6_0000)
            apprentice_Sword_enchant.addEnchant(Enchantment.DAMAGE_ALL,1,true)
            Item.apprentice_Sword.itemMeta = apprentice_Sword_enchant
            Thread.sleep(6_0000)
            apprentice_Sword_enchant.addEnchant(Enchantment.DAMAGE_ALL,1,true)
            Item.apprentice_Sword.itemMeta = apprentice_Sword_enchant
        }
        if (item == Item.apprentice_Bow) {
            Thread.sleep(6_000)
            apprentice_Bow_enchant.addEnchant(Enchantment.ARROW_DAMAGE,1,true)
            Item.apprentice_Bow.itemMeta = apprentice_Bow_enchant
            Thread.sleep(3_000)
            apprentice_Bow_enchant.addEnchant(Enchantment.ARROW_DAMAGE,1,true)
            Item.apprentice_Bow.itemMeta = apprentice_Bow_enchant
        }
    }
}




package com.github.w0819.event

import com.github.w0819.Item
import com.github.w0819.main.Main
import com.github.w0819.main.openRecipeStore
import net.kyori.adventure.text.Component.text
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerLoginEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType


class Event(private val plugin: Main) : Listener {
    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        if (event.action == Action.LEFT_CLICK_BLOCK || event.action == Action.LEFT_CLICK_AIR) {
            when (event.item) {
                Item.dragon_sword -> {
                    event.player.damage(7.0)
                }
                ItemStack(Material.EMERALD) -> {
                    event.player.openRecipeStore(plugin)
                }
            }
        }
    }
    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        val loc = event.entity.player?.location
        val world = loc?.world

        world?.dropItemNaturally(loc, ItemStack(Material.PLAYER_HEAD,1))
        world?.strikeLightningEffect(loc)

    }
    @EventHandler
    fun onPlayerEat(event: PlayerItemConsumeEvent) {
        val item = event.item
        val player = event.player
        if (item == Item.golden_head) {
            player.addPotionEffect(PotionEffect(PotionEffectType.HEAL,2400,1,true,true,true))
        }
    }
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        event.joinMessage(text("Hello ${event.player.name}"))
        event.player.inventory.setItem(8, ItemStack(Material.EMERALD))
    }

    @EventHandler
    fun onPlayerFirstJoin(event: PlayerLoginEvent) {
        val p = event.player
        if (!p.hasPlayedBefore()) {
            p.inventory.addItem(ItemStack(Material.STONE_PICKAXE))
            p.inventory.addItem(ItemStack(Material.STONE_AXE))
            p.inventory.addItem(ItemStack(Material.STONE_SWORD))
            p.inventory.addItem(ItemStack(Material.STONE_SHOVEL))
        }
    }
    @EventHandler(ignoreCancelled = true)
    fun onPlayerItemConsume(event: PlayerItemConsumeEvent) {
        val item = event.item
        if (item == Item.golden_head) {
            event.player.removePotionEffect(PotionEffectType.REGENERATION)
            event.player.removePotionEffect(PotionEffectType.ABSORPTION)
            event.player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE)
            event.player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE)
            event.player.addPotionEffect(PotionEffect(PotionEffectType.SPEED,200,1,true,false,true))
            event.player.addPotionEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200,1,true,false,true))
            event.player.addPotionEffect(PotionEffect(PotionEffectType.HEAL,100,1,true,false,true))
        }
    }
}


package com.github.w0819.event

import com.github.w0819.Item
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.inventory.CraftItemEvent
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType


class Event : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        val health = player.health
        val playerHealth = health + 20

        player.health = playerHealth
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
    fun onPlayerItemConsume(event: PlayerItemConsumeEvent) {
        val item = event.item
        if (item == Item.golden_head) {
            event.player.addPotionEffect(PotionEffect(PotionEffectType.SPEED,200,1,true,false,true))
            event.player.addPotionEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200,1,true,false,true))
            event.player.addPotionEffect(PotionEffect(PotionEffectType.HEAL,100,1,true,false,true))
        }
    }
    @EventHandler
    fun onPlayerCraft(event: CraftItemEvent) {
        val item = event.recipe
        if (item == Item.apprentice_Sword) {
            Thread.sleep(600_000)
            Item.apprentice_Sword.addEnchantment(Enchantment.DAMAGE_ALL,1)
            Thread.sleep(600_000)
            Item.apprentice_Sword.addEnchantment(Enchantment.DAMAGE_ALL,1)
        }
    }
}


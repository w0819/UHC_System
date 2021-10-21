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
import org.bukkit.event.player.PlayerLoginEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

val apprentice_Sword_enchant: ItemMeta = Item.apprentice_Sword.itemMeta
val apprentice_Helmet_enchant: ItemMeta = Item.apprentice_Helmet.itemMeta
val apprentice_Bow_enchant: ItemMeta = Item.apprentice_Bow.itemMeta
class Event : Listener {

    private var count = 0

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent,log: PlayerLoginEvent) {
        val p = log.player
        if (!p.hasPlayedBefore()) {
            p.health += 20.0
            count = 1
        }
        val player = event.player
        player.health += 20.0

    }

    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        val loc = event.entity.player?.location
        val world = loc?.world
        count = 0

        world?.dropItemNaturally(loc, ItemStack(Material.PLAYER_HEAD, 1))
        world?.strikeLightningEffect(loc)
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



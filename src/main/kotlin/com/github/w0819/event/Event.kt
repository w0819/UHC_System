package com.github.w0819.event

import com.github.w0819.main.Main
import io.github.monun.tap.effect.playFirework
import net.kyori.adventure.text.Component.text
import org.bukkit.*
import org.bukkit.entity.Damageable
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.Plugin

class Event : Listener {
    private fun getInstance(): Plugin {
        return Main.instance
    }
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        val loc = player.location.add(0.0,0.5,0.0)

        val firework = FireworkEffect.builder().with(FireworkEffect.Type.STAR).withColor(Color.AQUA).build()

        getInstance().logger.info("Hello world!")
        event.player.sendMessage(text("Hello world"))
        loc.world.playFirework(loc,firework)
    }

}

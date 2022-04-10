package com.github.w0819.game.uhc.modifiers

import com.github.w0819.game.util.UHCModifier
import org.bukkit.entity.Player

class HealthOnKill : UHCModifier(
    "\uD83D\uDD2A",
    "[Health on Kill]",
    false
) {
    companion object {
        fun addHealthOnKill(player: Player) {
            player.healthScale += 1
        }
    }
}
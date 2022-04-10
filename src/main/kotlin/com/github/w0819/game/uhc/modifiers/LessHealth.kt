package com.github.w0819.game.uhc.modifiers

import com.github.w0819.game.util.UHCModifier
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class LessHealth : UHCModifier(
    "[\uD83D\uDDA4]",
    "[Less Heart]",
    false
) {
    private fun removeHeart(players: List<Player>) {
        if (players.isEmpty()) return
        val player = players[0]
        val damage = 15.0
        player.damage(damage)
        player.addPotionEffect(PotionEffect(PotionEffectType.HEALTH_BOOST,4,1000000000))
        player.damage(2.0)
        removeHeart(players - player)
    }

    override fun specialSkill(players: List<Player>) {
        super.specialSkill(players)
        removeHeart(players)
    }
}
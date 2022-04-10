package com.github.w0819.game.uhc.modifiers

import com.github.w0819.game.timer.UHCTimer
import com.github.w0819.game.util.UHCModifier
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType


class ExtraHealth : UHCModifier(
    "[\uD83D\uDC9B]",
    "[Extra Health]",
    false
) {
    private tailrec fun extraHealth(players: List<Player>) {
        if (players.isEmpty()) return
        val player = players[0]
        val time = (UHCTimer.GRACE_PERIOD_TIME + UHCTimer.PVP_PERIOD_TIME + UHCTimer.DEATH_MATCH_PERIOD_TIME) * 1200 // 분(60) * 틱(20)
        player.addPotionEffect(PotionEffect(PotionEffectType.HEALTH_BOOST,2,time))
        extraHealth(players - player)
    }

    override fun specialSkill(players: List<Player>) {
        super.specialSkill(players)
        extraHealth(players)
    }
}
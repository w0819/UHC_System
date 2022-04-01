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
    fun extraHealth(player: Player) {
        val time = (UHCTimer.GRACE_PERIOD_TIME + UHCTimer.PVP_PERIOD_TIME + UHCTimer.DEATH_MATCH_PERIOD_TIME) * 1200 // 분(60) * 틱(20)
        player.addPotionEffect(PotionEffect(PotionEffectType.HEALTH_BOOST,2,time * 60))

    }
}
package com.github.w0819.game.util.uhc

import com.github.w0819.plugin.UHCPlugin
import net.kyori.adventure.text.Component.text
import net.kyori.adventure.title.TitlePart
import org.bukkit.entity.Player
import java.util.*

/**
 * Game Modifier
 */
open class UHCModifier(private val emoticon: String, private val message: String, val weekendModifier: Boolean) : UHC {
    companion object {
        @JvmStatic
        fun selectModifier(players: List<Player>): UHCModifier {
            val currentDate = Date()
            val calendar = Calendar.getInstance()
            calendar.time = currentDate
            val dayOfWeekNumber = calendar.get(Calendar.DAY_OF_WEEK)
            val modifiers = UHCPlugin.modifierList()
            val modifier =  if (dayOfWeekNumber in listOf(1, 7)) { // 만약에 오늘이 주말이면
                modifiers.filter {
                    it.weekendModifier
                }.random()
            } else { // 아니면
                modifiers.filter {
                    !it.weekendModifier
                }.random()
            }
            modifier.sendMessage(players)
            modifier.specialSkill(players)
            return modifier
        }
    }

    fun sendMessage(players: List<Player>) {
        for (player in players) player.apply {
            sendTitlePart(TitlePart.TITLE,text(emoticon))
            sendTitlePart(TitlePart.SUBTITLE, text(message))
        }
    }
    open fun specialSkill(players: List<Player>) {

    }
}

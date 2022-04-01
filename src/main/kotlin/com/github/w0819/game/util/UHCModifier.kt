package com.github.w0819.game.util

import com.github.w0819.plugin.UHCPlugin
import net.kyori.adventure.text.Component.text
import net.kyori.adventure.title.TitlePart
import org.bukkit.entity.Player
import java.util.*


open class UHCModifier(private val emoticon: String, private val message: String, val weekendModifier: Boolean) : UHC {
    companion object {
        @JvmStatic
        fun playersModifier(player: Player) {
            val currentDate = Date()
            val calendar = Calendar.getInstance()
            calendar.time = currentDate
            val dayOfWeekNumber = calendar.get(Calendar.DAY_OF_WEEK)
            val modifier = if (dayOfWeekNumber in listOf(1,7)) { // 만약에 오늘이 주말 이면
                UHCPlugin.modifierList.filter {
                    it.weekendModifier
                }.random()
            } else { // 아니면
                UHCPlugin.modifierList.filter {
                    !it.weekendModifier
                }.random()
            }

            modifier.sendMessage(player)
        }
    }
    fun sendMessage(player: Player) {
        player.apply {
            sendTitlePart(TitlePart.TITLE,text(emoticon))
            sendTitlePart(TitlePart.SUBTITLE, text(message))
        }
    }
    open fun specialSkill(player: Player) {
        playersModifier(player)
    }
}

package com.github.w0819.game.util

import net.kyori.adventure.text.Component
import net.kyori.adventure.title.TitlePart
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.persistence.PersistentDataType
import java.util.*
import kotlin.random.Random

private val key = NamespacedKey.minecraft("whatModifier")
private val key1 = NamespacedKey.minecraft("whatOrdinal")

/**
 * Primary Modifiers list
 * 기본 Modifier 리스트
 * */
enum class PrimaryModifiers {
    BowMaster,
    Fishing,
    Mining,
    SwordMaster,
    RespawnTokens
}
/**
 * Secondary Modifiers list
 *
 * */
enum class SecondaryModifiers {
    ExtraDragons,
    ExtraHealth,
    LessHealth,
    DoubleHead,
    NightTime,
    ShortGrace,
    Pearls,
    Gold,
    ExtraKit,
    HealthOnKill,
    StatingUltimate,
    TrueUHC,
    BrewMasters,
    MagicPowers,
    FlowerPower,
    FastFood,
    Projectiless
}

/**
 * this function is return each Primary Modifiers Message
 */
private fun sendMessage(Modifier: PrimaryModifiers): String {
    return when(Modifier) {
        PrimaryModifiers.BowMaster -> "Bow Master"
        PrimaryModifiers.Mining -> "Mining"
        PrimaryModifiers.Fishing -> "Fishing"
        PrimaryModifiers.RespawnTokens -> "Respawn Tokens"
        PrimaryModifiers.SwordMaster -> "Sword Master"
    }
}
/**
 * this function is return each Secondary Modifiers Message
 * */
private fun sendMessage(Modifier: SecondaryModifiers): String {
    return when(Modifier) {
        SecondaryModifiers.BrewMasters -> "Brew Masters"
        SecondaryModifiers.DoubleHead ->  "Double Head"
        SecondaryModifiers.ExtraDragons -> "Extra Dragons"
        SecondaryModifiers.ExtraHealth -> "Extra Health"
        SecondaryModifiers.ExtraKit -> "Extra Kit"
        SecondaryModifiers.FastFood -> "Fast Food"
        SecondaryModifiers.FlowerPower -> "Flower Power"
        SecondaryModifiers.Gold -> "Gold"
        SecondaryModifiers.HealthOnKill -> "Health on Kill"
        SecondaryModifiers.LessHealth -> "Less Health"
        SecondaryModifiers.MagicPowers -> "Magic Powers"
        SecondaryModifiers.NightTime -> "Night Time"
        SecondaryModifiers.ShortGrace -> "Short Grace"
        SecondaryModifiers.StatingUltimate -> "Stating Ultimate"
        SecondaryModifiers.Pearls -> "Pearls"
        SecondaryModifiers.Projectiless -> "Projectiless"
        SecondaryModifiers.TrueUHC -> "True UHC"
    }
}


/**
 * this function is Modifier Choice as Random
 * */
fun randomModifierChoice(player: Player) {
    val primaryModifiers = PrimaryModifiers.values()
    val secondaryModifiers = SecondaryModifiers.values()
    val calendar = Calendar.getInstance()
    when(calendar.get(Calendar.DAY_OF_WEEK)) {
        in listOf(Calendar.SUNDAY,Calendar.SATURDAY,Calendar.FRIDAY) -> {
            val modifier = primaryModifiers[Random.nextInt(primaryModifiers.size)].ordinal

            player.persistentDataContainer.set(key1, PersistentDataType.INTEGER,modifier)
            player.persistentDataContainer.set(key, PersistentDataType.INTEGER,1)

            player.sendTitlePart(TitlePart.SUBTITLE,
                Component.text(sendMessage(primaryModifiers[Random.nextInt(primaryModifiers.size)])))
        }
        in listOf(Calendar.MONDAY,Calendar.TUESDAY,Calendar.WEDNESDAY,Calendar.THURSDAY) -> {
            val modifier = secondaryModifiers[Random.nextInt(primaryModifiers.size)].ordinal

            player.persistentDataContainer.set(key, PersistentDataType.INTEGER,modifier)
            player.persistentDataContainer.set(key, PersistentDataType.INTEGER,2)

            player.sendTitlePart(
                TitlePart.SUBTITLE, Component.text(sendMessage(secondaryModifiers[Random.nextInt(primaryModifiers.size)])))
        }
    }
}

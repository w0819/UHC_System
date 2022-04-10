package com.github.w0819.game.util

import com.github.w0819.plugin.UHCPlugin
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.entity.Player
import kotlin.reflect.KProperty1

private const val PlayersUHCListName = "PlayersUHCList"

tailrec fun playersDefaultConfig(config: FileConfiguration,player: Player): ConfigurationSection {
    if (!config.contains(player.name)) {
        UHCPlugin.PlayersUHC[player.uniqueId] = listOf()
        return config.createSection(player.name).apply { set(PlayersUHCListName,listOf<String>()) }
    }
    return config.getConfigurationSection(player.name) ?: playersDefaultConfig(config, player)
}
fun playersUHCSave(config: FileConfiguration, players: List<Player>) {
    tailrec fun playersUHCSave (config: FileConfiguration, players: List<Player>) {
        if (players.isEmpty()) return
        val player = players[0]
        val playersUHC = UHCPlugin.PlayersUHC[player.uniqueId] ?: listOf()
        (config.getConfigurationSection(player.name) ?: playersDefaultConfig(config, player)).createSection(player.name).set(PlayersUHCListName,playersUHC.map { it.toString() })
        playersUHCSave(config,players - player)
    }
    playersUHCSave(config, players)
}

tailrec fun playersUHCLoad(config: FileConfiguration, players: List<Player>) {
    if (players.isEmpty()) return
    val player = players[0]
    val playersUHCes = (config.getList(PlayersUHCListName) ?: listOf()).filterIsInstance<String>().mapNotNull { UHCPlugin.UHCList.find { uhc -> uhc.toString() == it } }

    UHCPlugin.PlayersUHC[player.uniqueId] = playersUHCes
    playersUHCLoad(config, players - player)
}

@Suppress("UNCHECKED_CAST")
fun <R> readInstanceProperty(instance: Any): List<R> {
    return instance::class.members.mapNotNull { (it as? KProperty1<Any, *>)?.get(instance) as? R }
}
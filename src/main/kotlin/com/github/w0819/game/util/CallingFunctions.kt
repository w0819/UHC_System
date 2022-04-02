package com.github.w0819.game.util

import com.github.w0819.plugin.UHCPlugin
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.entity.Player

private const val PlayersUHCListName = "PlayersUHCList"

tailrec fun playersDefaultConfig(config: FileConfiguration,player: Player): ConfigurationSection {
    if (!config.contains(player.name))
        return config.createSection(player.name).apply { set(PlayersUHCListName,listOf<String>()) }
    return config.getConfigurationSection(player.name) ?: playersDefaultConfig(config, player)
}
fun playersUHCSave(config: FileConfiguration, players: List<Player>) {
    tailrec fun playersUHCSave (config: FileConfiguration, players: List<Player>) {
        if (players.isEmpty()) return
        val player = players[0]
        val playersUHC = UHCPlugin.playersUHC[player.uniqueId] ?: listOf()
        (config.getConfigurationSection(player.name) ?: playersDefaultConfig(config, player)).createSection(player.name).set(PlayersUHCListName,playersUHC.map { it.toString() })
        playersUHCSave(config,players - player)
    }
    playersUHCSave(config, players)
}

tailrec fun playersUHCLoad(config: FileConfiguration, players: List<Player>) {
    if (players.isEmpty()) return
    val player = players[0]
    val playersUHCes = (config.getList(PlayersUHCListName) ?: listOf()).filterIsInstance<String>().mapNotNull { UHCPlugin.UHCList.find { uhc -> uhc.toString() == it } }

    UHCPlugin.playersUHC[player.uniqueId] = playersUHCes
    playersUHCLoad(config, players - player)
}


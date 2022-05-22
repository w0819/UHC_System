package com.github.w0819.game.uhc.modifiers

import com.github.w0819.game.util.Util.rangeTo
import com.github.w0819.game.util.uhc.UHCModifier
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.EnderDragon
import org.bukkit.entity.Player

class ExtraDragon : UHCModifier(
    "[\uD83D\uDC09]",
    "[Extra Dragon]",
    false
) {
    companion object {
        fun spawnDragon(player: Player) {
            val world = player.world
            (Location(world,0.0,0.0,0.0)..Location(world,0.0,512.0,0.0)).forEach {
                if (it.block.type == Material.GRASS_BLOCK)
                    it.world.spawn(it,EnderDragon::class.java).apply {
                        setAI(false)
                    }
            }
        }
    }

    override fun specialSkill(players: List<Player>) {
        super.specialSkill(players)
        spawnDragon(players[0])
    }

}
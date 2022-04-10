package com.github.w0819.game.uhc.modifiers

import com.github.w0819.game.util.UHCModifier
import org.bukkit.Location
import org.bukkit.entity.EnderDragon
import org.bukkit.entity.EntityType
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

class ExtraDragon : UHCModifier(
    "[\uD83D\uDC09]",
    "[Extra Dragon]",
    false
) {
    companion object {
        @JvmStatic
        fun spawnDragon(player: Player) {
            val world = player.world
            val location = Location(world,0.0,player.location.y,0.0)
            if (world.getNearbyEntities(location, 0.0, player.location.y, 0.0).filterIsInstance<EnderDragon>().isEmpty())
                world.spawnEntity(location,EntityType.ENDER_DRAGON).apply {
                    (this as LivingEntity).setAI(false)
                }
        }
    }
    override fun specialSkill(players: List<Player>) {
        super.specialSkill(players)
        spawnDragon(players[0])
    }
}
package com.github.w0819.game.world

import com.github.w0819.game.util.UHC
import org.bukkit.World

data class UHCWorld(val overworld: World, val nether: World, val end: World): UHC {
    override fun toString(): String {
        return "[${overworld.name},${nether.name},${end.name}]"
    }
    fun returnSeed(): List<Pair<World,Long>> {
        return listOf(
            overworld to overworld.seed,
            nether to nether.seed,
            end to end.seed
        )
    }
}
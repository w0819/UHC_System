package com.github.w0819.game.world

import com.github.w0819.game.util.uhc.UHC
import org.bukkit.World

/**
 * UHC 의 월드. 오버월드, 네더, 엔드 포함
 */
data class UHCWorld(val overworld: World, val nether: World, val end: World): UHC {
    override fun toString(): String {
        return "[${overworld.name},${nether.name},${end.name}]"
    }

    /**
     * 시드를 반환해줌
     */
    fun returnSeed(): List<Pair<World,Long>> {
        return listOf(
            overworld to overworld.seed,
            nether to nether.seed,
            end to end.seed
        )
    }
}
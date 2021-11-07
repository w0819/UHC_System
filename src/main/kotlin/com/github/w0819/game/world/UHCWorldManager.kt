package com.github.w0819.world

import com.onarandombox.MultiverseCore.MultiverseCore
import com.onarandombox.MultiverseNetherPortals.MultiverseNetherPortals
import org.bukkit.Bukkit
import org.bukkit.PortalType
import org.bukkit.World
import org.bukkit.WorldType

class UHCWorldManager {
    companion object {
        const val OVER_WORLD = "uhc"
        const val NETHER_WORLD = "uhc_nether"
        const val END_WORLD = "uhc_end"

        @JvmStatic
        fun generateWorld(): World {
            // TODO: Check if the worlds exist                                  월드 존재 여부 확인
            // TODO: If exists, delete the worlds                               만약 존재할 경우 삭제
            // TODO: Generate worlds ( Find a way to generate it with no lag )  월드 생성
            // TODO: Link the worlds                                            월드 링크

            TODO("Not Yet Implemented")
        }
    }
}
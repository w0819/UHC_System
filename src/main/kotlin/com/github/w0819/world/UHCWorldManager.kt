package com.github.w0819.world

import org.bukkit.WorldCreator

class UHCWorldManager {
    companion object {
        @JvmStatic
        fun generateWorld() {
            WorldCreator("hi").createWorld()
            // TODO: Fix lag due to blocking method createWorld()
        }
    }
}
package com.github.w0819.enchant

import org.bukkit.enchantments.EnchantmentTarget

object ReviveToken : EnchantmentWrapper("revive_token", "ReviveTone", 1) {
    override fun getItemTarget(): EnchantmentTarget {
        return EnchantmentTarget.TOOL
    }
}
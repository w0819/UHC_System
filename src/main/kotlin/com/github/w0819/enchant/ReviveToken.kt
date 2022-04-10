package com.github.w0819.enchant

import org.bukkit.enchantments.Enchantment
import org.bukkit.enchantments.EnchantmentTarget
import java.util.*

class ReviveToken(lvl: Int,name: String,namespace: String) : EnchantmentWrapper(namespace, name, lvl) {
    companion object {
        val ReviveToken = ReviveToken(1, "ReviveTone", "revive_token")
        fun register() {
            if (!Arrays.stream(Enchantment.values()).toList().contains(ReviveToken))
                registerEnchantment(ReviveToken)
        }
    }

    override fun getItemTarget(): EnchantmentTarget {
        return EnchantmentTarget.TOOL
    }
}
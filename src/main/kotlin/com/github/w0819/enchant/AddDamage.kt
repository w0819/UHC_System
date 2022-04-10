package com.github.w0819.enchant

import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import java.util.*

class AddDamage(lvl: Int,name: String,namespace: String) : EnchantmentWrapper(namespace, name, lvl) {
    companion object {
        val addDamage: Enchantment = EnchantmentWrapper("add_damage","AddDamage",100)
        fun register() {
            if (!Arrays.stream(Enchantment.values()).toList().contains(addDamage))
                registerEnchantment(addDamage)
        }
    }
    override fun canEnchantItem(item: ItemStack): Boolean {
        return true
    }
}
package com.github.w0819.enchant

import io.papermc.paper.enchantments.EnchantmentRarity
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.Component.text
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.enchantments.EnchantmentTarget
import org.bukkit.entity.EntityCategory
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack

open class EnchantmentWrapper(private val namespace: String, private val enchantName: String, private val maxLevel: Int): Enchantment(NamespacedKey.minecraft(namespace)) {
    override fun getMaxLevel(): Int {
        return maxLevel
    }

    override fun getStartLevel(): Int {
        return 1
    }

    override fun getItemTarget(): EnchantmentTarget {
        return EnchantmentTarget.WEAPON
    }

    override fun isTreasure(): Boolean {
        return false
    }

    override fun isCursed(): Boolean {
        return false
    }

    override fun conflictsWith(other: Enchantment): Boolean {
        return false
    }

    override fun canEnchantItem(item: ItemStack): Boolean {
        return false
    }

    override fun displayName(level: Int): Component {
        return text("")
    }

    override fun isTradeable(): Boolean {
        return false
    }

    override fun isDiscoverable(): Boolean {
        return false
    }

    override fun getRarity(): EnchantmentRarity {
        return EnchantmentRarity.VERY_RARE
    }

    override fun getDamageIncrease(level: Int, entityCategory: EntityCategory): Float {
        return 0.0F
    }

    override fun getActiveSlots(): Set<EquipmentSlot?> {
        return mutableSetOf()
    }

    override fun translationKey(): String {
        return namespace
    }

    @Deprecated("Deprecated, use getKey()")
    override fun getName(): String {
        return enchantName
    }

    fun register() {
        try {
            val f = Enchantment::class.java.getDeclaredField("acceptingNew")
            f.isAccessible = true
            f.set(null, true)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        if (!values().contains(this)) registerEnchantment(this)
    }
}
package com.github.w0819.game.uhc.kits

import com.github.w0819.game.util.uhc.UHCKit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack


class LeatherArmor(
    default: ArrayList<ItemStack> = arrayListOf(
        ItemStack(Material.LEATHER_HELMET),
        ItemStack(Material.LEATHER_CHESTPLATE),
        ItemStack(Material.LEATHER_LEGGINGS),
        ItemStack(Material.LEATHER_BOOTS)
    )
) : UHCKit(
    default,
    default.onEach { it.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1) },
    default.onEach { it.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,2) },
    default.onEach { it.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3) },
    arrayListOf(
        listOf(default[0].apply { addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3) },ItemStack(Material.IRON_HELMET)).random(),
        listOf(default[1].apply { addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3) },ItemStack(Material.IRON_CHESTPLATE)).random(),
        listOf(default[2].apply { addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3) },ItemStack(Material.IRON_LEGGINGS)).random(),
        listOf(default[3].apply { addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3) },ItemStack(Material.IRON_BOOTS)).random()
    )
) {

}
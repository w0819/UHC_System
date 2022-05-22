package com.github.w0819.game.uhc.kits

import com.github.w0819.game.util.uhc.UHCKit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack


object LeatherArmor : UHCKit(
    Default,
    Default.onEach { it.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1) },
    Default.onEach { it.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,2) },
    Default.onEach { it.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3) },
    arrayListOf(
        listOf(Default[0].apply { addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3) },ItemStack(Material.IRON_HELMET)).random(),
        listOf(Default[1].apply { addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3) },ItemStack(Material.IRON_CHESTPLATE)).random(),
        listOf(Default[2].apply { addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3) },ItemStack(Material.IRON_LEGGINGS)).random(),
        listOf(Default[3].apply { addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3) },ItemStack(Material.IRON_BOOTS)).random()
    )
) {
    private object Default : ArrayList<ItemStack>(
        arrayListOf(
            ItemStack(Material.LEATHER_HELMET),
            ItemStack(Material.LEATHER_CHESTPLATE),
            ItemStack(Material.LEATHER_LEGGINGS),
            ItemStack(Material.LEATHER_BOOTS)
        )
    )

}
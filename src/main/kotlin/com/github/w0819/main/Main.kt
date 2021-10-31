package com.github.w0819.main

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import com.github.w0819.event.Event
import net.kyori.adventure.text.Component.text
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.inventory.meta.EnchantmentStorageMeta
import org.bukkit.inventory.meta.LeatherArmorMeta
import org.bukkit.plugin.java.JavaPlugin


class Main : JavaPlugin() {
    companion object {
        @JvmStatic
        val recipeList = ArrayList<UHCRecipe>()
    }

    override fun onEnable() {
        server.pluginManager.registerEvents(Event(this), this)
        server.logger.info("Recipe is onEnable")
        recipe()

    }
    private fun recipe() {
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("light_anvil"),
                ItemStack(Material.ANVIL)
            ).apply {
                shape(
                    "111",
                    " 2 ",
                    "111"
                )
                setIngredient('1',Material.IRON_INGOT)
                setIngredient('2',Material.IRON_BLOCK)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("notch_apple"),
                Item.notch_apple
            ).apply {
                shape(
                    "111",
                    "121",
                    "111"
                )
                setIngredient('1',Material.GOLD_INGOT)
                setIngredient('2',Material.APPLE)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("sparkling_watermelon"),
                ItemStack(Material.GLISTERING_MELON_SLICE)
            ).apply {
                shape(
                    "111",
                    "121",
                    "111"
                )
                setIngredient('1',Material.IRON_INGOT)
                setIngredient('2',Material.MELON_SLICE)
            }
        )
        server.addRecipe(
            ShapedRecipe (
                NamespacedKey.minecraft("dragon_sword"),
                Item.dragon_sword
            ).apply {
                shape(
                    " 1 ",
                    " 2 ",
                    "313"
                )
                setIngredient('1', Material.OBSIDIAN)
                setIngredient('2', Material.DIAMOND_SWORD)
                setIngredient('3', Material.BLAZE_POWDER)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("apprentice_sword"),
                Item.apprentice_Sword
            ).apply {
                shape(
                    " 1 ",
                    " 2 ",
                    " 1 "
                )
                setIngredient('1',Material.REDSTONE_BLOCK)
                setIngredient('2',Material.IRON_SWORD)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("golden_head"),
                Item.golden_head
            ).apply {
                shape(
                    "111",
                    "121",
                    "111"
                )
                setIngredient('1', Material.GOLD_INGOT)
                setIngredient('2', Material.PLAYER_HEAD)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("tarnhelm"),
                Item.tarnhelm
            ).apply {
                shape(
                    "121",
                    "131",
                    "   "
                )
                setIngredient('1', Material.DIAMOND)
                setIngredient('2', Material.IRON_INGOT)
                setIngredient('3', Material.REDSTONE_BLOCK)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("philosopher_pickaxe"),
                Item.Philosopher_Pickaxe
            ).apply {
                shape(
                    "121",
                    "343",
                    " 4 "
                )
                setIngredient('1',Material.IRON_ORE)
                setIngredient('2',Material.GOLD_ORE)
                setIngredient('3',Material.LAPIS_LAZULI)
                setIngredient('4',Material.STICK)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("arrow_economy"),
                ItemStack(Material.ARROW,20)
            ).apply {
                shape(
                    "111",
                    "222",
                    "333"
                )
                setIngredient('1',Material.FLINT)
                setIngredient('2',Material.STICK)
                setIngredient('3',Material.FEATHER)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("iron_economy"),
                ItemStack(Material.IRON_INGOT,8)
            ).apply {
                shape(
                    "111",
                    "121",
                    "111"
                )
                setIngredient('1', Material.IRON_ORE)
                setIngredient('2', Material.COAL)
            }
        )
        val leatherHelmet = ItemStack(Material.LEATHER_HELMET)
        val meta = leatherHelmet.itemMeta as LeatherArmorMeta
        meta.setColor(Color.PURPLE)
        leatherHelmet.itemMeta = meta
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("saddle"),
                ItemStack(Material.SADDLE,1)
            ).apply {
                shape(
                    "111",
                    "212",
                    "3 3"
                )
                setIngredient('1',Material.LEATHER)
                setIngredient('2',Material.STRING)
                setIngredient('3',Material.IRON_INGOT)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("gold_pack"),
                ItemStack(Material.GOLD_INGOT,8)
            ).apply {
                shape(
                    "111",
                    "121",
                    "111"
                )
                setIngredient('1', Material.GOLD_ORE)
                setIngredient('2', Material.COAL)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("apprentice_helmet"),
                Item.apprentice_Helmet
            ).apply {
                shape(
                    "111",
                    "121",
                    "   "
                )
                setIngredient('1', Material.IRON_INGOT)
                setIngredient('2', Material.REDSTONE_TORCH)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("apprentice_bow"),
                Item.apprentice_Bow
            ).apply {
                shape(
                    " 12",
                    "1 2",
                    " 12"
                )
                setIngredient('1', Material.REDSTONE_TORCH)
                setIngredient('2', Material.STRING)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("new_apple"),
                ItemStack(Material.GOLDEN_APPLE,2)
            ).apply {
                shape(
                    " 1 ",
                    "121",
                    " 1 "
                )
                setIngredient('1', Material.GOLD_INGOT)
                setIngredient('2', Material.APPLE)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("eve_is_temptation"),
                ItemStack(Material.APPLE,2)
            ).apply {
                shape(
                    "   ",
                    " 1 ",
                    " 2 "
                )
                setIngredient('1', Material.BONE_MEAL)
                setIngredient('2', Material.APPLE)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("quick_pick"),
                Item.quick_pick
            ).apply {
                shape(
                    "111",
                    "232",
                    " 3 "
                )
                setIngredient('1',Material.IRON_ORE)
                setIngredient('2',Material.COAL)
                setIngredient('3',Material.STICK)
            }
        )
        val bookOfSharpening = ItemStack(Material.ENCHANTED_BOOK).apply {
            itemMeta = itemMeta.apply {
                displayName(text("Book of Sharpening"))
            }
        }
        val aMeta = bookOfSharpening.itemMeta as EnchantmentStorageMeta
        aMeta.addStoredEnchant(Enchantment.DAMAGE_ALL, 1, true)
        bookOfSharpening.itemMeta = aMeta
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("book_of_sharpening"),
                bookOfSharpening
            ).apply {
                shape(
                    "1  ",
                    " 22",
                    " 23"
                )
                setIngredient('1',Material.FLINT)
                setIngredient('2',Material.PAPER)
                setIngredient('3',Material.IRON_SWORD)
            }
        )
        val bookOfPower = ItemStack(Material.ENCHANTED_BOOK)
        val powerMeta = bookOfPower.itemMeta as EnchantmentStorageMeta
        powerMeta.addStoredEnchant(Enchantment.ARROW_DAMAGE, 1, true)
        bookOfPower.itemMeta = powerMeta
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("book_of_power"),
                bookOfPower
            ).apply {
                shape(
                    "1  ",
                    " 22",
                    " 23"
                )
                setIngredient('1',Material.FLINT)
                setIngredient('2',Material.PAPER)
                setIngredient('3',Material.BONE)
            }
        )
        val bookOfProtection = ItemStack(Material.ENCHANTED_BOOK)
        val bookOfProtectionMeta = bookOfProtection.itemMeta as EnchantmentStorageMeta
        bookOfProtectionMeta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,true)
        bookOfProtection.itemMeta = bookOfProtectionMeta
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("book_of_protection"),
                bookOfProtection
            ).apply {
                shape(
                    "   ",
                    " 11",
                    " 12"
                )
                setIngredient('1',Material.PAPER)
                setIngredient('2',Material.IRON_INGOT)
            }
        )
        val artemisBook = ItemStack(Material.ENCHANTED_BOOK)
        val artemisBookMeta = artemisBook.itemMeta as EnchantmentStorageMeta
        artemisBookMeta.addStoredEnchant(Enchantment.PROTECTION_PROJECTILE,1,true)
        artemisBook.itemMeta = artemisBookMeta
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("artemis_book"),
                artemisBook
            ).apply {
                shape(
                    "   ",
                    " 11",
                    " 12"
                )
                setIngredient('1',Material.PAPER)
                setIngredient('2',Material.ARROW)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("dragon_armor"),
                Item.dragon_armor
            ).apply {
                shape(
                    " 1 ",
                    " 2 ",
                    "343"
                )
                setIngredient('1',Material.MAGMA_CREAM)
                setIngredient('2',Material.DIAMOND_CHESTPLATE)
                setIngredient('3',Material.OBSIDIAN)
                setIngredient('4',Material.ANVIL)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("brewing_artifact"),
                ItemStack(Material.NETHER_WART)
            ).apply {
                shape(
                    " 1 ",
                    "121",
                    " 1 "
                )
                setIngredient('1',Material.WHEAT_SEEDS)
                setIngredient('2',Material.SPIDER_EYE)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("nether_artifact"),
                ItemStack(Material.BLAZE_ROD)
            ).apply {
                shape(
                    "121",
                    "131",
                    "121"
                )
                setIngredient('1',Material.GRASS_BLOCK)
                setIngredient('2',Material.LAVA_BUCKET)
                setIngredient('3',Material.FIREWORK_ROCKET)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("leather_economy"),
                ItemStack(Material.LEATHER,8)
            ).apply {
                shape(
                    "121",
                    "121",
                    "121"
                )
                setIngredient('1',Material.STICK)
                setIngredient('2',Material.LEATHER)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("sugar_rush"),
                ItemStack(Material.SUGAR,4)

            ).apply {
                shape(
                    " 1 ",
                    "232",
                    "   "
                )
                setIngredient('1',Material.OAK_SAPLING)
                setIngredient('2',Material.WHEAT_SEEDS)
                setIngredient('3',Material.SUGAR)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("master_compass"),
                Item.Master_Compass
            ).apply {
                shape(
                    "111",
                    "121",
                    "111"
                )
                setIngredient('1',Material.REDSTONE)
                setIngredient('2',Material.COMPASS)
            }
        )
    }
}

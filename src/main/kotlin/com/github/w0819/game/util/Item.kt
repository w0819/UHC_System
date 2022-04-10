package com.github.w0819.game.util

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.Damageable
import org.bukkit.inventory.meta.EnchantmentStorageMeta
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.inventory.meta.SkullMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType


/**
 * this object is recipe result item list
 */
object Item {
    val notch_apple = ItemStack(Material.ENCHANTED_GOLDEN_APPLE).apply {
        val skullMeta = (this.itemMeta as SkullMeta)


    }

    val HolyWater = ItemStack(Material.POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Holy Water").decorate(TextDecoration.ITALIC))
            (this as PotionMeta).apply {
                addCustomEffect(PotionEffect(PotionEffectType.ABSORPTION, 2400, 2), true)
            }
        }
    }
    val tabletsOfDestiny = ItemStack(Material.ENCHANTED_BOOK).apply {
        itemMeta = itemMeta.apply {
            (this as EnchantmentStorageMeta).apply {
                addStoredEnchant(Enchantment.DAMAGE_ALL, 3, true)
                addStoredEnchant(Enchantment.FIRE_ASPECT, 1, true)
                addStoredEnchant(Enchantment.ARROW_DAMAGE, 3, true)
                addStoredEnchant(Enchantment.KNOCKBACK, 1, true)
            }
        }
    }
    var Philosopher_Pickaxe = ItemStack(Material.DIAMOND_PICKAXE, 1).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Philosopher Pickaxe"))
            (this as Damageable).damage = 1559
        }
        addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 2)
    }
    var HideOfLeviathan = ItemStack(Material.DIAMOND_LEGGINGS).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Hide of Leviathan"))
        }
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
    }
    val HermesBoots = ItemStack(Material.DIAMOND_BOOTS).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Hermes's Boots").color(TextColor.color(0, 255, 0)))
        }
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2)
        addEnchantment(Enchantment.PROTECTION_FALL, 1)
        addEnchantment(Enchantment.DURABILITY, 2)
    }
    val quick_pick = ItemStack(Material.IRON_PICKAXE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Quick Pick"))
        }
        addEnchantment(Enchantment.DIG_SPEED, 1)
    }
    val dragon_sword = ItemStack(Material.DIAMOND_SWORD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("dragon sword").decorate(TextDecoration.BOLD))
            lore(listOf(text("damage is 8")))
        }
    }
    val DeusExMachina = ItemStack(Material.POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Deus Ex Machina"))
            (this as PotionMeta).addCustomEffect(
                PotionEffect(
                    PotionEffectType.DAMAGE_RESISTANCE, 300, 4, true, true, true
                ), true
            )
        }
    }
    val dragon_armor = ItemStack(Material.DIAMOND_CHESTPLATE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Dragon Armor"))
        }
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
    }
    val Death_Scythe = ItemStack(Material.IRON_HOE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Death's Scythe"))
        }
    }
    val diceOfGod = ItemStack(Material.END_PORTAL_FRAME).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Dice of God").color(TextColor.color(0, 255, 0)))
        }
    }
    var Cupid_s_Bow = ItemStack(Material.BOW).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Cupid's Bow"))
        }
        addEnchantment(Enchantment.ARROW_DAMAGE, 2)
        addEnchantment(Enchantment.ARROW_FIRE, 1)
    }
    var golden_head = ItemStack(Material.ENCHANTED_GOLDEN_APPLE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("GOLDEN HEAD!!!").decorate(TextDecoration.BOLD))
        }
    }
    val panacea = ItemStack(Material.POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Instant Health IV Potion"))
            lore(listOf(text("Panacea")))
            (this as PotionMeta).addCustomEffect(PotionEffect(PotionEffectType.HEAL, 20, 2), true)
        }
    }
    val Forge = ItemStack(Material.FURNACE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Forge").color(TextColor.color(0, 255, 0)))
        }
    }
    var Fenrir = ItemStack(Material.WOLF_SPAWN_EGG).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Fenrir").color(TextColor.color(220, 20, 60)))
        }
    }
    var FlaskOfCleansing = ItemStack(Material.SPLASH_POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Flask of Cleansing"))
            (this as PotionMeta).addCustomEffect(
                PotionEffect(PotionEffectType.WEAKNESS, 240, 2, true, true, true), true
            )
        }
    }
    var FlaskOfIchor = ItemStack(Material.SPLASH_POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Flask of Ichor").color(TextColor.color(0, 255, 0)))
            (this as PotionMeta).addCustomEffect(PotionEffect(PotionEffectType.HARM, 40, 3, true, true, true), true)
        }
    }
    val fusionArmorChestplate = ItemStack(Material.DIAMOND_CHESTPLATE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Fusion Armor").color(TextColor.color(0, 255, 0)))
        }
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
    }
    val fusionArmorLeggings = ItemStack(Material.DIAMOND_LEGGINGS).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Fusion Armor").color(TextColor.color(0, 255, 0)))
        }
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
    }
    val fusionArmorBoots = ItemStack(Material.DIAMOND_BOOTS).apply {
        itemMeta = itemMeta.apply {
            displayName(text("fusion Armor"))
        }
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
    }
    val fusionArmorHelmet = ItemStack(Material.DIAMOND_HELMET).apply {
        itemMeta = itemMeta.apply {
            displayName(text("fusion Armor"))
        }
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
    }
    val fusionArmorList = arrayListOf(
        fusionArmorBoots, fusionArmorLeggings, fusionArmorChestplate, fusionArmorHelmet
    )
    val Nectar = ItemStack(Material.POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Nectar"))
            (this as PotionMeta).addCustomEffect(
                PotionEffect(PotionEffectType.REGENERATION, 160, 2, true, true, true), true
            )
        }
    }
    var PotionOfVitality = ItemStack(Material.SPLASH_POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Potion of Vitality"))
            (this as PotionMeta).apply {
                addCustomEffect(PotionEffect(PotionEffectType.SPEED, 240, 2), true)
                addCustomEffect(PotionEffect(PotionEffectType.REGENERATION, 180, 2), true)
                addCustomEffect(PotionEffect(PotionEffectType.WEAKNESS, 240, 2), true)
                addCustomEffect(PotionEffect(PotionEffectType.WITHER, 120, 2), true)
            }

        }
    }
    var PotionofToughness = ItemStack(Material.POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Potion of Toughness"))
            (this as PotionMeta).addCustomEffect(
                PotionEffect(
                    PotionEffectType.DAMAGE_RESISTANCE, 2400, 2, true, true, true
                ), true
            )
        }
    }
    val vorpal_sword = ItemStack(Material.IRON_SWORD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Vorpal Sword"))
        }
        addEnchantment(Enchantment.DAMAGE_ARTHROPODS, 2)
        addEnchantment(Enchantment.DAMAGE_UNDEAD, 2)
        addEnchantment(Enchantment.LOOT_BONUS_MOBS, 2)
    }
    val VoidBox = ItemStack(Material.ENDER_CHEST, 2)
    var Professions = ItemStack(Material.CRAFTING_TABLE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Professions").color(TextColor.color(255, 0, 0)))
            lore(Lore1)
        }
    }

    var Potion_of_velocity = ItemStack(Material.SPLASH_POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Potion of Velocity"))
            (this as PotionMeta).addCustomEffect(PotionEffect(PotionEffectType.SPEED, 1000, 1), true)
        }
    }
    var carrot = ItemStack(Material.GOLDEN_CARROT).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Speed UHC Shop").color(TextColor.color(0, 255, 0)))
        }
    }
    var Cornucopia = ItemStack(Material.GOLDEN_CARROT).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Cornucopia"))
        }
    }
    var Barbarian_Chestplate = ItemStack(Material.DIAMOND_CHESTPLATE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Barbarian Chestplate"))
        }
        addEnchantment(Enchantment.PROTECTION_FIRE, 1)
    }
    var Bloodlust = ItemStack(Material.DIAMOND_SWORD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Bloodlust"))
        }
    }
    val backPack = ItemStack(Material.CHEST).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Back Pack").color(TextColor.color(0, 255, 0)))
        }
    }

    /*
    * 현재 쓰이지 않고 있는 변수는
    * 아이템 추가 및 이벤트추가로 쓰일예정
    * 나중에 쓰일 예정
    * */
    private val Lore = listOf<Component>(
        text("Purchase from a selection of\n"),
        text("kits to provide you with items\n"),
        text("at the beginning of a game!\n"),
        text("Upgrade and prestige kits to get\n"),
        text("better items!\n"),
        text("\n"),
        text("Click to open!").apply { decorate(TextDecoration.ITALIC);color(TextColor.color(255, 255, 0)) },
        text("\n")
    )
    private val Lore1 = listOf<Component>(
        text("Select from a collection of\nunique professions which will\ngive you access to new recipes\nand perks!\n\n"),
        text("Click to open!").color(TextColor.color(255, 255, 0))
    )
    private val Lore2 = listOf<Component>(text("Extra Ultimates require 2 or\nmore maxed out professions"))
    var kits = ItemStack(Material.IRON_SWORD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Kits").color(TextColor.color(0, 255, 0)))
            lore(Lore)
        }
    }
    var King_s_Rod = ItemStack(Material.FISHING_ROD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("King's Rod"))
        }
        addEnchantment(Enchantment.LURE, 3)
        addEnchantment(Enchantment.DURABILITY, 3)
    }
    val LumberjackAxe = ItemStack(Material.IRON_AXE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Lumberjack Axe").color(TextColor.color(0, 255, 0)))
        }
    }
    val key = NamespacedKey.minecraft("this_is_key")
    var SevenleagueBoots = ItemStack(Material.DIAMOND_BOOTS).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Seven league Boots"))
        }
        addEnchantment(Enchantment.PROTECTION_FALL, 3)
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3)
    }
    val shop = ItemStack(Material.EMERALD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Shop").color(TextColor.color(127, 255, 0)))
        }
    }
    var Shoes_of_Vidar = ItemStack(Material.DIAMOND_BOOTS).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Shoes of Vidar"))
        }
        addEnchantment(Enchantment.DURABILITY, 3)
        addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2)
        addEnchantment(Enchantment.THORNS, 1)
    }
    val ExpertSeal = ItemStack(Material.NETHER_STAR).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Expert Seal").decorate(TextDecoration.ITALIC))
        }
    }
    val Essence_of_yggdrasil = ItemStack(Material.ENCHANTING_TABLE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Essence of Yggdrasil"))
        }
    }
    val Excalibur = ItemStack(Material.DIAMOND_SWORD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Excalibur").color(TextColor.color(0, 255, 0)))
        }
    }
    val chest_of_fate = ItemStack(Material.PLAYER_HEAD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Chest of Fate").decorate(TextDecoration.BOLD))
        }
    }
    var Enchantment_Book = ItemStack(Material.ENCHANTING_TABLE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Enchantment Book *사용하려면 우클릭 하세요*"))
        }
    }

    val spiked_armor = ItemStack(Material.LEATHER_CHESTPLATE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Spiked Armor"))
        }
        addEnchantment(Enchantment.THORNS, 1)
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
    }
    val Exodus = ItemStack(Material.DIAMOND_HELMET).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Exodus"))
        }
        addEnchantment(Enchantment.DURABILITY, 3)
    }
    val Master_Compass = ItemStack(Material.COMPASS).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Master's Compass"))
        }
    }
    val apple = ItemStack(Material.GOLDEN_APPLE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("UHC Champions Shop"))
            lore(listOf(text("Chick here to access the\nUHC Champions Shop.")))
        }
    }
    val Ambrosia = ItemStack(Material.GLOWSTONE_DUST)
    var Andūril = ItemStack(Material.IRON_SWORD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Andūril"))
        }
        addEnchantment(Enchantment.DAMAGE_ALL, 2)
    }
    var AxeOfPerun = ItemStack(Material.DIAMOND_AXE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Axe of Perun"))
        }
        addEnchantment(Enchantment.DURABILITY, 1)
    }
    var Artemis_Bow = ItemStack(Material.BOW).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Artemis Bow"))
        }
        addEnchantment(Enchantment.ARROW_DAMAGE, 3)
    }
    var apprentice_Helmet = ItemStack(Material.IRON_HELMET).apply {
        itemMeta = itemMeta.apply {
            displayName(text("apprentice Helmet").decorate(TextDecoration.BOLD))
        }
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1)
        addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1)
        addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1)
        addEnchantment(Enchantment.PROTECTION_FIRE, 1)
    }
    var apprentice_Sword = ItemStack(Material.IRON_SWORD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Apprentice Sword").decorate(TextDecoration.BOLD))
        }
    }
    var apprentice_Bow = ItemStack(Material.BOW).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Apprentice Bow").decorate(TextDecoration.BOLD))
        }
    }
    var tarnhelm = ItemStack(Material.DIAMOND_HELMET).apply {
        itemMeta = itemMeta.apply {
            displayName(text("tarnhelm").decorate(TextDecoration.BOLD))
        }
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1)
        addEnchantment(Enchantment.PROTECTION_FIRE, 1)
        addEnchantment(Enchantment.WATER_WORKER, 1)
    }
    var FateSCall = ItemStack(Material.FLOWER_POT).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Fate's Call").decorate(TextDecoration.BOLD).color(TextColor.color(50, 205, 50)))
        }
    }

    val recipeBook = ItemStack(Material.ENCHANTED_BOOK).apply {
        itemMeta = itemMeta.apply {
            displayName(text("recipe_book"))
        }
    }
    var ModularBow = ItemStack(Material.BOW).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Modular Bow").color(TextColor.color(0, 255, 0)))
        }
        addEnchantment(Enchantment.ARROW_KNOCKBACK, 1)
    }
    val close = ItemStack(Material.BARRIER).apply {
        itemMeta = itemMeta.apply {
            displayName(text("close").color(TextColor.color(255, 0, 0)))
        }
    }
    val settings = ItemStack(Material.COMPARATOR).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Settings").color(TextColor.color(255, 0, 0)))
        }
    }
    val left = ItemStack(Material.ARROW).apply {
        itemMeta = itemMeta.apply {
            displayName(text("left"))
        }
    }
    val right = ItemStack(Material.ARROW).apply {
        itemMeta = itemMeta.apply {
            displayName(text("right"))
        }
    }
}

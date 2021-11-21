package com.github.w0819.game.util

import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.Damageable
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType


object Item {

    var notch_apple = ItemStack(Material.ENCHANTED_GOLDEN_APPLE).apply {
    }

    var HolyWater = ItemStack(Material.POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Holy Water").decorate(TextDecoration.ITALIC))
            (this as PotionMeta).apply {
                addCustomEffect(PotionEffect(PotionEffectType.HEAL,20,5),true)
                addCustomEffect(PotionEffect(PotionEffectType.ABSORPTION,2400,2),true)
            }
        }
    }
    var Philosopher_Pickaxe = ItemStack(Material.DIAMOND_PICKAXE,1).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Philosopher Pickaxe"))
            (this as Damageable).damage = 1559
        }
        addEnchantment(Enchantment.LOOT_BONUS_BLOCKS,2)
    }
    var HideOfLeviathan = ItemStack(Material.DIAMOND_LEGGINGS).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Hide of Leviathan"))
        }
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,4)
    }
    var quick_pick = ItemStack(Material.IRON_PICKAXE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Quick Pick"))
        }
        addEnchantment(Enchantment.DIG_SPEED,1)
    }
    var dragon_sword = ItemStack(Material.DIAMOND_SWORD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("dragon sword").decorate(TextDecoration.BOLD))
            setLocalizedName("damage is 8")

        }
    }
    var DeusExMachina = ItemStack(Material.POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Deus Ex Machina"))
            (this as PotionMeta).addCustomEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,300,4,true,true,true),true)
        }
    }
    var dragon_armor = ItemStack(Material.DIAMOND_CHESTPLATE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Dragon Armor"))
        }
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,4)
    }
    var Cupid_s_Bow = ItemStack(Material.BOW).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Cupid's Bow"))
        }
        addEnchantment(Enchantment.ARROW_DAMAGE,2)
        addEnchantment(Enchantment.ARROW_FIRE,1)
    }
    var golden_head = ItemStack(Material.ENCHANTED_GOLDEN_APPLE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("GOLDEN HEAD!!!").decorate(TextDecoration.BOLD))
        }
    }
    var panacea = ItemStack(Material.POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Instant Health IV Potion"))
            setLocalizedName("Panacea")
        }
    }
    var Fenrir = ItemStack(Material.WOLF_SPAWN_EGG).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Fenrir").color(TextColor.color(220,20,60)))
        }
    }
    var FlaskOfCleansing = ItemStack(Material.SPLASH_POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Flask of Cleansing"))
            (this as PotionMeta).addCustomEffect(PotionEffect(PotionEffectType.WEAKNESS,240,2,true,true,true),true)
        }
    }
    var FlaskOfIchor = ItemStack(Material.SPLASH_POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Flask of Ichor"))
            (this as PotionMeta).addCustomEffect(PotionEffect(PotionEffectType.HARM,100,3,true,true,true),true)
        }
    }
    var Nectar = ItemStack(Material.POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Nectar"))
            (this as PotionMeta).addCustomEffect(PotionEffect(PotionEffectType.REGENERATION,160,2,true,true,true),true)
        }
    }
    var PotionOfVitality = ItemStack(Material.SPLASH_POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Potion of Vitality"))
            (this as PotionMeta).apply {
                addCustomEffect(PotionEffect(PotionEffectType.SPEED,240,2),true)
                addCustomEffect(PotionEffect(PotionEffectType.REGENERATION,180,2),true)
                addCustomEffect(PotionEffect(PotionEffectType.WEAKNESS,240,2),true)
                addCustomEffect(PotionEffect(PotionEffectType.WITHER,120,2), true)
            }

        }
    }
    var PotionofToughness = ItemStack(Material.POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Potion of Toughness"))
            (this as PotionMeta).addCustomEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,2400,2,true,true,true),true)
        }
    }
    var vorpal_sword = ItemStack(Material.IRON_SWORD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Vorpal Sword"))
        }
        addEnchantment(Enchantment.DAMAGE_ARTHROPODS,2)
        addEnchantment(Enchantment.DAMAGE_UNDEAD,2)
        addEnchantment(Enchantment.LOOT_BONUS_MOBS,2)
    }


    var Potion_of_velocity = ItemStack(Material.SPLASH_POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Potion of Velocity"))
            (this as PotionMeta).addCustomEffect(PotionEffect(PotionEffectType.SPEED,1000,1),true)
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
        addEnchantment(Enchantment.PROTECTION_FIRE,1)
    }
    var Bloodlust = ItemStack(Material.DIAMOND_SWORD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Bloodlust"))
        }
    }
    var King_s_Rod = ItemStack(Material.FISHING_ROD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("King's Rod"))
        }
        addEnchantment(Enchantment.LURE,3)
        addEnchantment(Enchantment.DURABILITY,3)
    }
    var SevenleagueBoots = ItemStack(Material.DIAMOND_BOOTS).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Seven league Boots"))
        }
        addEnchantment(Enchantment.PROTECTION_FALL,3)
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3)
    }
    var Shoes_of_Vidar = ItemStack(Material.DIAMOND_BOOTS).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Shoes of Vidar"))
        }
        addEnchantment(Enchantment.DURABILITY,3)
        addEnchantment(Enchantment.PROTECTION_PROJECTILE,2)
        addEnchantment(Enchantment.THORNS,1)
    }
    var ExpertSeal = ItemStack(Material.NETHER_STAR).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Expert Seal").decorate(TextDecoration.ITALIC))
        }
    }
    var Essence_of_yggdrasil = ItemStack(Material.ENCHANTING_TABLE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Essence of Yggdrasil"))
        }
    }
    var chest_of_fate = ItemStack(Material.PLAYER_HEAD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Chest of Fate").decorate(TextDecoration.BOLD))
        }
    }
    var Enchantment_Book = ItemStack(Material.ENCHANTING_TABLE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Enchantment Book *사용하려면 우클릭 하세요*"))
        }
    }

    var spiked_armor = ItemStack(Material.LEATHER_CHESTPLATE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Spiked Armor"))
        }
        addEnchantment(Enchantment.THORNS,1)
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,4)
    }
    var Exodus = ItemStack(Material.DIAMOND_HELMET).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Exodus"))
        }
        addEnchantment(Enchantment.DURABILITY,3)
    }
    var Master_Compass = ItemStack(Material.COMPASS).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Master's Compass"))
        }
    }
    var Andūril = ItemStack(Material.IRON_SWORD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Andūril"))
        }
        addEnchantment(Enchantment.DAMAGE_ALL,2)
    }
    var AxeOfPerun = ItemStack(Material.DIAMOND_AXE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Axe of Perun"))
        }
        addEnchantment(Enchantment.DURABILITY,1)
    }
    var Artemis_Bow = ItemStack(Material.BOW).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Artemis Bow"))
        }
        addEnchantment(Enchantment.ARROW_DAMAGE,3)
    }
    var apprentice_Helmet = ItemStack(Material.IRON_HELMET).apply {
        itemMeta = itemMeta.apply {
            displayName(text("apprentice Helmet").decorate(TextDecoration.BOLD))
        }
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1)
        addEnchantment(Enchantment.PROTECTION_EXPLOSIONS,1)
        addEnchantment(Enchantment.PROTECTION_PROJECTILE,1)
        addEnchantment(Enchantment.PROTECTION_FIRE,1)
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
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1)
        addEnchantment(Enchantment.PROTECTION_FIRE,1)
        addEnchantment(Enchantment.WATER_WORKER,1)
    }
    var FateSCall = ItemStack(Material.FLOWER_POT).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Fate's Call").decorate(TextDecoration.BOLD).color(TextColor.color(50,205,50)))
        }
    }

    val recipeBook = ItemStack(Material.ENCHANTED_BOOK).apply {
        itemMeta = itemMeta.apply {
            displayName(text("recipe_book"))
        }
    }
    var ModularBow = ItemStack(Material.BOW).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Modular Bow"))
        }
        addEnchantment(Enchantment.ARROW_KNOCKBACK,1)
    }
}

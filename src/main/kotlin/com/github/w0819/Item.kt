package com.github.w0819

import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack


object Item {
    var vorpal_sword = ItemStack(Material.IRON_SWORD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Vorpal Sword"))
        }
        addEnchantment(Enchantment.DAMAGE_ARTHROPODS,2)
        addEnchantment(Enchantment.DAMAGE_UNDEAD,2)
        addEnchantment(Enchantment.LOOT_BONUS_MOBS,2)
    }
    var notch_apple = ItemStack(Material.ENCHANTED_GOLDEN_APPLE).apply {
    }
    var Philosopher_Pickaxe = ItemStack(Material.DIAMOND_PICKAXE,1).apply {
        itemMeta = itemMeta.apply {
        }
    }
    var quick_pick = ItemStack(Material.IRON_PICKAXE).apply {
        addEnchantment(Enchantment.DIG_SPEED,1)
    }
    var dragon_sword = ItemStack(Material.DIAMOND_SWORD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("dragon sword").decorate(TextDecoration.BOLD))
            setLocalizedName("damage is 8")

        }
        addEnchantment(Enchantment.DAMAGE_ALL,2)
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
    var Potion_of_velocity = ItemStack(Material.POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Potion of Velocity"))
        }
    }
    var Cornucopia = ItemStack(Material.GOLDEN_CARROT).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Cornucopia"))
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
    var golden_head = ItemStack(Material.PLAYER_HEAD).apply {
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
    var potion_of_toughness = ItemStack(Material.POTION).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Potion of Toughness"))
        }
    }
    var Andūril = ItemStack(Material.IRON_SWORD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Andūril"))
        }
        addEnchantment(Enchantment.DAMAGE_ALL,2)
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

    val recipeBook = ItemStack(Material.ENCHANTED_BOOK).apply {
        itemMeta = itemMeta.apply {
            displayName(text("recipe_book"))
        }
    }
}


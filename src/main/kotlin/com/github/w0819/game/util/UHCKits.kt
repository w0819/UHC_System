package com.github.w0819.game.util

import com.github.w0819.plugin.UHCPlugin
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

val choiceKit = NamespacedKey.minecraft("choice")
val empty = NamespacedKey.minecraft("emptyLevel")
val LeatherArmor = NamespacedKey.minecraft("LeatherArmorLevel")
val EnchantingSet = NamespacedKey.minecraft("EnchantingSetLevel")
val ArcherySet = NamespacedKey.minecraft("ArcherySetLevel")
val StoneGear = NamespacedKey.minecraft("StoneGearLevel")
val LunchBox = NamespacedKey.minecraft("LunchBoxLevel")
val Looter = NamespacedKey.minecraft("LooterLevel")
val Ecologist = NamespacedKey.minecraft("EcologistLevel")
val Farmer = NamespacedKey.minecraft("EcologistLevel")
val Horseman = NamespacedKey.minecraft("HorsemanLevel")
val Trapper = NamespacedKey.minecraft("TrapperLevel")

enum class KitList {
    Empty,
    LeatherArmor,
    EnchantingSet,
    ArcherySet,
    StoneGear,
    LunchBox,
    Looter,
    Ecologist,
    Farmer,
    Horseman,
    Trapper
}
fun choiceKitItemGive(player: Player) {
    val kit = player.persistentDataContainer.get(choiceKit, PersistentDataType.INTEGER)
    val levelList = listOf(player.persistentDataContainer.get(empty, PersistentDataType.INTEGER),
        player.persistentDataContainer.get(LeatherArmor, PersistentDataType.INTEGER),
        player.persistentDataContainer.get(EnchantingSet,PersistentDataType.INTEGER),
        player.persistentDataContainer.get(ArcherySet,PersistentDataType.INTEGER),
        player.persistentDataContainer.get(StoneGear,PersistentDataType.INTEGER),
        player.persistentDataContainer.get(LunchBox,PersistentDataType.INTEGER),
        player.persistentDataContainer.get(Looter,PersistentDataType.INTEGER),
        player.persistentDataContainer.get(Ecologist, PersistentDataType.INTEGER),
        player.persistentDataContainer.get( Farmer,PersistentDataType.INTEGER),
        player.persistentDataContainer.get(Horseman,PersistentDataType.INTEGER),
        player.persistentDataContainer.get(Trapper, PersistentDataType.INTEGER))
    val list = KitList.values()
    val items = eachKitDesignateItem(list[kit!!],levelList[kit])
    if (UHCPlugin.game.timer.running) {
        for (i in items) {
            player.inventory.addItem(i)
        }
    }
}
/**
 * 눈뽕주의
 * */
private fun eachKitDesignateItem(kit: KitList,level: Int?): List<ItemStack> {

    val empty = listOf(ItemStack(Material.AIR))
    when (kit) {
        KitList.Empty -> {
            empty
        }
        KitList.LeatherArmor -> {
            val list = listOf(
                ItemStack(Material.LEATHER_HELMET), ItemStack(Material.LEATHER_CHESTPLATE),
                ItemStack(Material.LEATHER_LEGGINGS), ItemStack(Material.LEATHER_BOOTS)
            )
            return when (level) {
                1 -> {
                    for (i in list) i.apply {
                        itemMeta = itemMeta.apply { addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1) }
                    }
                    list
                }
                2 -> {
                    for (i in list) i.apply {
                        itemMeta = itemMeta.apply { i.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2) }
                    }
                    list
                }
                3 -> {
                    for (i in list) i.apply {
                        itemMeta = itemMeta.apply { i.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 3) }
                    }
                    list
                }
                4 -> {
                    empty
                }
                0 -> list
                else -> empty
            }
        }
        KitList.EnchantingSet -> {
            return when (level) {
                1 -> listOf(ItemStack(Material.BOOK, 2), ItemStack(Material.EXPERIENCE_BOTTLE, 10))
                2 -> listOf(ItemStack(Material.BOOK, 3), ItemStack(Material.EXPERIENCE_BOTTLE, 12))
                3 -> listOf(ItemStack(Material.BOOK, 4),
                    ItemStack(Material.EXPERIENCE_BOTTLE, 15),
                    ItemStack(Material.LAPIS_LAZULI, 18),
                    ItemStack(Material.STONE_PICKAXE).apply {
                        itemMeta = itemMeta.apply {
                            addEnchantment(
                                Enchantment.DIG_SPEED,
                                3
                            );addEnchantment(Enchantment.DURABILITY, 1)
                        }
                    })
                4 -> empty
                0 -> listOf(ItemStack(Material.BOOK, 1), ItemStack(Material.EXPERIENCE_BOTTLE, 7))
                else -> empty
            }
        }
        KitList.ArcherySet -> {
            return when (level) {
                1 -> listOf(ItemStack(Material.STRING, 4), ItemStack(Material.FEATHER, 5))
                2 -> listOf(ItemStack(Material.STRING, 5), ItemStack(Material.FEATHER, 7))
                3 -> listOf(
                    ItemStack(Material.STRING, 6),
                    ItemStack(Material.FEATHER, 9),
                    ItemStack(Material.STONE_SHOVEL).apply {
                        itemMeta = itemMeta.apply {
                            addEnchantment(
                                Enchantment.DIG_SPEED,
                                3
                            );addEnchantment(Enchantment.DURABILITY, 1)
                        }
                    })
                4 -> empty
                0 -> listOf(ItemStack(Material.STRING, 3), ItemStack(Material.FEATHER, 3))
                else -> empty
            }
        }
        KitList.StoneGear -> {
            val list = listOf(
                ItemStack(Material.STONE_PICKAXE),
                ItemStack(Material.STONE_SHOVEL),
                ItemStack(Material.STONE_AXE),
                ItemStack(Material.STONE_HOE),
                ItemStack(Material.STONE_SWORD)
            )
            return when (level) {
                1 -> {
                    for (i in list) i.apply { itemMeta = itemMeta.apply { addEnchantment(Enchantment.DIG_SPEED, 1) } }
                    list
                }
                2 -> {
                    for (i in list) i.apply { itemMeta = itemMeta.apply { addEnchantment(Enchantment.DIG_SPEED, 2) } }
                    list
                }
                3 -> {
                    for (i in list) i.apply { itemMeta = itemMeta.apply { addEnchantment(Enchantment.DIG_SPEED, 3) } }
                    list
                }
                4 -> empty
                0 -> list
                else -> empty
            }
        }
        KitList.LunchBox -> {
            return when(level) {
                1 -> listOf(ItemStack(Material.COOKED_BEEF,5), ItemStack(Material.CARROT,4),
                    ItemStack(Material.APPLE,2))
                2 -> listOf(ItemStack(Material.COOKED_BEEF,7),
                    ItemStack(Material.CARROT,8), ItemStack(Material.APPLE)
                )
                3 -> listOf(ItemStack(Material.COOKED_BEEF,9), ItemStack(Material.CARROT,12),
                    ItemStack(Material.MELON_SLICE,2), ItemStack
                (Material.GOLD_INGOT,3)
                )
                4 -> empty
                0 -> listOf(ItemStack(Material.COOKED_BEEF,3),ItemStack(Material.APPLE))
                else -> empty
            }
        }
        KitList.Looter -> {
            val list = listOf(ItemStack(Material.BONE),ItemStack(Material.SLIME_BALL))
            return when(level) {
                1 -> {
                    val list1 = listOf(ItemStack(Material.BONE),ItemStack(Material.SLIME_BALL))
                    for (i in list1) i.amount = 2
                    list1
                }
                2 -> {
                    val list1 = listOf(ItemStack(Material.BONE,2),ItemStack(Material.SLIME_BALL,2),
                        ItemStack(Material.GUNPOWDER,1),ItemStack(Material.SPIDER_EYE,1))
                    list1
                }
                3 -> {
                    val list1 = listOf(ItemStack(Material.BONE,3), ItemStack(Material.SLIME_BALL,3),
                    ItemStack(Material.GUNPOWDER,2), ItemStack(Material.SPIDER_EYE,2),
                        ItemStack(Material.STONE_SWORD).apply { itemMeta = itemMeta.apply { addEnchantment(Enchantment.LOOT_BONUS_MOBS,1) } })
                    list1
                }
                4 -> empty
                0 -> list
                else -> empty
            }
        }
        KitList.Ecologist -> {
            return when(level) {
                1 -> listOf(ItemStack(Material.VINE,15), ItemStack(Material.LILY_PAD,16), ItemStack(Material.SUGAR_CANE,4))
                2 -> listOf(ItemStack(Material.VINE,18), ItemStack(Material.LILY_PAD,32), ItemStack(ItemStack(Material.SUGAR_CANE,8)))
                4 -> empty
                3 -> listOf(ItemStack(Material.VINE,21), ItemStack(Material.LILY_PAD,64), ItemStack(Material.SUGAR_CANE,12),ItemStack(Material.STONE_PICKAXE).apply { itemMeta = itemMeta.apply { addEnchantment(Enchantment.DIG_SPEED,3);addEnchantment(Enchantment.DURABILITY,1) } })
                0 -> listOf(ItemStack(Material.VINE,12),ItemStack(Material.LILY_PAD,8))
                else -> empty
            }
        }
        KitList.Farmer -> {
            return when(level) {
                1 -> listOf(ItemStack(Material.GOLDEN_HOE),ItemStack(Material.MELON_SLICE),ItemStack(Material.CARROT,2), ItemStack(Material.BONE_MEAL))
                2 -> listOf(ItemStack(Material.IRON_HOE), ItemStack(Material.MELON_SLICE,2), ItemStack(Material.CARROT,2),ItemStack(Material.BONE_MEAL,3))
                3 -> listOf(ItemStack(Material.IRON_HOE), ItemStack(Material.MELON_SLICE,3), ItemStack(Material.CARROT,3),ItemStack(Material.BONE_MEAL))
                4 -> empty
                0 -> listOf(ItemStack(Material.STONE_HOE,1),ItemStack(Material.MELON_SEEDS,1),ItemStack(Material.BONE_MEAL,1))
                else -> empty
            }
        }
        KitList.Horseman -> {
            return when(level) {
                1 -> listOf(ItemStack(Material.LEATHER,6), ItemStack(Material.WHEAT,5), ItemStack(Material.STRING,2))
                2 -> listOf(ItemStack(Material.LEATHER,9), ItemStack(Material.WHEAT,7), ItemStack(Material.STRING,3))
                3 -> listOf(ItemStack(Material.LEATHER,12), ItemStack(Material.HAY_BLOCK,1), ItemStack(Material.STRING,4), ItemStack(Material.GOLDEN_HORSE_ARMOR,1), ItemStack(Material.HORSE_SPAWN_EGG))
                4 -> empty
                0 -> listOf(ItemStack(Material.LEATHER,3),ItemStack(Material.WHEAT,3))
                else -> empty
            }
        }
        KitList.Trapper -> {
            return when(level) {
                1 -> listOf(ItemStack(Material.PISTON,4), ItemStack(Material.STICKY_PISTON,4), ItemStack(Material.REDSTONE,15),ItemStack(Material.OAK_LOG,8))
                2 -> listOf(ItemStack(Material.PISTON,6), ItemStack(Material.STICKY_PISTON,6), ItemStack(Material.REDSTONE,20),ItemStack(Material.OAK_LOG,12))
                3 -> listOf(ItemStack(Material.PISTON,8), ItemStack(Material.STICKY_PISTON,8), ItemStack(Material.REDSTONE,25),ItemStack(Material.OAK_LOG,16))
                4 -> empty
                0 -> listOf(ItemStack(Material.PISTON,2), ItemStack(Material.STICKY_PISTON,2), ItemStack(Material.REDSTONE,10),ItemStack(Material.OAK_LOG,4))
                else -> empty
            }
        }
    }
    return empty
}



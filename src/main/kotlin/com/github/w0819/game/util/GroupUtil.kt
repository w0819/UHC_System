package com.github.w0819.game.util

import org.bukkit.Material
import org.bukkit.event.entity.EntityDamageEvent

/**
 * 집단의 모음
 */
object GroupUtil {
    val swordList = listOf(
        Material.IRON_SWORD, Material.STONE_SWORD, Material.DIAMOND_SWORD, Material.GOLDEN_SWORD,
        Material.WOODEN_SWORD, Material.NETHERITE_SWORD
    )

    val naturalDamageEvent = listOf(
        EntityDamageEvent.DamageCause.FALL,
        EntityDamageEvent.DamageCause.FIRE,
        EntityDamageEvent.DamageCause.CONTACT,
        EntityDamageEvent.DamageCause.FIRE_TICK,
        EntityDamageEvent.DamageCause.FLY_INTO_WALL,
        EntityDamageEvent.DamageCause.FREEZE,
        EntityDamageEvent.DamageCause.LAVA,
        EntityDamageEvent.DamageCause.LIGHTNING,
        EntityDamageEvent.DamageCause.STARVATION,
        EntityDamageEvent.DamageCause.THORNS,
        EntityDamageEvent.DamageCause.VOID
    )

    val flowers = listOf(
        Material.ALLIUM,Material.AZURE_BLUET,Material.BLUE_ORCHID,Material.CORNFLOWER,Material.DANDELION,Material.LILAC,
        Material.LILY_OF_THE_VALLEY,Material.OXEYE_DAISY,Material.PEONY,Material.POPPY,Material.ROSE_BUSH,Material.SUNFLOWER,
        Material.ORANGE_TULIP,Material.PINK_TULIP,Material.POTTED_ORANGE_TULIP,Material.POTTED_PINK_TULIP,Material.RED_TULIP,
        Material.POTTED_RED_TULIP,Material.POTTED_WHITE_TULIP,Material.WHITE_TULIP
    )

    val nonSurvivalItems = listOf(
        Material.COMMAND_BLOCK, Material.COMMAND_BLOCK_MINECART,
        Material.BARRIER, Material.CHAIN_COMMAND_BLOCK, Material.REPEATING_COMMAND_BLOCK
    )

    val ores = listOf(
        Material.COAL_ORE,Material.COPPER_ORE,Material.GOLD_ORE,Material.DEEPSLATE_COAL_ORE,Material.DEEPSLATE_COPPER_ORE,Material.DEEPSLATE_DIAMOND_ORE,
        Material.DEEPSLATE_EMERALD_ORE,Material.DEEPSLATE_GOLD_ORE,Material.DEEPSLATE_IRON_ORE,Material.DEEPSLATE_LAPIS_ORE,Material.DEEPSLATE_REDSTONE_ORE,
        Material.DIAMOND_ORE,Material.EMERALD_ORE,Material.IRON_ORE,Material.LAPIS_ORE,Material.NETHER_GOLD_ORE,Material.NETHER_QUARTZ_ORE,Material.REDSTONE_ORE
    )
}
package com.github.w0819.event

import com.github.w0819.enchant.AddDamage
import com.github.w0819.enchant.ReviveToken
import com.github.w0819.game.uhc.modifiers.*
import com.github.w0819.game.uhc.recipes.DragonArmor
import com.github.w0819.game.uhc.recipes.DragonSword
import com.github.w0819.game.util.ExtraUltimates
import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import com.github.w0819.game.util.readInstanceProperty
import com.github.w0819.plugin.UHCPlugin
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.entity.EnderDragon
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityDamageEvent.DamageCause
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.entity.ProjectileLaunchEvent
import org.bukkit.event.inventory.CraftItemEvent
import org.bukkit.event.player.PlayerFishEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack

class ModifierEvent : Listener {
    @EventHandler
    fun onPlayerInteraction(e: PlayerInteractEvent) {
        val player = e.player
        when(e.item) {
            ItemStack(Material.EMERALD,4).apply { addEnchantment(ReviveToken.ReviveToken,1) } -> {
                UHCPlugin.game?.teams?.find { player in it.players }?.players?.find {
                    it.isDead
                }?.apply { gameMode = GameMode.SURVIVAL }?.teleport(player.location)
            }
        }
    }
    @EventHandler
    fun onPlayerKill(e: PlayerDeathEvent) {
        val player = e.player
        val killer = player.killer ?: return
        when(UHCPlugin.game?.modifier) {
            is Gold -> e.drops.add(ItemStack(Material.GOLD_INGOT))
            is Pearl -> e.drops.add(ItemStack(Material.ENDER_PEARL))
            is DoubleHead -> e.drops.add(Item.golden_head)
            is SwordMaster -> {
                val swordList = listOf(
                    Material.IRON_SWORD,Material.STONE_SWORD,Material.DIAMOND_SWORD,Material.GOLDEN_SWORD,
                    Material.WOODEN_SWORD,Material.NETHERITE_SWORD
                )
                val item = killer.inventory.itemInMainHand
                if (item.type in swordList) {
                    val enchants = item.enchantments
                    if (enchants.containsKey(AddDamage.addDamage)) {
                        item.apply { itemMeta = itemMeta.apply { addEnchant(AddDamage.addDamage,(enchants[AddDamage.addDamage] ?: return),true) } }
                    } else {
                        item.addEnchantment(AddDamage.addDamage,AddDamage.addDamage.startLevel)
                    }
                }
            }
            is ReviveTokens -> {
                killer.inventory.addItem(ItemStack(Material.EMERALD).apply { addEnchantment(ReviveToken.ReviveToken,ReviveToken.ReviveToken.startLevel) })
            }
        }
    }
    @EventHandler
    fun onEntityDamage(e: EntityDamageEvent) {
        val naturalDamageEvent = listOf(
            DamageCause.FALL,DamageCause.FIRE,DamageCause.CONTACT,DamageCause.FIRE_TICK,DamageCause.FLY_INTO_WALL,DamageCause.FREEZE,
            DamageCause.LAVA,DamageCause.LIGHTNING,DamageCause.STARVATION,DamageCause.THORNS,DamageCause.VOID
        )
        if (e.cause in naturalDamageEvent)
            e.damage *= 3
    }
    @EventHandler
    fun onEntityDeath(e: EntityDeathEvent) {
        val killer = e.entity.killer ?: return
        when(UHCPlugin.game?.modifier) {
            is ExtraDragon -> if (e.entity is EnderDragon) {
                    killer.inventory.addItem(*listOf(DragonSword(),DragonArmor()).map { it.result }.toTypedArray())
                    ExtraDragon.spawnDragon(killer)
                }
            is Pearl -> killer.inventory.addItem(ItemStack(Material.ENDER_PEARL))
            is HealthOnKill -> HealthOnKill.addHealthOnKill(killer)
            is BowMaster -> e.drops.add(ItemStack(Material.ARROW))
        }
    }
    @EventHandler
    fun onProjectiless(e: ProjectileLaunchEvent) {
        if (UHCPlugin.game?.modifier is Projectiles) e.isCancelled = true
    }
    @EventHandler
    fun onBlockBreak(e: BlockBreakEvent) {
        val block = e.block
        val blockType = block.type
        val world = e.block.world
        val location = e.block.location
        when(UHCPlugin.game?.modifier) {
            is FlowerPower -> {
                val flowers = listOf(
                    Material.ALLIUM,Material.AZURE_BLUET,Material.BLUE_ORCHID,Material.CORNFLOWER,Material.DANDELION,Material.LILAC,
                    Material.LILY_OF_THE_VALLEY,Material.OXEYE_DAISY,Material.PEONY,Material.POPPY,Material.ROSE_BUSH,Material.SUNFLOWER,
                    Material.ORANGE_TULIP,Material.PINK_TULIP,Material.POTTED_ORANGE_TULIP,Material.POTTED_PINK_TULIP,Material.RED_TULIP,
                    Material.POTTED_RED_TULIP,Material.POTTED_WHITE_TULIP,Material.WHITE_TULIP
                )
                if (blockType in flowers) {
                    e.isDropItems = false
                    val materialList = ((Material.values().toList() - listOf(
                        Material.COMMAND_BLOCK,Material.COMMAND_BLOCK_MINECART,
                        Material.BARRIER
                    )) + readInstanceProperty<ItemStack>(Item).map { it.type })
                    world.dropItem(
                        location,
                        ItemStack(materialList.random())
                    )
                }
            }
            is Mining -> {
                val ore = listOf(
                    Material.COAL_ORE,Material.COPPER_ORE,Material.GOLD_ORE,Material.DEEPSLATE_COAL_ORE,Material.DEEPSLATE_COPPER_ORE,Material.DEEPSLATE_DIAMOND_ORE,
                    Material.DEEPSLATE_EMERALD_ORE,Material.DEEPSLATE_GOLD_ORE,Material.DEEPSLATE_IRON_ORE,Material.DEEPSLATE_LAPIS_ORE,Material.DEEPSLATE_REDSTONE_ORE,
                    Material.DIAMOND_ORE,Material.EMERALD_ORE,Material.IRON_ORE,Material.LAPIS_ORE,Material.NETHER_GOLD_ORE,Material.NETHER_QUARTZ_ORE,Material.REDSTONE_ORE
                )
                if (blockType in ore)
                    if ((1..2).random() == 1)
                        world.dropItem(location,ItemStack(block.type))
            }
        }
    }
    @EventHandler
    fun onCraftItem(e: CraftItemEvent) {
        when(UHCPlugin.game?.modifier) {
            is Fishing -> {
                if (e.recipe.result.type == Material.FISHING_ROD) {
                    e.result = Event.Result.DENY
                    e.inventory.result = Item.King_s_Rod
                }
            }
        }
    }
    @EventHandler
    fun onPlayerFishing(e: PlayerFishEvent) {
        when(UHCPlugin.game?.modifier) {
            is Fishing -> {
                val extraUltimate = UHCPlugin.recipeList.filterIsInstance<ExtraUltimates>().filterIsInstance<UHCRecipe>().random().result
                e.hook.location.y = 100000000.0
                e.hook.world.dropItem(e.hook.location,extraUltimate)
            }
        }
    }
}
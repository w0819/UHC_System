package com.github.w0819.event

import com.github.w0819.game.resource.UHCResourceManager
import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import com.github.w0819.plugin.UHCPlugin
import io.github.monun.invfx.InvFX.frame
import io.github.monun.invfx.openFrame
import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.format.TextColor
import net.projecttl.inventory.gui.SimpleInventoryBuilder
import net.projecttl.inventory.util.InventoryType
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.block.Chest
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.*
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.enchantment.EnchantItemEvent
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.entity.ProjectileHitEvent
import org.bukkit.event.inventory.*
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.event.player.PlayerItemDamageEvent
import org.bukkit.inventory.CraftingInventory
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.persistence.PersistentDataType
import org.bukkit.potion.PotionBrewer
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import kotlin.random.Random

class ItemEvent : Listener {
    @EventHandler
    fun onPlayerCraft(event: CraftItemEvent) {
        val player: Player = event.whoClicked as Player
        val x = player.location.x
        val y = player.location.y
        val z = player.location.z
        when(event.recipe.result) {
            Item.FateSCall -> itemList(player)
            Item.Fenrir -> {
                player.location.world.spawnEntity(player.location,EntityType.WOLF)
                val fenrir = player.world.getNearbyEntities(player.location,x, y, z) as? Wolf
                fenrir?.apply {
                    owner = player
                    health = 2.0
                    addPotionEffect(PotionEffect(PotionEffectType.SPEED,1000000000,2))
                    addPotionEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,1000000000,1))
                    addPotionEffect(PotionEffect(PotionEffectType.INCREASE_DAMAGE,1000000000,1))

                }
            }
            Item.fusionArmorChestplate -> {

            }
        }

    }

    @EventHandler
    fun onPlayerPlace(e: BlockPlaceEvent) {
        if (e.block == Item.Forge) {
            val location = e.block.location
            val forgeKey = NamespacedKey.minecraft("forge")
            location.world.spawnEntity(location, EntityType.ARMOR_STAND).apply {
                (this as? ArmorStand)?.persistentDataContainer?.set(forgeKey, PersistentDataType.INTEGER,10)
            }
        }
    }
    @EventHandler
    fun onPlayerBreak(e: BlockBreakEvent) {
        if (e.player.inventory.itemInMainHand == Item.LumberjackAxe)  {
            val treeLogs = arrayOf(Material.OAK_LOG,Material.ACACIA_LOG,Material.BIRCH_LOG,Material.DARK_OAK_LOG, Material.JUNGLE_LOG,Material.SPRUCE_LOG)
            if (treeLogs.contains(e.block.type)) {

            }

        }
    }
    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val player = event.player
        val loc = player.location
        val world = player.location.world
        val entities: ArrayList<Entity> = world.getNearbyEntities(player.location, 10000.0, 10000.0, 10000.0) as ArrayList<Entity>
        var lowestDistanceSoFar = Double.MAX_VALUE

        if (event.action == Action.RIGHT_CLICK_AIR || event.action == Action.RIGHT_CLICK_BLOCK) {
            if (event.item?.type == Material.PLAYER_HEAD) {
                player.inventory.removeItem(ItemStack(Material.PLAYER_HEAD))
                player.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION,100,1,true,true))
                event.isCancelled = true
            }
            when(event.item) {
                Item.ModularBow -> {
                    val uhcResourceManager = UHCResourceManager
                    uhcResourceManager.switchModes(player)
                }
                Item.Master_Compass -> {
                    player.inventory.removeItem(Item.Master_Compass)
                    for (entity in entities) {
                        if (entity is Player) {
                            if(entity != player) {
                                val distance = entity.location.distance(loc)
                                if (distance < lowestDistanceSoFar) {
                                    lowestDistanceSoFar = distance

                                    event.player.sendMessage("주변 플레이어의 위치는 ${distance.toInt()}입니다.")
                                }
                            }
                        }
                    }
                }
                Item.Essence_of_yggdrasil -> {
                    player.inventory.removeItem(Item.Essence_of_yggdrasil)
                    player.giveExpLevels(30)
                }
                Item.golden_head -> {
                    player.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION,200,2,true,true,true))
                    player.addPotionEffect(PotionEffect(PotionEffectType.ABSORPTION,2400,1,true,true,true))
                    player.health += 6.0
                }
                Item.chest_of_fate -> {
                    player.addPotionEffect(PotionEffect(PotionEffectType.ABSORPTION,2400,5,true,true,true))
                    player.addPotionEffect(PotionEffect(PotionEffectType.SPEED,2400,2,true,true,true))
                }
                Item.Cornucopia -> {
                    player.addPotionEffect(PotionEffect(PotionEffectType.SATURATION,1_4400,1,true,true,true))
                    player.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION,240,1,true,true,true))
                }
                Item.backPack -> {
                    val storageInventory = (event.item as? Chest)?.inventory
                    val frame = frame(5, text("Back Pack")) {
                        onClick { _, _, event ->
                            val slot = event.slot
                            val item = event.cursor
                            storageInventory?.setItem(slot,item)
                            if (event.currentItem == ItemStack(Material.GRAY_STAINED_GLASS_PANE))
                                event.result = Event.Result.DENY
                        }

                        mapOf(5 to 1..9).forEach {
                            val x = it.key
                            it.value.forEach { y ->
                                slot(x,y) {
                                    item = ItemStack(Material.GRAY_STAINED_GLASS_PANE)
                                }
                            }
                        }
                        slot(5,5) {
                            item = Item.close
                        }
                    }
                    player.openFrame(frame)
                }
            }
        }
    }

    @EventHandler
    fun onEnchantBook(e: PrepareAnvilEvent) {
        val enchantment = Enchantment.values()
        val randomEnchant = enchantment[Random.nextInt(enchantment.size)]
        val enchantLevel = randomEnchant.maxLevel
        if (e.inventory.contains(Item.Enchantment_Book)) {
            e.result?.apply {
                itemMeta = itemMeta.apply {
                    addEnchantment(randomEnchant,enchantLevel)
                }
            }
        }
    }
    //  효과
    @EventHandler
    fun onPlayerItemConsume(event: PlayerItemConsumeEvent) {
        val item = event.item
        val player = event.player
        if (item == ItemStack(Material.GOLDEN_APPLE)) {
            player.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION,3,100,true,true,true))
        }
    }
    @EventHandler
    fun onArrowShoot(e: ProjectileHitEvent) {
        val chance = Random
        val give = chance.nextFloat()
        val player = e.entity.shooter as? Player
        if(player?.inventory?.itemInMainHand == Item.Artemis_Bow) {
            if (give <= 0.15f) {
                player.inventory.addItem(ItemStack(Material.ARROW))
            }
        }
        if (player?.inventory?.itemInMainHand == Item.ModularBow) {
            when(UHCResourceManager.getModes(player)) {
                1 -> e.hitEntity?.velocity?.normalize()?.multiply(3)
                2 -> {
                    e.hitEntity
                    // 아직 구연되지 않음
                }
            }
        }

    }
    @EventHandler
    fun onPlayerKill(event: PlayerDeathEvent) {
        val killer = event.entity.player?.killer
        val item = killer?.inventory?.itemInMainHand
        if (item == Item.Bloodlust) {
            item.apply {
                itemMeta = itemMeta.apply {
                    addEnchantment(Enchantment.DAMAGE_ALL, 1)
                }
            }
        }
    }
    @EventHandler
    fun onEntityDamagebyEntity(e : EntityDamageByEntityEvent) {
        val damgar = e.damager
        val location = (e.entity as? Player)?.location
        if (damgar is Player) {
            if (damgar.inventory.itemInMainHand == Item.AxeOfPerun) {
                location?.world?.strikeLightning(location)
            }
            if (damgar.inventory.helmet == Item.Exodus) {
                damgar.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION, 1, 40))
            }
            if (damgar.inventory.itemInMainHand == Item.Death_Scythe) {
                if (e.entity is Player) {
                    (e.entity as? Player)?.player?.health?.minus((e.entity as? Player)?.player?.health?.times(0.2) ?: 0.0)
                }
            }
            if (damgar.inventory.itemInMainHand == Item.dragon_sword) {
                e.damage = 8.0
            }
        }
    }

    @EventHandler
    fun onPotion(e: BrewEvent) {
        if (e.contents.ingredient == Item.Ambrosia) {
        val potions = (e.results as PotionBrewer)
        for (i in (e.results as PotionMeta).customEffects) {
                potions.createEffect(i.type,1200,3)
            }
        }
    }

    private fun organizePages(recipes: List<UHCRecipe>): ArrayList<ArrayList<UHCRecipe>> {
        val limit = 21
        val result = ArrayList<ArrayList<UHCRecipe>>()
        var arr = ArrayList<UHCRecipe>()
        var count = 0
        recipes.forEachIndexed { i, recipe ->
            count++
            arr.add(recipe)
            if (count == limit || i == recipes.size - 1) {
                count = 0
                result.add(arr)
                arr = ArrayList()
            }
        }
        return result
    }

    @EventHandler
    fun onRecipeBookUse(e: PlayerInteractEvent) {
        if (e.player.inventory.itemInMainHand == Item.recipeBook) {
            if (e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK) {
                lateinit var inventory: Inventory
                var page = 0
                val pages = organizePages(UHCPlugin.recipeList)

                // When viewer is viewing the list of recipes
                // False if the viewer is viewing one item's recipe

                var recipeView = true
                fun recipeToMap(recipe: UHCRecipe): Array<ItemStack?> {
                    val result = ArrayList<ItemStack?>()
                    recipe.shape.map { line ->
                        line.forEach { char ->
                            if (char == ' ') {
                                result.add(null)
                            } else {
                                result.add(recipe.ingredientMap[char])
                            }
                        }
                    }
                    return result.toTypedArray()
                }

                fun renderRecipe(recipe: UHCRecipe) {
                    recipeView = false
                    for (i in 0..53) {
                        inventory.setItem(i, ItemStack(Material.GRAY_STAINED_GLASS_PANE))
                    }
                    recipeToMap(recipe).forEachIndexed { i, item ->
                        inventory.setItem((i % 3) + 11 + ((i / 3) * 9), item)
                    }
                    inventory.setItem(24, recipe.result)
                    inventory.setItem(49, ItemStack(Material.ARROW))
                }

                fun updatePages() {
                    recipeView = true
                    if (page == 0) {
                        Item.left.amount = 0
                    } else {
                        Item.left.amount = 1
                    }
                    if (page == pages.size - 1) {
                        Item.right.amount = 0
                    } else {
                        Item.right.amount = 1
                    }
                    for (i in 0..53) {
                        inventory.setItem(i, null)
                    }
                    inventory.setItem(45, Item.left)
                    inventory.setItem(53, Item.right)
                    inventory.setItem(49, Item.close)
                    for (index in 0..20) {
                        inventory.setItem(10 + (2 * (index / 7)) + index, null)
                    }

                    pages[page].forEachIndexed { i, recipe ->
                        when (i) {
                            in 0..20 -> inventory.setItem(10 + (2 * (i / 7)) + i, recipe.result)
                            else -> throw RuntimeException("Should not reach here: $i")
                        }
                    }
                }

                val builder: SimpleInventoryBuilder.() -> Unit = {
                    slot(49, Item.close) {
                        if (recipeView) {
                            e.player.closeInventory()
                        } else {
                            updatePages()
                        }
                    }
                    slot(45, Item.left) {
                        page--
                        updatePages()
                    }
                    slot(53, Item.right) {
                        page++
                        updatePages()
                    }
                    for (index in 0..20) {
                        slot(10 + (2 * (index / 7)) + index, ItemStack(Material.AIR)) {
                            if (recipeView) {
                                renderRecipe(pages[page][index])
                            }
                        }
                    }
                }
                val a = SimpleInventoryBuilder(e.player, InventoryType.CHEST_54, text("Recipe Book"))
                inventory = a.apply(builder).build()
                updatePages()
            }
        }
    }
    private val diamondArmors = listOf(
        ItemStack(Material.DIAMOND_BOOTS),
        ItemStack(Material.DIAMOND_LEGGINGS),
        ItemStack(Material.DIAMOND_CHESTPLATE),
        ItemStack(Material.DIAMOND_HELMET)
    )
    private var fusionArmor = ItemStack(Material.AIR)
    @EventHandler
    fun onInventoryClick(e: InventoryClickEvent) {
        val inventory = e.clickedInventory
        if (e.cursor == Item.ExpertSeal) {
            e.currentItem?.itemMeta?.enchants?.forEach { (key, value) ->
                e.currentItem?.itemMeta?.removeEnchant(key)
                e.currentItem?.addEnchantment(key, value + 1)
            }
        }
        if (inventory is CraftingInventory) {
            var diamondArmorCount = 0
            if (inventory.result !in Item.fusionArmorList) {
                inventory.matrix?.forEach{ itemStack ->
                    if (itemStack in diamondArmors) {
                        diamondArmorCount++
                    }
                    if (diamondArmorCount == 5) {
                        if (fusionArmor !in Item.fusionArmorList) {
                            fusionArmor = Item.fusionArmorList.random()
                        }
                        inventory.result = fusionArmor
                    }
                }
            } else {
                fusionArmor = ItemStack(Material.AIR)
                return
            }
        }
    }

    @EventHandler
    fun onPlayerItemDamage(event: PlayerItemDamageEvent) {
        if (event.player.inventory.helmet == Item.Exodus) {
            event.player.addPotionEffect(PotionEffect(PotionEffectType.HEAL,50,1,true,true,true))
        }
    }
    @EventHandler
    fun onForge(e: FurnaceStartSmeltEvent) {
        val loc = e.block.location
        val entities = e.block.location.world.getNearbyEntities(e.block.location,loc.x,loc.y,loc.z) as ArrayList<Entity>
        entities.forEach { entity ->
            if (entity is ArmorStand) {
                val keyForge = NamespacedKey.minecraft("ForgeKey")
                val before = entity.persistentDataContainer.get(keyForge, PersistentDataType.INTEGER)
                entity.persistentDataContainer.set(
                    keyForge, PersistentDataType.INTEGER, before?.minus(1) ?: 0
                )
                e.totalCookTime = 0
                if (entity.persistentDataContainer.get(keyForge, PersistentDataType.INTEGER) == 0)
                    e.block.type= Material.AIR
            }
        }
    }
    @EventHandler
    fun onAnvil(e: PrepareAnvilEvent) {
        if (e.inventory.contains(Item.apprentice_Bow))
            e.inventory.close()
        if (e.inventory.contains(Item.apprentice_Sword))
            e.inventory.close()

    }
    @EventHandler
    fun onEnchantingTable(e: EnchantItemEvent) {
        if (e.item == Item.apprentice_Bow)
            e.isCancelled = true
        if (e.item == Item.apprentice_Sword)
            e.isCancelled = true
        e.enchanter.sendMessage(
            text("Not Allowed Enchanting this").color(
                TextColor.color(255,10,10)
            )
        )
    }

}
/**
 * this function is for Fate's Call
 * */

fun itemList(player: Player): Inventory {
    val itemList = Material.values().filter { item ->
        item.isItem
        }
    val inventoryItemList = ArrayList<Material>()
    val chest: Chest = player.location.block.state as Chest
    for (i in 9..18) {
        val item = Random.nextInt(itemList.size)
        chest.inventory.setItem(i, ItemStack(itemList[item]))
        if (itemList[item] in inventoryItemList)
            continue
    }
    return chest.inventory
}

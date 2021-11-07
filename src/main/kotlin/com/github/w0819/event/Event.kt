package com.github.w0819.event

import com.github.w0819.game.resource.UHCResourceManager
import com.github.w0819.game.util.Item.recipeBook
import net.kyori.adventure.text.Component.text
import net.projecttl.inventory.gui.InventoryGuiBuilder
import net.projecttl.inventory.gui.utils.InventoryType
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.*
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.entity.EntityInteractEvent
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.inventory.CraftItemEvent
import org.bukkit.event.player.*
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import kotlin.random.Random
import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import com.github.w0819.plugin.UHCPlugin

class Event(private val plugin: JavaPlugin) : Listener {

    @EventHandler
    fun onPlayerFristJoin(event: PlayerJoinEvent) {
        if (!event.player.hasPlayedBefore()) {
            event.player.addPotionEffect(PotionEffect(PotionEffectType.ABSORPTION,1000000000,4,true,true,true))
        }
    }

    // 플레이어 조인
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        player.sendMessage("오늘의 폐치노트 마컴이 추가됨 (플레이어 없으면 작동안함 주의)")
        player.inventory.setItem(4,recipeBook)

        UHCPlugin.game.addPlayer(player)
    }
    @EventHandler
    fun onPlayerKill(event: PlayerDeathEvent) {
        val killer = event.entity.player?.killer

        killer?.let {
            UHCResourceManager.addCoin(it, 10)
        }
    }

    // time set
    @EventHandler
    fun onServerTimeSet(event: PlayerMoveEvent) {
        val world = event.player.location.world
        world.time = 1000
    }

    // 일반 플레이어 머리
    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val player = event.player
        val loc = player.location
        val item = ItemStack(Material.PLAYER_HEAD)
        val world = player.location.world
        val entities: ArrayList<Entity> = world.getNearbyEntities(player.location, 10000.0, 10000.0, 10000.0) as ArrayList<Entity>
        var lowestDistanceSoFar = Double.MAX_VALUE

            if (event.action == Action.RIGHT_CLICK_AIR || event.action == Action.RIGHT_CLICK_BLOCK) {
                if (event.item?.type == Material.PLAYER_HEAD) {
                    player.inventory.removeItem(item)
                    player.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION,100,1,true,true))
                    event.isCancelled = true
                }
                when(event.item) {
                    Item.Master_Compass -> {
                        player.inventory.removeItem(Item.Master_Compass)
                        for (entity in entities) { // This loops through all the entities, setting the variable "entity" to each element.
                            if (entity is Player) {
                                if(entity != player) {
                                val distance = entity.location.distance(loc)
                                if (distance < lowestDistanceSoFar) {
                                    lowestDistanceSoFar = distance

                                    event.player.sendMessage("주변 플레이어의 위치는 ${distance}입니다.")
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
                    Item.Enchantment_Book -> {
                        player.giveExpLevels(30)
                    }
            }
        }
    }

    // 앙털
    @EventHandler
    fun onPlayerEntityInteract(event: EntityInteractEvent) {
        if (event.entity is Sheep) {
            val r = Random
            val chance: Float = r.nextFloat()
            if (chance <= 0.15f) {
                event.entity.world.dropItemNaturally(
                    event.entity.location, ItemStack(Material.STRING)
                )
            }
        }
    }

    // 블럭 드롭아이템
    @EventHandler
    fun onPlayerBreakBlack(event: PlayerItemBreakEvent) {
        if(event.brokenItem.isSimilar(ItemStack(Material.GRAVEL))) {
            val r = Random
            val chance: Float = r.nextFloat()
            if (chance <= 0.15f) {
                event.player.world.dropItemNaturally(
                    event.player.location, ItemStack(Material.FLINT)
                )
            }
        }
    }

    // 엔티티 드롭아이템
    @EventHandler
    fun onEntityDeath(e: EntityDeathEvent) {
        if (e.entity is Spider) {
            e.entity.world.dropItemNaturally(
                e.entity.location, ItemStack(Material.STRING)
            )
        }
        if (e.entity is Chicken) {
                e.entity.world.dropItemNaturally(
                    e.entity.location, ItemStack(Material.FEATHER)
                )
        }
        if (e.entity is Spider) {
            val r = Random
            val chance: Float = r.nextFloat()
            if (chance <= 0.10f) {
                e.entity.world.dropItemNaturally(
                    e.entity.location, ItemStack(Material.SPIDER_EYE)
                )
            }
        }
        if (e.entity is Blaze) {
            e.entity.world.dropItemNaturally(
                e.entity.location, ItemStack(Material.BLAZE_ROD)
            )
        }
        if (e.entity is Ghast) {
            e.entity.world.dropItemNaturally(
                e.entity.location, ItemStack(Material.NETHER_WART)
            )
            e.entity.world.dropItemNaturally(
                e.entity.location, ItemStack(Material.ARROW)
            )
        }
        if (e.entity is Zombie) {
            val r = Random
            val chance: Float = r.nextFloat()
            if (chance <= 0.20f) {
                e.entity.killer?.giveExp(1000)
            }
        }
        if (e.entity is Skeleton) {
            val r = Random
            val chance: Float = r.nextFloat()
            if (chance <= 0.15f) {
                e.entity.world.dropItemNaturally(
                    e.entity.location, ItemStack(Material.BOW)
                )
            }
        }
        if (e.entity is Silverfish) {
            e.entity.world.dropItemNaturally(
                e.entity.location, ItemStack(Material.SLIME_BALL)
            )
        }
    }

    // 플레이어 죽을때의 효과
    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        val loc = event.entity.player?.location
        val world = loc?.world
        val killer = event.entity.player?.killer
        killer?.giveExp(50)
        val r = Random
        val chance: Float = r.nextFloat()
        if (chance <= 0.5f) {
            world?.dropItemNaturally(loc, ItemStack(Material.PLAYER_HEAD, 1))
        }
        world?.strikeLightningEffect(loc)
    }

    @EventHandler
    fun onPlayerDamage(event: PlayerItemDamageEvent) {
        if (event.player.inventory.helmet == Item.Exodus) {
            event.player.addPotionEffect(PotionEffect(PotionEffectType.HEAL,50,1,true,true,true))
        }

    }
    @EventHandler
    fun onPlayerKill(player: Player) {
        val killer = player.killer
        val giveCoin = killer?.scoreboard?.getObjective("coin")
        giveCoin?.name + 10
    }

    // 금머리 효과
    @EventHandler
    fun onPlayerItemConsume(event: PlayerItemConsumeEvent) {
        val item = event.item
        val player = event.player
        if (item == Item.golden_head) {
            player.health += 8.0
            event.player.addPotionEffect(PotionEffect(PotionEffectType.SPEED, 200, 1, true, false, true))
            event.player.addPotionEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 1, true, false, true))
            event.player.addPotionEffect(PotionEffect(PotionEffectType.HEAL, 100, 1, true, false, true))
        }
        if (item == Item.panacea) {
            player.health += 16.0
        }
        if (item == Item.potion_of_toughness) {
            player.addPotionEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2400, 2, true, true, true))
        }
        if (item == Item.DeusExMachina) {
         player.addPotionEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,300,4,true,true,true))
        }
    }
    @EventHandler
    fun onPlayerCraft(event: CraftItemEvent) {
        val item = event.recipe
        if (item == Item.apprentice_Sword) {
            Thread.sleep(6_0000)
            Item.apprentice_Sword.addEnchantment(Enchantment.DAMAGE_ALL,1)
            Thread.sleep(6_0000)
            Item.dragon_sword.addEnchantment(Enchantment.DAMAGE_ALL,1)
        }
        if (item == Item.apprentice_Bow) {
            Thread.sleep(6_000)
            Item.apprentice_Bow.addEnchantment(Enchantment.ARROW_DAMAGE,1)
            Thread.sleep(3_000)
            Item.apprentice_Bow.addEnchantment(Enchantment.ARROW_DAMAGE,1)
        }
    }

    private fun organizePages(recipes: ArrayList<UHCRecipe>): ArrayList<ArrayList<UHCRecipe>> {
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
        if (e.player.inventory.itemInMainHand == recipeBook) {
            if (e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK) {
                lateinit var inventory: Inventory
                var page = 0
                val pages = organizePages(UHCPlugin.recipeList)
                val close = ItemStack(Material.BARRIER).apply {
                    itemMeta = itemMeta.apply {
                        displayName(text("close"))
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
                        left.amount = 0
                    } else {
                        left.amount = 1
                    }
                    if (page == pages.size - 1) {
                        right.amount = 0
                    } else {
                        right.amount = 1
                    }
                    for (i in 0..53) {
                        inventory.setItem(i, null)
                    }
                    inventory.setItem(45, left)
                    inventory.setItem(53, right)
                    inventory.setItem(49, close)
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

                val builder: InventoryGuiBuilder.() -> Unit = {
                    slot(49, close) {
                        if (recipeView) {
                            e.player.closeInventory()
                        } else {
                            updatePages()
                        }
                    }
                    slot(45, left) {
                        page--
                        updatePages()
                    }
                    slot(53, right) {
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
                val a = InventoryGuiBuilder(e.player, InventoryType.CHEST_54, text("Recipe Book"), plugin)
                inventory = a.apply(builder).build()
                updatePages()
            }
        }
    }
}
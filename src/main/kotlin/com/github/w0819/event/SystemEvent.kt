package com.github.w0819.event

import com.github.w0819.game.resource.UHCResourceManager
import com.github.w0819.game.util.Item
import com.github.w0819.game.util.Item.recipeBook
import com.github.w0819.game.util.UHCRecipe
import com.github.w0819.plugin.UHCPlugin
import net.kyori.adventure.text.Component.text
import net.projecttl.inventory.gui.SimpleInventoryBuilder
import net.projecttl.inventory.util.InventoryType
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.*
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.*
import org.bukkit.event.inventory.CraftItemEvent
import org.bukkit.event.player.*
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import kotlin.random.Random

class SystemEvent(private val plugin: JavaPlugin) : Listener {
    @EventHandler
    fun onItemBurn(event: EntityDamageEvent) {
        val ent = event.entity
        if (ent is org.bukkit.entity.Item) {
            if (event.cause == EntityDamageEvent.DamageCause.FIRE || event.cause == EntityDamageEvent.DamageCause.LAVA) {
                event.isCancelled = true
            }
        }
    }
    @EventHandler
    fun onPlayerFristJoin(event: PlayerJoinEvent) {
        if (!event.player.hasPlayedBefore()) {
            event.player.addPotionEffect(PotionEffect(PotionEffectType.HEALTH_BOOST,1000000000,4,true,true,true))
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
    fun onArrowShoot(e: ProjectileHitEvent) {
        val chance = Random
        val give = chance.nextFloat()
        if (e.entity.shooter is Player) {
            if((e.entity.shooter as Player).inventory.itemInMainHand == Item.Artemis_Bow) {
                if (give <= 0.15f) {
                    (e.entity.shooter as Player).inventory.addItem(ItemStack(Material.ARROW))
                }
            }
        }
    }
    @EventHandler
    fun onPlayerKill(event: PlayerDeathEvent) {
        val killer = event.entity.player?.killer
        val item = killer?.inventory?.itemInMainHand
        if (item == Item.Bloodlust) {
            item.itemMeta.apply {
                addEnchant(Enchantment.DAMAGE_ALL,1,true)
            }
        }
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
    @EventHandler
    fun onInteract(e: PlayerInteractAtEntityEvent) {
        val player = e.player
        val wolfName = e.rightClicked.customName
        if (e.rightClicked.type == EntityType.WOLF) {
            if (wolfName == "Fenrir") {
                if ((e.rightClicked as Tameable).isTamed) {
                    if ((e.rightClicked as Tameable).owner!!.name != player.name) {
                        (e.rightClicked as Tameable).owner = player
                    }
                }
            }
        }
    }
    @EventHandler
    fun onPlayerItemHeld(e: PlayerItemHeldEvent) {
        val item = e.player.inventory.itemInMainHand
        if (item == Item.Andūril) {
            while (item == Item.Andūril) {
                e.player.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION,1,20))
                e.player.addPotionEffect(PotionEffect(PotionEffectType.SPEED,1,20))
                Thread.sleep(1_000)
            }
        }
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
                    Item.ModularBow -> {

                    }
                    Item.Master_Compass -> {
                        player.inventory.removeItem(Item.Master_Compass)
                        for (entity in entities) {
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

    @EventHandler
    fun onCraftItem(event: CraftItemEvent) {
        val player = event.whoClicked
        val location = player.location
        if (event.recipe == Item.Fenrir) {
            val wolf = location.world.spawnEntity(location,EntityType.WOLF)
            wolf.customName = "Fenrir"
            event.view.player.inventory.removeItem(Item.Fenrir)
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
    @EventHandler
    fun onEntityDamagebyEntity(e : EntityDamageByEntityEvent) {
        val damgar = e.damager
        val location = damgar.location.apply { z += 1 }
        if (damgar is Player) {
            if (damgar.inventory.itemInMainHand == Item.AxeOfPerun) {
                location.world.strikeLightning(location)
            }
            if (damgar.inventory.helmet == Item.Exodus) {
                damgar.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION, 1, 50))
            }
            if (damgar.inventory.itemInMainHand == Item.Death_Scythe) {
                if (e.entity is Player) {
                    (e.entity as Player).player!!.health - ((e.entity as Player).player!!.health * 0.2)
                }
            }
        }
    }

    @EventHandler
    fun onPlayerDamage(event: EntityDamageEvent) {
        if (event.entity is Player) {
            if (event.cause == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
                event.isCancelled = true
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
    fun onPlayerItemDamage(event: PlayerItemDamageEvent) {
        if (event.player.inventory.helmet == Item.Exodus) {
            event.player.addPotionEffect(PotionEffect(PotionEffectType.HEAL,50,1,true,true,true))
        }

    }
    @EventHandler
    fun onPlayerCraft(event: CraftItemEvent) {
        val player: Player = event.whoClicked as Player
        val location: Location = player.location


        if (event.recipe.result == Item.FateSCall) {

        }
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
        if (item == ItemStack(Material.GOLDEN_APPLE)) {
            player.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION,3,100,true,true,true))
        }
        if (item == Item.panacea) {
            player.health += 16.0
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
}
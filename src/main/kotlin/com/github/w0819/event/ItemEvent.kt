package com.github.w0819.event

import com.github.w0819.game.resource.UHCResourceManager
import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import com.github.w0819.plugin.UHCPlugin
import net.kyori.adventure.text.Component
import net.projecttl.inventory.gui.LinkedInventoryBuilder
import net.projecttl.inventory.gui.SimpleInventoryBuilder
import net.projecttl.inventory.util.InventoryType
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

/**
 * 임시 클래스
 * Event 클래스가 아이템에대한 구연이 부족해서 Event 클래스를 ItemEvent와 SysyemEvent로 분할할 예정
 * */
class ItemEvent : Listener {
    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val player = event.player
        val loc = player.location
        val item = ItemStack(Material.PLAYER_HEAD)
        val world = player.location.world
        val entities: ArrayList<Entity> = world.getNearbyEntities(player.location, 10000.0, 10000.0, 10000.0) as ArrayList<Entity>
        var lowestDistanceSoFar = Double.MAX_VALUE

        if (event.action == Action.RIGHT_CLICK_AIR || event.action == Action.RIGHT_CLICK_BLOCK) {
            when(event.item) {
                Item.ModularBow -> {
                    UHCResourceManager().switchModes(player)
                    when (UHCResourceManager().getModes(player)) {
                        1 -> {
                            Item.ModularBow.itemMeta.addEnchant(Enchantment.ARROW_KNOCKBACK,1,true)
                        }
                        2 -> {
                            Item.ModularBow.itemMeta.removeEnchant(Enchantment.ARROW_KNOCKBACK)

                        }
                        3 -> {
                            Item.ModularBow.itemMeta.removeEnchant(Enchantment.ARROW_KNOCKBACK)
                        }
                    }
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
            }
        }
    }

    fun recipeOrganizePages(recipes: ArrayList<UHCRecipe>): ArrayList<ArrayList<UHCRecipe>> {
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
    /**
    고장남
     * */
    @EventHandler
    fun onRecipeBookUse(e: PlayerInteractEvent) {
        if (e.player.inventory.itemInMainHand == Item.recipeBook) {
            if (e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK) {
                lateinit var inventory: Inventory
                var page = 0
                val pages = recipeOrganizePages(UHCPlugin.recipeList)

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

                val builder: LinkedInventoryBuilder.() -> Unit = {
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
                val a = SimpleInventoryBuilder(e.player, InventoryType.CHEST_54, Component.text("Recipe Book"))
                inventory = a.build().apply { builder }
                updatePages()
            }
        }
    }
}
fun alwaysCallingFunction() {
    val players = Bukkit.getOnlinePlayers()
    for (i in players) {
        if (i.inventory.itemInMainHand == Item.Andūril) {
            if (i.hasPotionEffect(PotionEffectType.SPEED))
                continue
            if (i.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE))
                continue
            i.addPotionEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,20,1))
            i.addPotionEffect(PotionEffect(PotionEffectType.SPEED,20,1))
        }
    }
}
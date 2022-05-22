package com.github.w0819.game.util

import com.github.w0819.game.util.uhc.UHCRecipe
import com.github.w0819.plugin.UHCPlugin
import io.github.monun.invfx.InvFX.frame
import io.github.monun.invfx.frame.InvFrame
import io.github.monun.invfx.openFrame
import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

/**
 * 레시피북
 */
object RecipeBook {
    object RecipeBook : UHCRecipe.Item(
        ItemStack(Material.ENCHANTED_BOOK),
        listOf(
            text("book for check recipes"),
            text("right click to open inventory").color(TextColor.color(0,255,0))
        )
    ) {
    }
    /**
     * 레시피를 ItemStack 리스트로 변환
     */
    private fun recipeToMap(recipe: UHCRecipe): Array<ItemStack?> {
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

    /**
     * 레시피에 대한 정보를 담은 프레임
     */
    private fun renderRecipe(prevFrame: InvFrame, recipe: UHCRecipe): InvFrame {
        return frame(6, text(recipe.toString())) {
            for (x in 0 until 9) {
                for (y in 0 until 6) {
                    slot(x, y) {
                        item = ItemStack(Material.GRAY_STAINED_GLASS_PANE)
                    }
                }
            }

            recipeToMap(recipe).forEachIndexed { i, it ->
                slot (1 + i % 3, 1 + i / 3) {
                    item = it
                }
            }

            slot(6, 2) {
                item = recipe.result
            }

            slot(4, 5) {
                item = ItemStack(Material.ARROW)
                onClick {
                    (it.whoClicked as Player).openFrame(prevFrame)
                }
            }
        }
    }

    /**
     * UHC의 레시피 리스트를 보여주는 프레임 
     */
    val recipeBook = frame(6, text("Recipe Book")) {
        list(1, 1, 7, 3, true, { UHCPlugin.recipeList() }) {
            transform { it.result }
            onClickItem { _, _, item, e ->
                val recipe = item.first
                val frame = renderRecipe(this@frame, recipe)
                (e.whoClicked as Player).openFrame(frame)
            }
        }.let { list ->
            slot(0, 5) {
                item = ItemStack(Material.ARROW).apply {
                    itemMeta = itemMeta.apply {
                        displayName(text("left"))
                    }
                }
                onClick {
                    list.index--
                }
            }

            slot(0, 4) {
                item = ItemStack(Material.BARRIER).apply {
                    itemMeta = itemMeta.apply {
                        displayName(text("close inventory").color(TextColor.color(255,0,0)))
                    }
                }
                onClick {
                    it.whoClicked.closeInventory()
                }
            }

            slot(8, 5) {
                item = ItemStack(Material.ARROW).apply {
                    itemMeta = itemMeta.apply {
                        displayName(text("right"))
                    }
                }
                onClick {
                    list.index++
                }
            }
        }
    }
}
package com.github.w0819.game.util.uhc

import com.github.w0819.game.util.Util
import com.github.w0819.plugin.UHCPlugin
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Bukkit
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe

/**
 * UHC 레시피
 */
abstract class UHCRecipe(key: NamespacedKey, result: Item, val craftsPerGame: Int, val oneMoreCraft: Boolean): ShapedRecipe(key, result), UHC {
    override fun getResult(): Item {
        return UHCPlugin.itemList().find { it.toString() == toString() } ?: throw Exception("fail find recipe's result")
    }

    fun register() {
        Bukkit.getServer().addRecipe(this)
    }

    final override fun toString(): String {
        return name
    }
    open class Item(item: ItemStack, lore: List<Component> = listOf(), val coolTime: Int = 0) : ItemStack(item),UHC {
        init {
            itemMeta = itemMeta.apply {
                displayName(
                    Component.text(
                        Util.makeWhiteSpace(this::class.simpleName ?: ""),
                        TextColor.color(0, 255, 0)
                    )
                )
            }
            lore(lore)
        }

        final override fun lore(lore: List<Component>?) = super.lore(lore)
        final override fun toString(): String {
            return name
        }
    }
}

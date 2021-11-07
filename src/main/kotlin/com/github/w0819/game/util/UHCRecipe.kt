package com.github.w0819

import org.bukkit.Bukkit
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe
import java.util.jar.JarFile

open class UHCRecipe(key: NamespacedKey, result: ItemStack): ShapedRecipe(key, result) {
    companion object {
        @JvmStatic
        fun registerAll(pkg: String): Array<out UHCRecipe> {
            val jarFile = JarFile(this::class.java.protectionDomain.codeSource.location.path)
            val entries = jarFile.entries()
            val recipes = ArrayList<UHCRecipe>()
            while (entries.hasMoreElements()) {
                val fileName = entries.nextElement().name
                if (fileName.startsWith("$pkg.".replace(".", "/")) && fileName.endsWith(".class")) {
                    recipes.add(Class.forName(fileName.replace("/", ".").removeSuffix(".class")).getDeclaredConstructor().newInstance() as UHCRecipe)
                }
            }
            return recipes.toTypedArray()
        }
    }

    fun register(): UHCRecipe {
        Bukkit.getServer().addRecipe(this)
        return this
    }
}
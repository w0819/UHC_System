package com.github.w0819.main

import com.github.w0819.UHCRecipe
import com.github.w0819.event.Event
import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.plugin.java.JavaPlugin


class Main : JavaPlugin() {
    companion object {
        @JvmStatic
        val recipeList = ArrayList<UHCRecipe>()
    }

    override fun onEnable() {
        server.pluginManager.registerEvents(Event(this), this)
        recipe()
        server.logger.info("Recipe is enabled")

        val sm = server.scoreboardManager
        val sc = sm.mainScoreboard

        val coin = sc.getObjective("coin")
        if (coin == null) sc.registerNewObjective("coin","coin",text("coin",NamedTextColor.GOLD))
    }

    private fun recipe() {
        recipeList.addAll(UHCRecipe.registerAll("com.github.w0819.recipes"))
    }
}
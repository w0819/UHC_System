package com.github.w0819.main

import com.github.w0819.UHCRecipe
import com.github.w0819.event.Event
import com.github.w0819.recipes.*
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
    }

    private fun recipe() {
        recipeList.addAll(arrayOf(
            ApprenticeBow().register(),
            ApprenticeHelmet().register(),
            ApprenticeSword().register(),
            ArrowEconomy().register(),
            ArtemisBook().register(),
            BookOfPower().register(),
            BookOfProtection().register(),
            BookOfSharpening().register(),
            BrewingArtifact().register(),
            DragonArmor().register(),
            DragonSword().register(),
            EveIsTemptation().register(),
            GoldenHead().register(),
            GoldPack().register(),
            IronEconomy().register(),
            LeatherEconomy().register(),
            LightAnvil().register(),
            MasterCompass().register(),
            NetherArtifact().register(),
            NewApple().register(),
            NotchApple().register(),
            PhilosopherPickaxe().register(),
            QuickPick().register(),
            Saddle().register(),
            SparklingWatermelon().register(),
            SugarRush().register(),
            Tarnhelm().register(),
            VorpalSword().register(),
            CupidsBow().register(),
            SpikedArmor().register(),
            ChestOfFate().register(),
            Cornucopia().register(),
            EssenceOfYggdrasil().register(),
            PotionOfVelocity().register(),
            Panacea().register(),
            EnchantmentBook().register(),
            ShoesOfVidar().register(),
            HideOfLeviathan().register(),

        ))
//        val leatherHelmet = ItemStack(Material.LEATHER_HELMET).apply {
//            itemMeta = itemMeta.apply {
//                (this as LeatherArmorMeta).setColor(Color.PURPLE)
//            }
//        }
    }
}

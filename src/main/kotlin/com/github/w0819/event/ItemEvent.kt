package com.github.w0819.event

import com.github.w0819.game.resource.UHCResourceManager
import com.github.w0819.game.uhc.recipes.*
import com.github.w0819.game.util.ExtraUltimates
import com.github.w0819.game.util.RecipeBook
import com.github.w0819.game.util.Util
import com.github.w0819.plugin.UHCPlugin
import com.github.w0819.plugin.UHCPlugin.Companion.game
import com.github.w0819.potion.NoHealing
import com.github.w0819.potion.PreventDamage
import io.github.monun.invfx.InvFX.frame
import io.github.monun.invfx.openFrame
import io.github.monun.tap.fake.invisible
import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.attribute.Attribute
import org.bukkit.block.Chest
import org.bukkit.block.data.type.TNT
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.*
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.enchantment.EnchantItemEvent
import org.bukkit.event.entity.*
import org.bukkit.event.inventory.*
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.inventory.AnvilInventory
import org.bukkit.inventory.CraftingInventory
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.persistence.PersistentDataType
import org.bukkit.potion.PotionBrewer
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class ItemEvent : Listener {

    @EventHandler
    fun onPlayerCraft(event: CraftItemEvent) {
        val player: Player = event.whoClicked as Player
        when (event.recipe) {
            `Fate'sCall` -> itemList(player)
            Fenrir -> {
                 player.location.world.spawn(player.location, Wolf::class.java).apply {
                    owner = player
                    health = 2.0
                    addPotionEffect(PotionEffect(PotionEffectType.SPEED,1000000000,2))
                    addPotionEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,1000000000,1))
                    addPotionEffect(PotionEffect(PotionEffectType.INCREASE_DAMAGE,1000000000,1))
                }
            }
            DiceOfGod -> event.inventory.result =
                UHCPlugin.recipeList().filterIsInstance<ExtraUltimates>().random().result
        }

    }

    @EventHandler
    fun onPlayerPlace(e: BlockPlaceEvent) {
        val block = e.block
        if (block.type == Forge.Forge.type) {
            val location = block.location
            location.world.spawnEntity(location, EntityType.ARMOR_STAND).apply {
                (this as? ArmorStand)?.persistentDataContainer?.set(Forge.key, PersistentDataType.INTEGER, 10)
                invisible = true
            }
        }
    }

    @EventHandler
    fun onPlayerBreak(e: BlockBreakEvent) {
        val block = e.block
        val x = e.block.x
        val y = e.block.y
        val z = e.block.z
        if (e.player.inventory.itemInMainHand == LumberjackAxe.result) {
            e.isDropItems = false
            block.location.block.type = block.type
            val treeLogs = arrayOf(
                Material.OAK_LOG,
                Material.ACACIA_LOG,
                Material.BIRCH_LOG,
                Material.DARK_OAK_LOG,
                Material.JUNGLE_LOG,
                Material.SPRUCE_LOG
            )
            if (block.type in treeLogs) {
                val groundY = (y..-y).find { i ->
                    Location(
                        block.world,
                        x.toDouble(),
                        i.toDouble(),
                        z.toDouble()
                    ).block.type !in treeLogs
                } ?: return
                val groundX = (x..-x).find { i ->
                    Location(
                        block.world,
                        i.toDouble(),
                        groundY.toDouble(),
                        z.toDouble()
                    ).block.type !in treeLogs
                } ?: return
                val groundZ = (z..-z).find { i ->
                    Location(
                        block.world,
                        groundX.toDouble(),
                        groundY.toDouble(),
                        i.toDouble()
                    ).block.type !in treeLogs
                } ?: return
                for (x1 in (groundX..-groundX)) {
                    for (z1 in (groundZ..-groundZ)) {
                        for (y1 in (groundY..-groundY)) {
                            val location = Location(block.world, x1.toDouble(), z1.toDouble(), y1.toDouble())
                            if (location.block.type in treeLogs)
                                location.block.breakNaturally()
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val player = event.player
        val loc = player.location
        val world = player.location.world
        val entities: ArrayList<Entity> =
            world.getNearbyEntities(player.location, 10000.0, 10000.0, 10000.0) as ArrayList<Entity>
        var lowestDistanceSoFar = Double.MAX_VALUE
        val item = event.item ?: ItemStack(Material.AIR)

        if (event.action == Action.RIGHT_CLICK_AIR || event.action == Action.RIGHT_CLICK_BLOCK) {
            if (event.item?.type == Material.PLAYER_HEAD) {
                player.inventory.removeItem(ItemStack(Material.PLAYER_HEAD))
                player.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION, 100, 1, true, true))
                event.isCancelled = true
            }
            when (item) {
                FlaskOfCleansing.result -> item.itemMeta.persistentDataContainer.set(
                    FlaskOfCleansing.key,
                    PersistentDataType.STRING,
                    player.name
                )
                ModularBow.result -> {
                    val uhcResourceManager = UHCResourceManager
                    uhcResourceManager.switchModes(player)
                }
                `Master'sCompass`.result -> {
                    player.inventory.removeItem(item)
                    for (entity in entities) {
                        if (entity is Player) {
                            if (entity != player) {
                                val distance = entity.location.distance(loc)
                                if (distance < lowestDistanceSoFar) {
                                    lowestDistanceSoFar = distance

                                    event.player.sendMessage("주변 플레이어의 위치는 ${distance.toInt()}입니다.")
                                }
                            }
                        }
                    }
                }
                GoldenHead.result -> {
                    player.inventory.remove(item)
                    player.addPotionEffect(PotionEffect(PotionEffectType.SPEED, 2, 420))

                    val effects = listOf(
                        PotionEffect(PotionEffectType.REGENERATION, 200, 2, true, true, true),
                        PotionEffect(PotionEffectType.ABSORPTION, 2400, 1, true, true, true)
                    )

                    game.teams.find { it.players.contains(player) }?.players?.forEach { teamPlayer ->
                        effects.forEach { teamPlayer.addPotionEffect(it) }
                    } ?: effects.forEach { player.addPotionEffect(it) }
                }
                ChestOfFate.result -> {
                    if (Util.percent(50)) {
                        player.addPotionEffect(PotionEffect(PotionEffectType.ABSORPTION, 2400, 5, true, true, true))
                        player.addPotionEffect(PotionEffect(PotionEffectType.SPEED, 2400, 2, true, true, true))
                    } else {
                        player.world.spawnEntity(loc,EntityType.PRIMED_TNT)
                    }
                }
                Cornucopia.result -> {
                    player.addPotionEffect(PotionEffect(PotionEffectType.SATURATION, 1_4400, 1, true, true, true))
                    player.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION, 240, 1, true, true, true))
                }
                BackPack.result -> {
                    val storageInventory = (event.item as? Chest)?.inventory
                    val frame = frame(5, text("Back Pack")) {
                        onClick { _, _, event ->
                            val slot = event.slot
                            val cursorItem = event.cursor
                            storageInventory?.setItem(slot, cursorItem)
                            if (event.currentItem == ItemStack(Material.GRAY_STAINED_GLASS_PANE))
                                event.result = Event.Result.DENY
                        }
                        val x = 5
                        (1..9).forEach { y ->
                            slot(x, y) {
                                this.item = ItemStack(Material.GRAY_STAINED_GLASS_PANE)
                            }
                        }

                        slot(5, 5) {
                            this.item = ItemStack(Material.BARRIER)
                        }
                    }
                    player.openFrame(frame)
                }
            }
        }
    }

    @EventHandler
    fun onPlayerRegainHealth(e: EntityRegainHealthEvent) {
        val player = e.entity as? Player
        if (player != null)
            if (NoHealing in player.activePotionEffects.map { it.type }) {
                e.isCancelled = true
            }
    }

    //  효과
    @EventHandler
    fun onPlayerItemConsume(event: PlayerItemConsumeEvent) {
        val item = event.item
        val player = event.player
        when (item) {
            ItemStack(Material.GOLDEN_APPLE) -> {
                player.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION, 3, 100, true, true, true))
            }
            DeusExMachina.result -> player.health = player.health / 2
        }
    }

    @EventHandler
    fun onArrowShoot(e: ProjectileHitEvent) {
        val player = (e.entity.shooter as? Player) ?: return
        if (player.inventory.itemInMainHand == `Artemis'sBow`.result) {
            if (Util.percent(15)) {
                player.inventory.addItem(ItemStack(Material.ARROW))
            }
        }
        if (player.inventory.itemInMainHand == ModularBow.result) {
            when (UHCResourceManager.getModes(player)) {
                1 -> e.hitEntity?.velocity?.normalize()?.multiply(3)
                2 -> {
                    e.hitEntity
                    // 아직 구연 되지 않음
                }
            }
        }

    }

    @EventHandler
    fun onPlayerKill(e: PlayerDeathEvent) {
        val killer = e.entity.player?.killer
        when (val item = killer?.inventory?.itemInMainHand) {
            Bloodlust.result -> {
                item.apply {
                    itemMeta = itemMeta.apply {
                        addEnchantment(Enchantment.DAMAGE_ALL, 1)
                    }
                }
            }
        }
    }

    @EventHandler
    fun onEntityDamageByEntity(e: EntityDamageByEntityEvent) {
        val damager = e.damager
        val entity = e.entity
        val damage = e.damage
        val location = (e.entity as? Player)?.location
        if (damager is Player) {
            if (PreventDamage in damager.activePotionEffects.map { it.type })
                e.damage = if (damage - 8 < 0) 0.0 else damage - 8

            when (damager.inventory.helmet) {
                is Exodus.Exodus -> {
                    damager.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION, 1, 40))
                }
            }
            when (damager) {
                is TNT -> {
                    repeat(2) {
                        entity.location.world.createExplosion(entity, 4.0f, false, false)
                    }
                }
            }
            when (val item = damager.inventory.itemInMainHand) {
                AxeOfPerun.result -> location?.world?.strikeLightning(location)
                `Death'sScythe`.result -> {
                    if (entity is Player) {
                        entity.health.minus(entity.health.times(0.2))
                        val addHealth = damager.health * (damage * 0.25)
                        if (addHealth > damager.healthScale) {
                            damager.healthScale = addHealth
                            damager.health = addHealth
                        } else damager.health = addHealth
                    }
                }
                DragonSword.result -> e.damage = 8.0
                Excalibur.result -> {
                    entity.world.spawnEntity(entity.location, EntityType.PRIMED_TNT).apply {
                        this.persistentDataContainer.set(
                            NamespacedKey.minecraft("excalibur_tnt"),
                            PersistentDataType.STRING,
                            "excalibur's tnt"
                        )
                    }
                    try {
                        damager.setCooldown(item.type, Excalibur.Excalibur.coolTime)
                    } catch (e: java.lang.Exception) {
                        println(e.stackTrace)
                    }
                }
            }
        }
    }

    @EventHandler
    fun onHorseSpawn(e: EntitySpawnEvent) {
        when (val entity = e.entity) {
            is Horse -> {
                if (entity !is SkeletonHorse) {
                    entity.damage(entity.health)
                    entity.location.world.spawnEntity(e.location, EntityType.SKELETON_HORSE).apply {
                        (this as SkeletonHorse).isTrapped = false
                        val attribute = getAttribute(Attribute.GENERIC_MOVEMENT_SPEED) ?: return@apply
                        attribute.baseValue = 10.0
                        jumpStrength = 2.5
                    }
                }
            }
        }
    }

    @EventHandler
    fun onPotion(e: BrewEvent) {
        if (e.contents.ingredient == Ambrosia.result) {
            val potions = (e.results as PotionBrewer)
            for (i in (e.results as PotionMeta).customEffects) {
                potions.createEffect(i.type, 1200, 3)
            }
        }
    }

    @EventHandler
    fun onSplashPotion(e: PotionSplashEvent) {
        val potion = e.potion
        val item = potion.item
        val itemPersistentDataContainer = item.itemMeta.persistentDataContainer
        if (itemPersistentDataContainer.has(FlaskOfCleansing.key)) {
            val playerName =
                itemPersistentDataContainer.get(FlaskOfCleansing.key,PersistentDataType.STRING)
                    ?: ""
            e.affectedEntities.forEach {
                val player = (it as? Player) ?: return
                if (player.name != playerName) {
                    player.addPotionEffect(PotionEffect(NoHealing, 1, 400))
                } else {
                    player.addPotionEffect(PotionEffect(PreventDamage,1,20))
                }
            }
        }
    }

    @EventHandler
    fun onPotionBrew(e: BrewEvent) {
        when (e.contents.ingredient) {
            Ambrosia.result -> {
                for (potion in e.results.mapNotNull { it as? PotionMeta }) {
                    for (effect in potion.customEffects) {
                        potion.addCustomEffect(PotionEffect(effect.type, 1200, 3), true)
                    }
                }
            }
        }
    }


    @EventHandler
    fun onRecipeBookUse(e: PlayerInteractEvent) {
        e.player.openFrame(RecipeBook.recipeBook)
    }

    private val diamondArmors = listOf(
        ItemStack(Material.DIAMOND_BOOTS),
        ItemStack(Material.DIAMOND_LEGGINGS),
        ItemStack(Material.DIAMOND_CHESTPLATE),
        ItemStack(Material.DIAMOND_HELMET)
    )

    @EventHandler
    fun onInventoryClick(e: InventoryClickEvent) {
        val inventory = e.clickedInventory
        when (e.cursor) {
            ExpertSeal.result -> {
                e.currentItem?.itemMeta?.enchants?.forEach { (key, value) ->
                    e.currentItem?.itemMeta?.removeEnchant(key)
                    e.currentItem?.addEnchantment(key, value + 1)
                }
            }
            EssenceOfYggdrasil.result -> {
                e.cursor?.type = Material.AIR
                for (human in e.viewers) {
                    val player = (human as? Player) ?: continue
                    if (game.teams.find { player in it.players }?.players?.forEach { it.giveExpLevels(8) } == null)
                        player.giveExp(25)
                    else player.giveExpLevels(15)
                }
            }
        }
        if (inventory is AnvilInventory) {
            when (inventory.secondItem) {
                EnchantmentBook.result -> {
                    val enchantment = Enchantment.values()
                    val randomEnchant = enchantment.random()
                    val enchantLevel = randomEnchant.maxLevel
                    inventory.result?.addEnchantment(randomEnchant, enchantLevel)
                }
            }
        }

        if (inventory is CraftingInventory) {
            if ((inventory.contents?.filter { (it ?: return) in diamondArmors }?.size ?: 0) >= 5) {
                inventory.contents?.forEachIndexed { index, itemStack ->
                    if (index == 5) return@forEachIndexed
                    inventory.remove(itemStack ?: ItemStack(Material.AIR))
                }
                inventory.result = diamondArmors.random().apply { addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,4) }
            }
        }
    }



    @EventHandler
    fun onForge(e: FurnaceStartSmeltEvent) {
        val loc = e.block.location
        val armor = e.block.location.world.getNearbyEntities(e.block.location,loc.x,loc.y,loc.z).find { it.type == EntityType.ARMOR_STAND } ?: return
        val before = armor.persistentDataContainer.get(Forge.key, PersistentDataType.INTEGER)
        armor.persistentDataContainer.set(
            Forge.key, PersistentDataType.INTEGER, before?.minus(1) ?: 0
        )
        e.totalCookTime = 0
        if (armor.persistentDataContainer.get(Forge.key, PersistentDataType.INTEGER) == 0)
            e.block.type= Material.AIR
    }

    @EventHandler
    fun onAnvil(e: PrepareAnvilEvent) {
        if (e.inventory.any { it == ApprenticeBow.result || it == ApprenticeSword.result })
            e.inventory.close()
    }

    @EventHandler
    fun onEnchantingTable(e: EnchantItemEvent) {
        if (e.item == ApprenticeBow.result || e.item == ApprenticeSword.result)
            e.isCancelled = true
        e.enchanter.sendMessage(
            text("Enchanting this is not allowed").color(
                TextColor.color(255, 10, 10)
            )
        )
    }
}
/**
 * this function is for Fate's Call
 * */

private fun itemList(player: Player): Inventory {
    val itemList = Material.values().filter { item ->
        item.isItem
    }
    val inventoryItemList = ArrayList<Material>()
    val chest = player.location.block.state as Chest
    for (i in 9..18) {
        val randomItem = itemList.random()
        chest.inventory.setItem(i, ItemStack(randomItem))
        if (randomItem in inventoryItemList)
            continue
    }
    return chest.inventory
}

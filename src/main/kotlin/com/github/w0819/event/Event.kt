package com.github.w0819.event

import com.github.w0819.Item
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
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import kotlin.random.Random


class Event : Listener {

    // 플레이어 조인
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        player.health + 20.0

        player.sendMessage("오늘의 폐치노트 마컴이 추가됨 (플레이어 없으면 작동안함 주의)")

    }

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
                when(event.item) {
                    item -> {
                        player.inventory.removeItem(item)
                        player.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION,100,1,true,true))
                    }
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

    // 금머리 효과
    @EventHandler
    fun onPlayerItemConsume(event: PlayerItemConsumeEvent) {
        val item = event.item
        val player = event.player
        if (item == Item.golden_head) {
            player.health += 8.0
            event.player.addPotionEffect(PotionEffect(PotionEffectType.SPEED,200,1,true,false,true))
            event.player.addPotionEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200,1,true,false,true))
            event.player.addPotionEffect(PotionEffect(PotionEffectType.HEAL,100,1,true,false,true))
        }
        if (item == Item.panacea) {
            player.health += 16.0
        }
        if (item == Item.potion_of_toughness) {
            player.addPotionEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,2400,2,true,true,true))
        }
    }
    @EventHandler
    fun onPlayerCraft(event: CraftItemEvent) {
        val item = event.recipe
        if (item == Item.apprentice_Sword) {
            Thread.sleep(6_0000)
            Item.apprentice_Sword.itemMeta.addEnchant(Enchantment.DAMAGE_ALL,1,true)
            Thread.sleep(6_0000)
            Item.dragon_sword.itemMeta.addEnchant(Enchantment.DAMAGE_ALL,1,true)
        }
        if (item == Item.apprentice_Bow) {
            Thread.sleep(6_000)
            Item.apprentice_Bow.itemMeta.addEnchant(Enchantment.ARROW_DAMAGE,1,true)
            Thread.sleep(3_000)
            Item.apprentice_Bow.itemMeta.addEnchant(Enchantment.ARROW_DAMAGE,1,true)
        }
    }
}




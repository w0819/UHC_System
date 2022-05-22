package com.github.w0819.game.util

import com.github.w0819.game.UHCGame
import com.github.w0819.plugin.UHCPlugin
import org.bukkit.Location
import org.bukkit.entity.Player
import java.util.*

/**
 * 코딩하면서 필요한 메소드들
 */
object Util {
    /**
     * @throws IllegalArgumentException if receiver's world and other's world are not equal
     * @return [List] of [Location]s
     * **/
    operator fun Location.rangeTo(other: Location): List<Location> {
        val thisXToOtherX = if (x > other.x) x.toInt()..other.x.toInt() else other.x.toInt()..x.toInt()
        val thisYToOtherY = if (y > other.y) y.toInt()..other.y.toInt() else other.y.toInt()..y.toInt()
        val thisZToOtherZ = if (z > other.z) z.toInt()..other.z.toInt() else other.z.toInt()..y.toInt()
        val list = mutableListOf<Location>()
        if (world != other.world) throw IllegalArgumentException("this world and other world are must be equal")
        thisXToOtherX.forEach { x->
            thisZToOtherZ.forEach { z ->
                thisYToOtherY.forEach { y ->
                    list.add(Location(world,x.toDouble(),y.toDouble(),z.toDouble()))
                }
            }
        }
        return list
    }
    val playerGame: (Player) -> UHCGame? = { player ->
        UHCPlugin.games.find { player in it.players }
    }
    val random = Random()

    fun percent(percentage: Int): Boolean {
        val chance = random.nextFloat()
        return chance <= percentage.toFloat() / 100
    }

    fun <T> divide(list: List<T>, itemPerGroup: Int): List<List<T>> {
        val toReturn = ArrayList<List<T>>()
        var currentList = ArrayList<T>()
        var offsetIndex = 0
        for (i in 0 until itemPerGroup) {
            currentList.add(list[i])
            if (++offsetIndex == itemPerGroup) {
                offsetIndex = 0
                toReturn.add(currentList)
                currentList = ArrayList()
            }
        }
        return toReturn
    }

    fun makeWhiteSpace(string: String,firstWhiteSpace: Boolean = false): String {
        tailrec fun makeWhiteSpace(string: String, request: String): String =
            when (val withOutSpace = string.filter { !it.isWhitespace() }.length) {
                request.length -> string
                else -> {
                    val char = request[withOutSpace]
                    if (char.isUpperCase()) {
                        if (char == request.first()) {
                            if (firstWhiteSpace) makeWhiteSpace("$char", request) else makeWhiteSpace(" $char", request)
                        } else {
                            makeWhiteSpace("$string $char", request)
                        }
                    } else {
                        makeWhiteSpace("$string$char", request)
                    }
                }
            }
        return makeWhiteSpace("", string)
    }
}
package com.github.w0819.game.util

import java.util.*
import kotlin.collections.ArrayList
import kotlin.reflect.KProperty1

/**
 * 코딩하면서 필요한 메소드들
 */
object Util {
    val random = Random()

    fun percent(percentage: Int): Boolean {
        val chance = random.nextFloat()
        return chance <= percentage.toFloat() / 100
    }

    @Suppress("UNCHECKED_CAST")
    fun <R> readInstanceProperty(instance: Any): List<R> {
        return instance::class.members.mapNotNull { (it as? KProperty1<Any, *>)?.get(instance) as? R }
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
}
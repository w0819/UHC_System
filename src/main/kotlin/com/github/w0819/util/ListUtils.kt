package com.github.w0819.util

class ListUtils {
    companion object {
        @JvmStatic
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
}
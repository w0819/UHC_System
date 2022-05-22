package com.github.w0819.game.util.uhc

import java.util.jar.JarFile
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.primaryConstructor

/**
 * UHC 의 컴포넌트. [UHCKit], [UHCModifier], [UHCRecipe], 등을 포함합니다
 */
interface UHC {
    companion object {
        @JvmStatic
         inline fun <reified T> load(pkg: String): Array<out T> {
            val jarFile = JarFile(this::class.java.protectionDomain.codeSource.location.path)
            val entries = jarFile.entries()
            return entries.toList().map {
                it.name
            }.filter {
                it.startsWith("$pkg.".replace(".", "/")) && it.endsWith(".class")
            }.map {
                Class.forName(it.replace("/", ".").removeSuffix(".class")).kotlin
            }.filter { kClass ->
            !kClass.isCompanion && !kClass.isAbstract && !kClass.isInner && kClass.primaryConstructor?.parameters?.isEmpty()?: false
            }.map { kClass ->
                kClass.objectInstance ?: kClass.createInstance()
            }.filterIsInstance<T>().toTypedArray()
        }
    }

    val isRecipe: Boolean
        get() = this is UHCRecipe

    val isKit: Boolean
        get() = this is UHCKit

    val isModifier: Boolean
        get() = this is UHCModifier




    /**
     * 클래스의 이름
     * */
    val name
        get() = this::class.simpleName ?: "anonymous"

}
package com.github.w0819.game.util

interface Ultimates {
    fun needProfessions(): List<Professions>
    fun needCoin(): Int
}

interface ExtraUltimates : Ultimates
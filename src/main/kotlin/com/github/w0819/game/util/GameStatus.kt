package com.github.w0819.game.util

/**
 * 게임 진행 상태
 */
enum class GameStatus {
    BEFORE_START,
    GRACE,
    PVP,
    DEATH_MATCH,
    END;

    val index = values().indexOf(this)
}
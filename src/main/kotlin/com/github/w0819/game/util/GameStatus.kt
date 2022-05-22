package com.github.w0819.game.util

/**
 * 게임 진행 상태
 */
enum class GameStatus(val index: Int) {
    // 오류나서 롤백
    BEFORE_START(1),
    GRACE(2),
    PVP(3),
    DEATH_MATCH(4),
    END(5)
}
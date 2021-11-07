package com.github.w0819

import io.github.monun.heartbeat.coroutines.Suspension
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

class StartActionType<T>(
    @Suppress("WeakerAccess") val exec: (UHCGame, CoroutineScope, Suspension, T?) -> Deferred<Unit>
) {
    companion object {
        @JvmStatic
        val COUNTDOWN = StartActionType<Int> { game, scope, suspension, data ->
            scope.async {
                if (data != null) {
                    repeat(data) {
                        game.players.forEach {  }
                        suspension.delay(1000L)
                    }
                }
            }
        }
    }

    @Suppress("WeakerAccess", "unused")
    fun executeAsync(game: UHCGame, scope: CoroutineScope, suspension: Suspension, any: Any?): Deferred<Unit> {
        @Suppress("unchecked_cast")
        return exec(game, scope, suspension, any as? T)
    }
}
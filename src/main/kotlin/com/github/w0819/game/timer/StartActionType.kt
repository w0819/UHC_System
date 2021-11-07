package com.github.w0819.game.timer

import com.github.w0819.game.UHCGame
import io.github.monun.heartbeat.coroutines.Suspension
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import net.kyori.adventure.text.Component.text
import net.kyori.adventure.title.Title

class StartActionType<T>(
    @Suppress("WeakerAccess") val exec: (UHCGame, CoroutineScope, Suspension, T?) -> Deferred<Unit>
) {
    companion object {
        @JvmStatic
        val COUNTDOWN = StartActionType<Int> { game, scope, suspension, data ->
            scope.async {
                if (data != null) {
                    repeat(data) {
                        game.players.forEach {
                            it.showTitle(Title.title(text("$it"), text("")))
                        }
                        suspension.delay(1000L)
                    }
                    game.players.forEach {
                        it.clearTitle()
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
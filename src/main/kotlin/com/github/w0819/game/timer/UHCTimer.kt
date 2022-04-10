package com.github.w0819.game.timer

import com.github.w0819.game.UHCGame
import com.github.w0819.game.util.GameStatus
import io.github.monun.heartbeat.coroutines.HeartbeatScope
import io.github.monun.heartbeat.coroutines.Suspension
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * UHCTimer 는 UHCGame 을
 */
class UHCTimer(private val game: UHCGame, private val startActions: Array<out StartAction<*>>) {
    companion object {
        /**
         * Grace Period duration in minutes
         *
         * 분 단위의 그레이스 기간
         */
        var GRACE_PERIOD_TIME = 10
            private set

        /**
         * Pvp Period duration in minutes
         *
         * 분 단위의 Pvp 기간
         */
        const val PVP_PERIOD_TIME = 45

        /**
         * DeathMatch Period duration in minutes
         * 
         * 분 단위의 데스매치 기간
         */
        const val DEATH_MATCH_PERIOD_TIME = 10
    }

    /**
     * The total amount of time passed. Won't increment once the game ends.
     *
     * 총 지난시간. 게임이 끝난다면 더 이상 증가하지 않습니다.
     */
    @Suppress("WeakerAccess")
    var passedTime: Int = 0
        private set

    /**
     * The current CoroutineJob.
     *
     * 현재 코루틴작업.
     */
    @Suppress("WeakerAccess")
    lateinit var job: Job
        private set

    /**
     * Whether the current CoroutineJob is running.
     *
     * 현재 코르틴작업이 실행되고 있는지 여부.
     */
    @Suppress("WeakerAccess")
    var running = false
        private set

    /**
     * Cancels the current executing timer. If the CoroutineJob finished its job, UHCTimer will automatically detect it and won't
     * cancel.
     *
     * 현재 실행되는 타이머를 취소합니다. 만약 코루틴작업이 끝났다면, UHCTimer 은 자동으로 이를 감지하고 취소하지 않을 것입니다.
     */
    fun cancelTimer(exception: CancellationException? = null) {
        if (running) {
            job.cancel(exception)
        }
    }

    /**
     * Initiates the UHCGame Timer. This method uses [monun](https://github.com/monun)'s
     * [Heartbeat-Coroutines](https://github.com/monun/heartbeat-coroutines) library.
     * Will create a loop every second, and modify game status. You can change the code inside the `repeat` block
     * to customize actions that are executed every second.
     *
     * 게임의 타이머를 초기화합니다. 이 메소드는 [각별님](https://github.com/monun)의
     * [두근두근 코루틴](https://github.com/monun/heartbeat-coroutines) 라이브러리를 사용합니다.
     * 매초마다 게임 상태를 변화시키는 코드를 반복합니다. `repeat` 코드 블록을 수정하여 매초 실행되는 코드를 설정할 수 있습니다.
     *
     * @return False if an internal error occurred, otherwise, it will return True.
     */
    fun initTimer(): Boolean {
        if (running) {
            return false
        }
        job = HeartbeatScope().launch {
            running = true

            val suspension = Suspension()

            // Start actions
            startActions.forEach {
                it.type.executeAsync(game, this, suspension, it.data).await()
            }

            // Game Start
            game.modifyGameStatus(GameStatus.GRACE)

            // Grace Period
            repeat(60 * GRACE_PERIOD_TIME) {
                passedTime += 1
                suspension.delay(1000L)
            }

            // Pvp Start
            game.modifyGameStatus(GameStatus.PVP)

            // Pvp Period
            repeat(60 * PVP_PERIOD_TIME) {
                passedTime += 1
                suspension.delay(1000L)
            }

            // DeathMatch Start
            game.modifyGameStatus(GameStatus.DEATH_MATCH)

            // DeathMatch Period
            repeat(60 * DEATH_MATCH_PERIOD_TIME) {
                passedTime += 1
                suspension.delay(1000L)
            }

            // Game End
            game.modifyGameStatus(GameStatus.END)

            running = false
        }

        return true
    }
    fun setGraceTime(value: Int) {
        if (value <= 0) return
        GRACE_PERIOD_TIME = value
    }
}
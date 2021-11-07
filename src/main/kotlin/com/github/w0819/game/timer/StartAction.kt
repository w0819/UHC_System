package com.github.w0819.game.timer

data class StartAction<T>(val type: StartActionType<T>, val data: T?)
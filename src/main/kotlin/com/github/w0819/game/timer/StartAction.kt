package com.github.w0819

data class StartAction<T>(val type: StartActionType<T>, val data: T?)
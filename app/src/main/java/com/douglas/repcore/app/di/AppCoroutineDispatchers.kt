package com.douglas.repcore.app.di

import kotlinx.coroutines.CoroutineDispatcher

data class AppCoroutineDispatchers(
    val default: CoroutineDispatcher,
    val io: CoroutineDispatcher,
    val main: CoroutineDispatcher,
)


package com.douglas.repcore.core.clock

interface AppClock {
    fun epochMillis(): Long
    fun elapsedRealtimeMillis(): Long
}


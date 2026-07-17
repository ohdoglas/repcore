package com.douglas.repcore.core.clock

import android.os.SystemClock

class AndroidAppClock : AppClock {
    override fun epochMillis(): Long = System.currentTimeMillis()

    override fun elapsedRealtimeMillis(): Long = SystemClock.elapsedRealtime()
}


package com.plhk.kotlinapp.loop

class LoopInfo {

    private val startTimestamp: Long = System.currentTimeMillis()

    val count: Int
    val duration: Long

    constructor() : this(System.currentTimeMillis(), 0)

    private constructor(prevStartTimestamp: Long, count: Int) {
        this.count = count
        this.duration = startTimestamp - prevStartTimestamp
    }

    internal fun next(): LoopInfo = LoopInfo(startTimestamp, count + 1)

}
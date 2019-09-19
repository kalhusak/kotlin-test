package com.plhk.kotlinapp.stage

import com.plhk.kotlinapp.loop.LoopInfo

interface Stage {

    fun execute(loopInfo: LoopInfo): Stage
}
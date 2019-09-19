package com.plhk.kotlinapp.stage

import com.plhk.kotlinapp.loop.LoopInfo

class PlayStage : Stage {

    override fun execute(loopInfo: LoopInfo): Stage {
        println("Playing... ${loopInfo.count}: ${loopInfo.duration}ms")
        Thread.sleep(2000)
        return this
    }

}
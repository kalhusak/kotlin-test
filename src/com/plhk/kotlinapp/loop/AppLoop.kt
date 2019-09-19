package com.plhk.kotlinapp.loop

import com.plhk.kotlinapp.GlobalState
import com.plhk.kotlinapp.stage.MenuStage
import com.plhk.kotlinapp.stage.Stage
import java.util.concurrent.atomic.AtomicBoolean

object AppLoop {

    private var stage = MenuStage() as Stage
    private val isAlreadyRun = AtomicBoolean()

    fun run() {
        if (!isAlreadyRun.getAndSet(true)) {
            GlobalState.isRunning.set(true)
            var loopInfo = LoopInfo()

            while (GlobalState.isRunning.get()) {
                loopInfo = loopInfo.next()
                stage = stage.execute(loopInfo)
            }
        }
    }
}
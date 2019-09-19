package com.plhk.kotlinapp.stage

import com.plhk.kotlinapp.GlobalState
import com.plhk.kotlinapp.loop.LoopInfo

class MenuStage : AbstractCommandStage() {

    override fun getName(): String {
        return "MENU";
    }

    override fun getDescription(): String {
        return """
            |s - start
            |o - options
            |e - exit
        """.trimIndent()
    }

    override fun executeCommand(command: String, loopInfo: LoopInfo): Stage {
        return when (command) {
            "s", "start" -> PlayStage()
            "o", "options" -> OptionsStage()
            "e", "exit" -> {
                GlobalState.isRunning.set(false)
                return this
            }
            else -> {
                println("Invalid command")
                return this
            }
        }
    }

}
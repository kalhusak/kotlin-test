package com.plhk.kotlinapp.stage

import com.plhk.kotlinapp.loop.LoopInfo
import java.util.*

abstract class AbstractCommandStage : Stage {

    private val input = Scanner(System.`in`);

    abstract fun getName() : String

    abstract fun getDescription() : String

    abstract fun executeCommand(command: String, loopInfo: LoopInfo): Stage

    override fun execute(loopInfo: LoopInfo): Stage {
        val header = "###### ${getName().toUpperCase()} ######"
        println(header)
        println(getDescription())
        print("Answer: ")
        val command = input.nextLine()
        val resultStage = executeCommand(command, loopInfo)
        println("#".repeat(header.length))
        println()
        return resultStage
    }
}
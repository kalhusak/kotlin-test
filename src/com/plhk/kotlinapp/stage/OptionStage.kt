package com.plhk.kotlinapp.stage

import com.plhk.kotlinapp.AppOption
import com.plhk.kotlinapp.GlobalState
import com.plhk.kotlinapp.loop.LoopInfo

class OptionStage(private val option: AppOption) : AbstractCommandStage() {

    override fun getName(): String = option.longName

    override fun getDescription(): String = "Insert '${option.longName}' value of type '${option.javaClass}'"

    override fun executeCommand(command: String, loopInfo: LoopInfo): Stage {
        val value = convertValue(command)
        if (value != null) {
            GlobalState.options[option] = value
            return OptionsStage()
        } else {
            println("Invalid value!!!")
            return OptionsStage()
        }
    }

    private fun convertValue(command: String): Any? {
        return try {
            when (option.javaClass) {
                String.javaClass -> command
                Int.javaClass -> command.toInt()
                Float.javaClass -> command.toFloat()
                Boolean.javaClass -> command.toBoolean()
                else -> null
            }
        } catch (e: Exception) {
            null
        }
    }
}
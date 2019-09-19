package com.plhk.kotlinapp.stage

import com.plhk.kotlinapp.AppOption
import com.plhk.kotlinapp.GlobalState
import com.plhk.kotlinapp.loop.LoopInfo

class OptionsStage : AbstractCommandStage() {

    override fun getName(): String {
        return "OPTIONS";
    }

    override fun getDescription(): String {
        return """
            |${AppOption.FONT_SIZE.shortName} - ${AppOption.FONT_SIZE.longName}
            |${AppOption.SCREEN_SIZE_WIDTH.shortName} - ${AppOption.SCREEN_SIZE_WIDTH.longName}
            |${AppOption.SCREEN_SIZE_HEIGHT.shortName} - ${AppOption.SCREEN_SIZE_HEIGHT.longName}
            |${AppOption.IS_HUD_ENABLED.shortName} - ${AppOption.IS_HUD_ENABLED.longName}
            |l - list all
            |r - return
        """.trimIndent()
    }

    override fun executeCommand(command: String, loopInfo: LoopInfo): Stage {
        return when (command) {
            AppOption.FONT_SIZE.shortName, AppOption.FONT_SIZE.longName -> OptionStage(AppOption.FONT_SIZE)
            AppOption.SCREEN_SIZE_WIDTH.shortName, AppOption.SCREEN_SIZE_WIDTH.longName -> OptionStage(AppOption.SCREEN_SIZE_WIDTH)
            AppOption.SCREEN_SIZE_HEIGHT.shortName, AppOption.SCREEN_SIZE_HEIGHT.longName -> OptionStage(AppOption.SCREEN_SIZE_HEIGHT)
            AppOption.IS_HUD_ENABLED.shortName, AppOption.IS_HUD_ENABLED.longName -> OptionStage(AppOption.IS_HUD_ENABLED)
            "l", "list all" -> {
                GlobalState.options.entries
                    .map { "-- ${it.key.longName}: ${it.value}" }
                    .forEach { println(it) }
                return this
            }
            "r", "return" -> return MenuStage()
            else -> {
                println("Invalid command")
                return this
            }
        }
    }
}
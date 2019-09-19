package com.plhk.kotlinapp

import java.util.concurrent.atomic.AtomicBoolean

object GlobalState {
    val isRunning = AtomicBoolean()
    val options = hashMapOf(
        AppOption.FONT_SIZE to 12,
        AppOption.SCREEN_SIZE_WIDTH to 1920,
        AppOption.SCREEN_SIZE_HEIGHT to 1080,
        AppOption.IS_HUD_ENABLED to true
    )
}
package com.plhk.kotlinapp

enum class AppOption(val key: String, val shortName: String, val longName: String, val javaClass: Class<Any>) {
    FONT_SIZE("fontSize", "fs", "font size", Int.javaClass),
    SCREEN_SIZE_WIDTH("screenSizeWith", "ssw", "screen size - width", Int.javaClass),
    SCREEN_SIZE_HEIGHT("screenSizeHeight", "ssh", "screen size - height", Int.javaClass),
    IS_HUD_ENABLED("isHudEnabled", "ihe", "HUD enabled", Boolean.javaClass)
}
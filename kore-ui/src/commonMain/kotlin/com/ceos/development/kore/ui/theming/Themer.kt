package com.ceos.development.kore.ui.theming

import com.ceos.development.kore.ui.theming.icons.IconsPack
import com.ceos.development.kore.ui.theming.colors.Colors
import com.ceos.development.kore.ui.theming.typographies.Typographies

object Themer {
    fun setPack(pack: IconsPack) = IconsPack.setPack(pack)

    fun setLightColors(colors: Colors) = Colors.setLightColors(colors)

    fun setDarkColors(colors: Colors)= Colors.setDarkColors(colors)

    fun setColors(lightThemeColors: Colors, darkThemeColors: Colors) = Colors.setColors(lightThemeColors, darkThemeColors)

    fun setTypographies(typographies: Typographies) = Typographies.setTypographies(typographies)
}
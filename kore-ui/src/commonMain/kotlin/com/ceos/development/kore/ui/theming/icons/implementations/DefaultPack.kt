package com.ceos.development.kore.ui.theming.icons.implementations

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import com.ceos.development.kore.ui.theming.icons.IconsPack
import com.ceos.development.kore.ui.theming.icons.filled.*

@Immutable
class DefaultPack internal constructor(
    override val search: ImageVector = Search,
    override val dropDownExpanded: ImageVector = ArrowDropDown,
    override val dropDownCollapsed: ImageVector = ArrowDropUp,
    override val setting: ImageVector = Settings,
    override val reset: ImageVector = Reset,
    override val edit: ImageVector = Edit,
    override val back: ImageVector = Back,
    override val chevronRight: ImageVector = ChevronRight,
    override val clear: ImageVector = Close,
    override val close: ImageVector = Close,
) : IconsPack
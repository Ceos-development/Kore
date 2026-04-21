package com.ceos.development.kore.ui.theming.icons.implementations

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import com.ceos.development.kore.ui.theming.icons.IconsPack
import com.ceos.development.kore.ui.theming.icons.filled.Search

@Immutable
class DefaultPack internal constructor(
    override val search: ImageVector = Search
) : IconsPack
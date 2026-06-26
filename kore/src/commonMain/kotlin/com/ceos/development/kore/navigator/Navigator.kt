package com.ceos.development.kore.navigator

import kotlinx.coroutines.flow.Flow

interface Navigator {
    val events: Flow<NavigationEvent>
    fun navigateTo(destination: Destination)
    fun navigateBack()
    fun navigateBackTo(destination: Destination, inclusive: Boolean)
}
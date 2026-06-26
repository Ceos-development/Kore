package com.ceos.development.kore.navigator.implementations

import com.ceos.development.kore.navigator.Destination
import com.ceos.development.kore.navigator.NavigationEvent
import com.ceos.development.kore.navigator.Navigator
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

class NavigatorImpl : Navigator {
    private val _events = Channel<NavigationEvent>()
    override val events: Flow<NavigationEvent> = _events.receiveAsFlow()

    override fun navigateTo(destination: Destination) {
        _events.trySend(NavigationEvent.NavigationTo(destination))
    }

    override fun navigateBack() {
        _events.trySend(NavigationEvent.Back)
    }

    override fun navigateBackTo(destination: Destination, inclusive: Boolean) {
        _events.trySend(NavigationEvent.PopUpTo(destination, inclusive))
    }
}
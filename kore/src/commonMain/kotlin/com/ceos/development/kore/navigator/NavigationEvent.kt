package com.ceos.development.kore.navigator

interface NavigationEvent {
    class NavigationTo(val destination: Destination) : NavigationEvent
    class PopUpTo(val destination: Destination, val inclusive: Boolean) : NavigationEvent
    object Back : NavigationEvent
}
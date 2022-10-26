package com.ankitangra.core.util

sealed class UiEvent {
    data class Navigate (val route: String): UiEvent()
    object NavigateUp: UiEvent()
    data class ShowSnackBar(val message: UiText): UiEvent()
    object ShowLoading: UiEvent()
}

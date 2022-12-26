package com.vhontar.core.base

import androidx.lifecycle.ViewModel
import com.vhontar.core.util.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

abstract class BaseViewModel: ViewModel() {
    protected val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()
}
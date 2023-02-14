package com.chandra.myapplication.screens

import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarHostState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor() : ViewModel() {
    private val _mainScreenScaffoldState =
        ScaffoldState(
            drawerState = DrawerState(initialValue = DrawerValue.Closed),
            snackbarHostState = SnackbarHostState()
        )
    val mainScreenScaffoldState: ScaffoldState get() = _mainScreenScaffoldState

    fun handleEvent(events: MainScreenEvents) {
        when (events) {
            MainScreenEvents.CloseDrawer -> {
                if (_mainScreenScaffoldState.drawerState.isOpen) {
                    viewModelScope.launch {
                        _mainScreenScaffoldState.drawerState.close()
                    }
                }
            }
            MainScreenEvents.OpenDrawer -> {
                if (_mainScreenScaffoldState.drawerState.isClosed) {
                    viewModelScope.launch {
                        _mainScreenScaffoldState.drawerState.open()
                    }
                }
            }
        }
    }
}
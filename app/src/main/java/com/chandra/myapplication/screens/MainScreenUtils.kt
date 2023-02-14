package com.chandra.myapplication.screens

sealed class MainScreenEvents {
    object OpenDrawer : MainScreenEvents()
    object CloseDrawer : MainScreenEvents()
}
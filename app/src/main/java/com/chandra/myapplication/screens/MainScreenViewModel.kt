package com.chandra.myapplication.screens

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor() : ViewModel() {

    val sampleValue = 10000;

    fun handleEvent(events: MainScreenEvents) {

    }
}
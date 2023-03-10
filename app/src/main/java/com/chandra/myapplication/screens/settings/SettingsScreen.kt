package com.chandra.myapplication.screens.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.chandra.myapplication.navgraphs.MainNavGraph
import com.chandra.myapplication.screens.MainScreenViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
@MainNavGraph
@Destination
fun SettingsScreen(
    navigator: DestinationsNavigator,
    mainScreenViewModel: MainScreenViewModel
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Settings Screen ${mainScreenViewModel.sampleValue}")
    }
}
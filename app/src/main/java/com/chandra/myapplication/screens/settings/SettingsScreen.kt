package com.chandra.myapplication.screens.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.chandra.myapplication.navgraphs.MainNavGraph
import com.ramcosta.composedestinations.annotation.Destination


@Composable
@MainNavGraph
@Destination
fun SettingsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Settings Screen")
    }
}
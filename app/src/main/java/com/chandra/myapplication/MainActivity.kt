package com.chandra.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.chandra.myapplication.screens.NavGraphs
import com.chandra.myapplication.ui.theme.RaamcostaComposeDestinationsDemoTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RaamcostaComposeDestinationsDemoTheme {
               DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
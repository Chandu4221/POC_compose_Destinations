package com.chandra.myapplication.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.chandra.myapplication.molecules.bottomnavigation.BottomBarNavigation
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Destination
@RootNavGraph(start = true)
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBarNavigation(navController = navController)
        },
    ) { paddingValues ->
        DestinationsNavHost(
            navGraph = NavGraphs.main,
            navController = navController,
            modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
        )
    }
}
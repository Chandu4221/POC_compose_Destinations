package com.chandra.myapplication.screens.initial.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.chandra.myapplication.navgraphs.MainNavGraph
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Destination
@MainNavGraph(start = true)
fun HomeScreen(
    navigator: DestinationsNavigator,
    scaffoldState: ScaffoldState
) {

    val scope = rememberCoroutineScope()

    fun handleTopBarMeuIconClick() {
        if (scaffoldState.drawerState.isClosed) {
            Log.d("HomeScreen", "isClosed")
            scope.launch {
                scaffoldState.drawerState.open()
                Log.d("HomeScreen", "open()")
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(title = {}, navigationIcon = {
                IconButton(onClick = ::handleTopBarMeuIconClick) {
                    Icon(
                        imageVector = Icons.Filled.Menu, contentDescription = null
                    )
                }
            })
        },
    ) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(text = "Home Screen")
        }
    }
}
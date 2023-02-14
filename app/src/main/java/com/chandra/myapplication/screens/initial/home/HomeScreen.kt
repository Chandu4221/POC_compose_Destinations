package com.chandra.myapplication.screens.initial.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.chandra.myapplication.molecules.sidebarNavigation.SideDrawerBody
import com.chandra.myapplication.molecules.sidebarNavigation.SideDrawerHeader
import com.chandra.myapplication.molecules.sidebarNavigation.SideDrawerMenuItem
import com.chandra.myapplication.molecules.sidebarNavigation.SideDrawerMenuItemId
import com.chandra.myapplication.navgraphs.MainNavGraph
import com.chandra.myapplication.screens.destinations.DocumentsScreenDestination
import com.chandra.myapplication.screens.destinations.ReferralScreenDestination
import com.chandra.myapplication.screens.destinations.SettingsScreenDestination
import com.chandra.myapplication.screens.destinations.VehicleManagementScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Destination
@MainNavGraph(start = true)
fun HomeScreen(
    navigator:DestinationsNavigator
){
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(initialValue = DrawerValue.Closed)
    )
    val scope = rememberCoroutineScope()

    fun handleTopBarMeuIconClick() {
        scope.launch {
            if (scaffoldState.drawerState.isClosed) {
                scaffoldState.drawerState.open()
            }
        }
    }

    fun handleSidebarMenuItemClick(sideDrawerMenuItem: SideDrawerMenuItem) {
        when (sideDrawerMenuItem.id) {
            SideDrawerMenuItemId.DOCUMENT_MANAGEMENT -> {
                navigator.navigate(DocumentsScreenDestination)
            }
            SideDrawerMenuItemId.VEHICLE_MANAGEMENT -> {
                navigator.navigate(VehicleManagementScreenDestination)
            }
            SideDrawerMenuItemId.SETTINGS -> {
                navigator.navigate(SettingsScreenDestination)
            }
            SideDrawerMenuItemId.REFERRALS -> {
                navigator.navigate(ReferralScreenDestination)
            }
            SideDrawerMenuItemId.LOGOUT -> {

            }
        }
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = ::handleTopBarMeuIconClick) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        drawerContent = {
            SideDrawerHeader(onViewProfileClicked = {})
            SideDrawerBody(onSidebarMenuItemClicked = ::handleSidebarMenuItemClick)
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Home Screen")
        }
    }
}
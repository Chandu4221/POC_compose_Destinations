package com.chandra.myapplication.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.chandra.myapplication.molecules.bottomnavigation.BottomBarNavigation
import com.chandra.myapplication.molecules.sidebarNavigation.SideDrawerBody
import com.chandra.myapplication.molecules.sidebarNavigation.SideDrawerHeader
import com.chandra.myapplication.molecules.sidebarNavigation.SideDrawerMenuItem
import com.chandra.myapplication.molecules.sidebarNavigation.SideDrawerMenuItemId
import com.chandra.myapplication.screens.destinations.DocumentsScreenDestination
import com.chandra.myapplication.screens.destinations.ReferralScreenDestination
import com.chandra.myapplication.screens.destinations.SettingsScreenDestination
import com.chandra.myapplication.screens.destinations.VehicleManagementScreenDestination
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.dependency

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Destination
@RootNavGraph(start = true)
fun MainScreen(
    navigator: DestinationsNavigator,
) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(initialValue = DrawerValue.Closed)
    )

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
        drawerContent = {
            SideDrawerHeader(onViewProfileClicked = {})
            SideDrawerBody(onSidebarMenuItemClicked = ::handleSidebarMenuItemClick)
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        bottomBar = {
            BottomBarNavigation(navController = navController)
        }
    ) { paddingValues ->
        DestinationsNavHost(
            navGraph = NavGraphs.main,
            navController = navController,
            modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding()),
            dependenciesContainerBuilder = {
                dependency(scaffoldState)
            }
        )
    }
}
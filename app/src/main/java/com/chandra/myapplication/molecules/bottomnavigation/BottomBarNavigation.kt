package com.chandra.myapplication.molecules.bottomnavigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.FileCopy
import androidx.compose.material.icons.filled.Payments
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chandra.myapplication.screens.NavGraphs
import com.chandra.myapplication.screens.appCurrentDestinationAsState
import com.chandra.myapplication.screens.destinations.EarningsScreenDestination
import com.chandra.myapplication.screens.destinations.HomeScreenDestination
import com.chandra.myapplication.screens.destinations.SubscriptionsScreenDestination
import com.chandra.myapplication.screens.startAppDestination
import com.ramcosta.composedestinations.navigation.navigateTo
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

enum class BottomBarMenuItemId {
    HOME,
    EARNINGS,
    SUBSCRIPTION;

    companion object {
        fun getEnumValueInString(bottomBarMenuItemId: BottomBarMenuItemId): String {
            return when (bottomBarMenuItemId) {
                HOME -> "Home"
                EARNINGS -> "Earnings"
                SUBSCRIPTION -> "Subscription"
            }
        }

        fun getMenuIcon(bottomBarMenuItemId: BottomBarMenuItemId): ImageVector {
            return when (bottomBarMenuItemId) {
                HOME -> Icons.Filled.DirectionsCar
                EARNINGS -> Icons.Filled.Payments
                SUBSCRIPTION -> Icons.Filled.FileCopy
            }
        }
    }
}

enum class BottomBarDestination(
    val direction: DirectionDestinationSpec,
    val id: BottomBarMenuItemId,
    val icon: ImageVector,
    val title: String,
    val contentDescription: String?
) {
    HomeScreen(
        direction = HomeScreenDestination,
        id = BottomBarMenuItemId.HOME,
        title = BottomBarMenuItemId.getEnumValueInString(BottomBarMenuItemId.HOME),
        icon = BottomBarMenuItemId.getMenuIcon(BottomBarMenuItemId.HOME),
        contentDescription = BottomBarMenuItemId.getEnumValueInString(BottomBarMenuItemId.HOME)
    ),
    EarningsScreen(
        direction = EarningsScreenDestination,
        id = BottomBarMenuItemId.EARNINGS,
        title = BottomBarMenuItemId.getEnumValueInString(BottomBarMenuItemId.EARNINGS),
        icon = BottomBarMenuItemId.getMenuIcon(BottomBarMenuItemId.EARNINGS),
        contentDescription = BottomBarMenuItemId.getEnumValueInString(BottomBarMenuItemId.EARNINGS)
    ),
    SubscriptionsScreen(
        direction = SubscriptionsScreenDestination,
        id = BottomBarMenuItemId.SUBSCRIPTION,
        title = BottomBarMenuItemId.getEnumValueInString(BottomBarMenuItemId.SUBSCRIPTION),
        icon = BottomBarMenuItemId.getMenuIcon(BottomBarMenuItemId.SUBSCRIPTION),
        contentDescription = BottomBarMenuItemId.getEnumValueInString(BottomBarMenuItemId.SUBSCRIPTION)
    )
}

@Composable
fun BottomBarNavigation(navController: NavController) {
    val currentDestination = navController.appCurrentDestinationAsState().value
        ?: NavGraphs.root.startAppDestination

    BottomNavigation {
        BottomBarDestination.values().forEach { destination ->
            BottomNavigationItem(
                selected = currentDestination == destination.direction,
                onClick = {
                    navController.navigateTo(destination.direction) {
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = destination.contentDescription,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(text = destination.title) },
            )
        }
    }
}
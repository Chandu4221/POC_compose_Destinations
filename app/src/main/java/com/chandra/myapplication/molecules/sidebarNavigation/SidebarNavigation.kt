package com.chandra.myapplication.molecules.sidebarNavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

// DEFINING SET OF IDs FOR THE SIDE BAR NAVIGATION ITEMS
// ALSO USING THE STRING VALUES OF THAT ENUMS
enum class SideDrawerMenuItemId {
    DOCUMENT_MANAGEMENT, // TODO :- designs required for document flow
    VEHICLE_MANAGEMENT,
    SETTINGS,
    REFERRALS,
    LOGOUT;

    companion object {
        // USED FOR SETTING THE TEXT OF THE MENU ITEM
        fun getEnumValueInString(sideDrawerMenuItemId: SideDrawerMenuItemId): String {
            return when (sideDrawerMenuItemId) {
                VEHICLE_MANAGEMENT -> "Vehicle Management"
                DOCUMENT_MANAGEMENT -> "Documents Management"
                SETTINGS -> "Settings"
                REFERRALS -> "Referrals"
                LOGOUT -> "Logout"
            }
        }

        fun getMenuIcon(sideDrawerMenuItemId: SideDrawerMenuItemId): ImageVector? {
            // USED FOR SETTING THE ICON FOR THE MENU ITEM
            return when (sideDrawerMenuItemId) {
                VEHICLE_MANAGEMENT -> Icons.Filled.LocalTaxi
                DOCUMENT_MANAGEMENT -> Icons.Filled.Description
                SETTINGS -> Icons.Filled.Settings
                REFERRALS -> Icons.Filled.Redeem
                LOGOUT -> Icons.Filled.Logout
            }
        }
    }
}

data class SideDrawerMenuItem(
    val id: SideDrawerMenuItemId,
    val title: String,
    val icon: ImageVector?,
    val contentDescription: String?
)

@Composable
fun SideDrawerHeader(
    driverProfilePic: String? = null,
    driverName: String? = null,
    onViewProfileClicked: () -> Unit
) {

    // PROFILE IMAGE AND NAME
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .padding(top = 56.dp, bottom = 20.dp)
            .statusBarsPadding(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = Icons.Filled.Person,
            contentDescription = "Profile Photo",
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .size(72.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary)
        )

        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            if (driverName != null) {
                Text(
                    text = driverName,
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.surface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "View Profile",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onViewProfileClicked()
                    }
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            Icons.Filled.ChevronRight,
            contentDescription = null,
            tint = MaterialTheme.colors.surface
        )
    }
}

val sidebarMenuItems = SideDrawerMenuItemId.values().map { menuId ->
    SideDrawerMenuItem(
        id = menuId,
        title = SideDrawerMenuItemId.getEnumValueInString(menuId),
        icon = SideDrawerMenuItemId.getMenuIcon(menuId),
        contentDescription = SideDrawerMenuItemId.getEnumValueInString(menuId)
    )
}

@Composable
fun SideDrawerBody(
    menuItems: List<SideDrawerMenuItem> = sidebarMenuItems,
    onSidebarMenuItemClicked: (SideDrawerMenuItem) -> Unit
) {
    Column {
        LazyColumn() {
            itemsIndexed(menuItems) { index, menuItem ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onSidebarMenuItemClicked(menuItem)
                        }
                ) {
                    menuItem.icon?.let {
                        // IF ICON FOR THE MENU ITEM EXISTS THE SHOW THE ICON ELSE DON'T RENDER
                        Image(
                            imageVector = menuItem.icon,
                            contentDescription = menuItem.contentDescription,
                            modifier = Modifier
                                .size(24.dp)
                                .offset(20.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                    }
                    Text(
                        text = menuItem.title,
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.primary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                vertical = 16.dp,
                                horizontal = 20.dp
                            )
                    )

                }
                if (index < menuItems.lastIndex) {
                    Divider(
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier
                            .alpha(0.06f)
                            .padding(end = 20.dp),
                        startIndent = 20.dp,
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Apk Version",
            style = MaterialTheme.typography.caption,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}
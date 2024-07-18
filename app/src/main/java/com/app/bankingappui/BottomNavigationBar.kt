package com.app.bankingappui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.app.bankingappui.data.BottomNavigation

val items = listOf(
	BottomNavigation(title = "Home",icon = Icons.Default.Home),
	BottomNavigation(title = "Wallet",icon = Icons.Default.Wallet),
	BottomNavigation(title = "Notification",icon = Icons.Default.Notifications),
	BottomNavigation(title = "Account",icon = Icons.Default.AccountCircle),
)

@Preview
@Composable
fun BottomNavigationBar(){
	NavigationBar{
		Row (
			modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
		) {
			items.forEachIndexed { index, item ->
				NavigationBarItem(
					selected = index==0,
					onClick = { /*TODO*/ },
					icon = {
						Icon(imageVector = item.icon,contentDescription = item.title, tint = MaterialTheme.colorScheme.onBackground)
					},
					label = {
						Text(text = item.title,color = MaterialTheme.colorScheme.onBackground)
					}
				)
			}
		}
	}
}
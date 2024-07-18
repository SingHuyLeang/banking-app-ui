package com.app.bankingappui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.bankingappui.data.Finance
import com.app.bankingappui.ui.theme.*

val finances = listOf(
	Finance(
		icon = Icons.Rounded.StarHalf,
		name = "My\nBusiness",
		background = OrangeStart
	),

	Finance(
		icon = Icons.Rounded.Wallet,
		name = "My\nWallet",
		background = BlueStart
	),

	Finance(
		icon = Icons.Rounded.StarHalf,
		name = "Finance\nAnalytics",
		background = PurpleStart
	),

	Finance(
		icon = Icons.Rounded.MonetizationOn,
		name = "My\nTransactions",
		background = GreenStart
	),
)

@Preview
@Composable
fun FinanceSection() {
	Column {
		Text(
			text = "Finance",
			fontSize = 24.sp,
			color = MaterialTheme.colorScheme.onBackground,
			fontWeight = FontWeight.Bold,
			modifier = Modifier.padding(16.dp)
		)
		LazyRow {
			items(finances.size) { index ->
				FinanceItem(index = index)
			}
		}
	}
}

@Composable
fun FinanceItem(index: Int) {
	val finance = finances[index]
	var lastItemPaddingEnd = 0.dp
	if (index == cards.size - 1) {
		lastItemPaddingEnd = 16.dp
	}

	Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)) {
		Column (
			modifier = Modifier
				.size(120.dp)
				.clip(RoundedCornerShape(25.dp))
				.clickable { }
				.background(MaterialTheme.colorScheme.secondaryContainer)
				.padding(13.dp),
			verticalArrangement = Arrangement.SpaceBetween,
		) {
			Box(
				modifier = Modifier
					.clip(RoundedCornerShape(16.dp))
					.background(finance.background)
					.padding(6.dp)
			){
				Icon(imageVector = finance.icon, contentDescription = finance.name, tint = Color.White)
			}
			Text(text = finance.name, color = MaterialTheme.colorScheme.onSecondaryContainer, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
		}
	}
}

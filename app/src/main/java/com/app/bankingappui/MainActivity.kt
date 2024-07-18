package com.app.bankingappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.bankingappui.ui.theme.AppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			AppTheme {
				SetActionBar(color = MaterialTheme.colorScheme.background)
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					HomeScreen()
				}
			}
		}
	}
	@Composable
	private fun SetActionBar(color: Color) {
		val systemUiController = rememberSystemUiController()
		SideEffect {
			systemUiController.setSystemBarsColor(
				color = color
			)
		}
	}
}

@Preview(showBackground = true, showSystemUi = true, device = "id:pixel_8_pro", name = "Main Activity")
@Composable
private fun HomeScreen(){
	Scaffold(
		bottomBar = {
			BottomNavigationBar()
		}
	) {
		Column (modifier = Modifier
			.fillMaxSize()
			.padding(it)
		) {
//		    -- Wallet     Section
			WalletSection()
//		    -- Cards      Section
			CardSection()
			Spacer(modifier = Modifier.height(16.dp))
//		    -- Finance    Section
			FinanceSection()
//		    -- Currencies Section
			CurrenciesSection()
		}
	}
}
package com.codesmiths.krishisalah_buyer

import android.R.attr.type
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.codesmiths.krishisalah_buyer.screen.BuyerHomePage
import com.codesmiths.krishisalah_buyer.screen.LoginScreen
import com.codesmiths.krishisalah_buyer.screen.OrderScreen
import com.codesmiths.krishisalah_buyer.screen.ProductDetailsScreen
import com.codesmiths.krishisalah_buyer.screen.SignUpScreen
import com.codesmiths.krishisalah_buyer.screen.WelcomePage
import com.codesmiths.krishisalah_buyer.ui.theme.KrishiSalahBuyerTheme
import com.codesmiths.krishisalah_buyer.viewModels.BuyerViewModel

class MainActivity : ComponentActivity() {
    lateinit var viewModel: BuyerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val factory = UserViewModelFactory(applicationContext)
        viewModel = ViewModelProvider(this, factory)[BuyerViewModel::class.java]
        setContent {
            KrishiSalahBuyerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Navigation(Modifier.padding(innerPadding),viewModel)
                }
            }
        }
    }
}
class UserViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BuyerViewModel::class.java)) {
            return BuyerViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
@Composable
fun Navigation(modifier: Modifier= Modifier,viewModel: BuyerViewModel){
    val navController= rememberNavController()
    NavHost(navController,"welcome") {
        composable("welcome") {
            WelcomePage(navController)
        }
        composable("home") {
            BuyerHomePage(navController,viewModel)
        }
        composable("login") {
            LoginScreen(navController,viewModel)
        }
        composable("signup") {
            SignUpScreen(navController,viewModel)
        }
        composable("product-details/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.StringType })) {
            val productId = it.arguments?.getString("productId")
            if (productId != null) {
                ProductDetailsScreen(productId,navController,viewModel)
            }
        }
        composable("place-order/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.StringType })) {
            val productId = it.arguments?.getString("productId")
            if (productId != null) {
                OrderScreen(productId, navController = navController, viewModel = viewModel)
            }
        }
    }
}
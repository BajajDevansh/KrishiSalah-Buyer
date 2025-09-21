package com.codesmiths.krishisalah_buyer.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.codesmiths.krishisalah_buyer.R

@Composable
fun WelcomePage(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        Image(
            painter = painterResource(R.drawable.app_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        Box(
            Modifier
                .matchParentSize()
                .background(Color.Black.copy(alpha = 0.2f))
        ) {
            Column(
                modifier = Modifier.matchParentSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.ks_ic),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(300.dp)
                        .padding(vertical = 0.dp),
                    colorFilter = ColorFilter.tint(
                        Color.White
                    )

                )
                Column(
                    Modifier.padding(horizontal = 28.dp),
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 32.dp, end = 32.dp, bottom = 10.dp),
                        onClick = {
                            navController.navigate("login")
                        }) {
                        Text("Login", fontSize = 22.sp, color = colorResource(R.color.app_green))
                    }
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        ), modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp),
                        onClick = {
                            navController.navigate("signup")
                        }) {
                        Text(
                            "Sign Up",
                            fontSize = 22.sp,
                            color = colorResource(R.color.app_green)
                        )
                    }
                }
            }
        }
    }
}
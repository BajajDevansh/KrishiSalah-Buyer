package com.codesmiths.krishisalah_buyer.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codesmiths.krishisalah_buyer.R

@Composable
@Preview(showSystemUi = true)
fun LoginScreen(){
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
    ){
        Image(
            painter = painterResource(R.drawable.app_bg),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.matchParentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Login",
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
            Text(text = "Enter your credentials to continue",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 50.dp)
            )
            Box(
                modifier = Modifier
                    .width(375.dp)
                    .height(620.dp)
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(30.dp)
                    )
            ){
                Column(
                    modifier = Modifier
                        .matchParentSize()
                        .padding(start = 10.dp, top = 30.dp)
                ){
                    Text("Phone Number", fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        value = phoneNumber,
                        onValueChange = { phoneNumber = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp, top = 3.dp),
                        shape = RoundedCornerShape(15.dp)
                    )

                    Spacer(Modifier.height(20.dp))

                    Text("Password", fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp, top = 3.dp),
                        shape = RoundedCornerShape(15.dp)
                    )

                    Spacer(Modifier.height(30.dp))

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp)
                            .padding(end = 10.dp, top = 3.dp),
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.app_green)
                        )
                    ) {
                        Text("Login", fontSize = 20.sp)
                    }

                    Spacer(Modifier.height(25.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Don't have an account? Sign Up",
                            fontSize = 15.sp,
                            modifier = Modifier.clickable{

                            }
                        )
                    }
                }
            }
        }
    }
}
package com.codesmiths.krishisalah_buyer.screen

import android.text.Html
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
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
fun CartScreen(){
    val color=colorResource(R.color.app_green)
    Box(
        modifier = Modifier.fillMaxSize()
            .background(
            color.copy(0.9f)
        )
    ){
        Scaffold(
            modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars),
            topBar = {
                Column(
                    Modifier.height(height = 70.dp).background(
                        color.copy(0.9f)
                    )

                ){
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            ,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = {/*Todo*/ }) {
                            Icon(
                                painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                                contentDescription = "Back", tint = Color.White
                            )

                        }
                        Text("Cart", fontSize = 24.sp, color = Color.White)
                        IconButton(onClick = {/*Todo*/ }) {
                            Icon(
                                painter = painterResource(R.drawable.outline_notifications_24),
                                contentDescription = "Back", tint = Color.White
                            )

                        }
                    }

                }
            },bottomBar = {
                CheckoutBar(
                    totalPrice = "$7.69",
                    onPaymentClick = {}
                )
            }
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .padding(
                        vertical = 30.dp,
                        horizontal = 10.dp)
            ) {
                item {
                    CartItem(
                        name = "Orange",
                        category = "Fruits",
                        price = "$2.99",
                        unit = "KG",
                        qty = 1,
                        imageRes = R.drawable.ic_crop,
                        onIncrease = {},
                        onDecrease = {}
                    )
                    CartItem(
                        name = "Cauli Flower",
                        category = "Veggies",
                        price = "$1.20",
                        unit = "KG",
                        qty = 1,
                        imageRes = R.drawable.ic_crop,
                        onIncrease = {},
                        onDecrease = {}
                    )
                    CartItem(
                        name = "Kiwi",
                        category = "Fruits",
                        price = "$1.50",
                        unit = "KG",
                        qty = 1,
                        imageRes = R.drawable.ic_crop,
                        onIncrease = {},
                        onDecrease = {}
                    )

                    Spacer(modifier = Modifier.height(12.dp))


                    Spacer(modifier = Modifier.height(12.dp))

                    PriceSummary(
                        subTotal = "$05.69",
                        delivery = "$02.00",
                        discount = "$00.00",
                        finalTotal = "$07.69"
                    )
                }
                }
            }
        }
    }
@Composable
fun CartItem(
    name: String,
    category: String,
    price: String,
    unit: String,
    qty: Int,
    imageRes: Int,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White, RoundedCornerShape(12.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(category, color = Color.Gray, fontSize = 13.sp)
            Text(price + "/" + unit, color = Color(0xFF008324), fontWeight = FontWeight.Bold)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp) // final size of button
                    .clip(CircleShape)
                    .background(Color(0xFFE0E0E0), CircleShape)
                    .clickable {  },
                contentAlignment = Alignment.Center
            ) {
                Icon(painterResource(R.drawable.outline_remove_24), contentDescription = "Decrease", tint = Color.White)
            }

            Text("$qty", modifier = Modifier.padding(horizontal = 8.dp))

            Box(
                modifier = Modifier
                    .size(24.dp) // final size of button
                    .clip(CircleShape)
                    .background(Color(0xFF008324), CircleShape)
                    .clickable {  },
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Add, contentDescription = "Increase", tint = Color.White)
            }

        }
    }
}
@Composable
fun PriceSummary(
    subTotal: String,
    delivery: String,
    discount: String,
    finalTotal: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(12.dp))
            .padding(12.dp)
    ) {
        RowItem("Sub Total", subTotal)
        RowItem("Delivery Charges", delivery)
        RowItem("Discount", discount)
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        RowItem("Final Total", finalTotal, bold = true)
    }
}

@Composable
fun RowItem(label: String, value: String, bold: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, fontSize = 14.sp, fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal)
        Text(
            value,
            fontSize = 14.sp,
            fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal
        )
    }
}
@Composable
fun CheckoutBar(
    totalPrice: String,
    onPaymentClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Total Price
        Column {
            Text("Total Price", color = Color.Gray, fontSize = 16.sp)
            Text(
                totalPrice,
                color = Color(0xFF008324),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Payment Button
        Button(
            onClick = onPaymentClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF008324)),
            shape = RoundedCornerShape(50),
            contentPadding = PaddingValues(horizontal = 40.dp, vertical = 12.dp)
        ) {
            Text("Payment", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

package com.codesmiths.krishisalah_buyer.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.codesmiths.krishisalah_buyer.R
import com.codesmiths.krishisalah_buyer.models.OrderRequest
import com.codesmiths.krishisalah_buyer.models.ProductId
import com.codesmiths.krishisalah_buyer.viewModels.BuyerViewModel

@Composable
fun OrderScreen(
    productId: String,
    viewModel: BuyerViewModel,
    navController: NavController
) {
    viewModel.fetchProductById(ProductId(productId))
    val product=viewModel.productDetails.collectAsState().value!!.ThisProduct
    var qty by remember { mutableStateOf(1) }

    val totalPrice = product.pricePerUnit * qty

    Scaffold (
        bottomBar = {
            Button(
                onClick = {
                    viewModel.placeOrder(OrderRequest(
                        productId,
                        qty,
                        totalPrice
                    ))
                    if (viewModel.orderState.value.isSuccess) navController.navigate("home")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF008324)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Place Order", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            val bitmap = remember(product.images) {
                if (product.images.isNotEmpty()) base64ToBitmap(product.images.first())
                else null
            }

            Image(
                bitmap = bitmap?.asImageBitmap() ?: ImageBitmap.imageResource(R.drawable.ic_placeholder),
                contentDescription = product.productName,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Product Title
            Text(
                text = product.productName,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "₹${product.pricePerUnit} per ${product.unit}",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF008324)
            )

            Spacer(modifier = Modifier.height(12.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Quantity:", fontSize = 18.sp, fontWeight = FontWeight.Medium)

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { if (qty > 1) qty-- },
                        modifier = Modifier
                            .size(36.dp)
                            .background(Color(0xFF008324), CircleShape)
                    ) {
                        androidx.compose.material3.Icon(
                            painterResource(R.drawable.outline_remove_24),
                            contentDescription = "Decrease",
                            tint = Color.White
                        )
                    }

                    Text(
                        text = qty.toString(),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )

                    IconButton(
                        onClick = { if (qty < product.currentQuantity) qty++ },
                        modifier = Modifier
                            .size(36.dp)
                            .background(Color(0xFF008324), CircleShape)
                    ) {
                        androidx.compose.material3.Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Increase",
                            tint = Color.White
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Total: ₹$totalPrice",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

package com.codesmiths.krishisalah_buyer.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codesmiths.krishisalah_buyer.R
import com.codesmiths.krishisalah_buyer.models.ProductId
import com.codesmiths.krishisalah_buyer.viewModels.BuyerViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.navigation.NavController

@Composable
fun ProductDetailsScreen(
    prodId: String,
    navController: NavController,
    viewModel: BuyerViewModel
) {
    viewModel.fetchProductById(ProductId(prodId))


    val productWrapperState = viewModel.productDetails.collectAsState()
    val productWrapper = productWrapperState.value


    if (productWrapper == null || productWrapper.ThisProduct == null) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
            Text("Loading product details...")
        }
        return
    }

    val product = productWrapper.ThisProduct
    Scaffold(
        bottomBar = {
            Button(
                onClick = {
                    navController.navigate("place-order/${prodId}")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF008324)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Buy Now", color = Color.White, fontWeight = FontWeight.Companion.Bold, fontSize = 18.sp)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {


            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .padding(top = 8.dp)
            ) {
                if (product.images.isNotEmpty()) {
                    items(product.images) { imgBase64 ->
                        val bitmap = remember(imgBase64) { base64ToBitmap(imgBase64) }
                        Image(
                            bitmap = bitmap!!.asImageBitmap(),
                            contentDescription = product.productName,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(8.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .fillParentMaxHeight()
                                .width(200.dp)
                        )
                    }
                } else {

                    item {
                        Image(
                            painter = painterResource(R.drawable.ic_placeholder),
                            contentDescription = "No Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(8.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .fillMaxHeight()
                                .width(200.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = product.productName,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Text(
                text = "Category: ${product.category}",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )

            Divider(modifier = Modifier.padding(vertical = 8.dp))

            Text(
                text = product.description,
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Available: ${product.currentQuantity} / ${product.quantity} ${product.unit}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Text(
                text = "Price: ₹${product.pricePerUnit} per ${product.unit}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF008324),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Location:",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Text(
                text = "${product.location.village}, ${product.location.district}, ${product.location.state} - ${product.location.pincode}",
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
            )
        }
    }
}

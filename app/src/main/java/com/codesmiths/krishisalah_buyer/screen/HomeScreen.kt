package com.codesmiths.krishisalah_buyer.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codesmiths.krishisalah_buyer.R

@Composable
@Preview(showSystemUi = true)
fun HomePage(){
    val color = colorResource(R.color.app_green)
    Scaffold(
        modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars),
        topBar = {
            Column(
                modifier= Modifier.background(
                    Brush.linearGradient(
                        listOf(color.copy(0.9f),color.copy(0.6f))
                    )
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {/*Todo*/ }) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                            contentDescription = "Back", tint = Color.White
                        )

                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.baseline_location_pin_24),
                                contentDescription = "Location",
                                tint = colorResource(R.color.text_green)
                            )
                            Text("Location", fontSize = 18.sp,
                                color = colorResource(R.color.text_green))

                        }
                        Text("Faridabad, Haryana",
                            fontSize = 20.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold)
                    }
                    IconButton(onClick = {/*Todo*/ }) {
                        Icon(
                            painter = painterResource(R.drawable.outline_notifications_24),
                            contentDescription = "Back", tint = Color.White
                        )

                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                SearchBar(
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        },
        bottomBar = {
            BottomAppBar(
                tonalElevation = 5.dp,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ){
                    BottomBarItem(icon = R.drawable.baseline_home_24, text = "Home")
                    BottomBarItem(icon = R.drawable.baseline_person_24, text = "Profile")
                    BottomBarItem(icon = R.drawable.outline_shopping_cart_24, text = "Cart")
                }
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(
                    vertical = 30.dp,
                    horizontal = 10.dp
                )
        ){
            item{
                Text("Categories", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))
                LazyRow(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    item{
                        CategoryItem(img = R.drawable.ic_crop, name = "Crops")
                        Spacer(modifier = Modifier.width(10.dp))
                        CategoryItem(img = R.drawable.ic_milk, name = "Dairy")
                        Spacer(modifier = Modifier.width(10.dp))
                        CategoryItem(img = R.drawable.ic_crop, name = "Crops")
                        Spacer(modifier = Modifier.width(10.dp))
                        CategoryItem(img = R.drawable.ic_milk, name = "Dairy")
                        Spacer(modifier = Modifier.width(10.dp))
                        CategoryItem(img = R.drawable.ic_crop, name = "Crops")
                        Spacer(modifier = Modifier.width(10.dp))
                        CategoryItem(img = R.drawable.ic_milk, name = "dairy")
                        Spacer(modifier = Modifier.width(10.dp))
                        CategoryItem(img = R.drawable.ic_crop, name = "Crops")
                        Spacer(modifier = Modifier.width(10.dp))

                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text("Products", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ProductCard(
                        name="Wheat",
                        price="Rs. 30",
                        unit="Kg",
                        rating = 4.5f,
                        imageRes = R.drawable.ic_crop,
                        onAddClick = {},

                    )
                    ProductCard(
                        name="Milk",
                        price="Rs. 30",
                        unit="liter",
                        rating = 4.0f,
                        imageRes = R.drawable.ic_milk,
                        onAddClick = {},

                    )
                }
                Row(
                    Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ProductCard(
                        name="Wheat",
                        price="Rs. 30",
                        unit="Kg",
                        rating = 4.5f,
                        imageRes = R.drawable.ic_crop,
                        onAddClick = {},

                    )
                    ProductCard(
                        name="Milk",
                        price="Rs. 30",
                        unit="liter",
                        rating = 4.0f,
                        imageRes = R.drawable.ic_milk,
                        onAddClick = {},

                    )
                }
                Row(
                    Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ProductCard(
                        name="Wheat",
                        price="Rs. 30",
                        unit="Kg",
                        rating = 4.5f,
                        imageRes = R.drawable.ic_crop,
                        onAddClick = {},

                    )
                    ProductCard(
                        name="Milk",
                        price="Rs. 30",
                        unit="liter",
                        rating = 4.0f,
                        imageRes = R.drawable.ic_milk,
                        onAddClick = {},

                    )
                }
            }
        }
    }
}
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "Search Your Groceries",
    onSearch: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf("") }
    var isActive by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(Color.White),
        contentAlignment = Alignment.CenterStart
    ) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            singleLine = true,
            enabled = isActive,
            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 50.dp)
                .onFocusChanged { focusState ->
                    isActive = focusState.isFocused
                },
            decorationBox = { innerTextField ->
                if (text.isEmpty() && !isActive) {
                    Text(
                        text = hint,
                        color = Color.Gray,
                        fontSize = 16.sp
                    )
                }
                innerTextField()
            }
        )

        // Right-side Icon
        IconButton(
            onClick = {
                if (isActive && text.isNotEmpty()) {
                    // clear text
                    text = ""
                } else {
                    // activate field
                    isActive = true
                }
            },
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 8.dp)
                .size(30.dp)
        ) {
            Icon(
                painter = painterResource(
                    if (isActive && text.isNotEmpty())
                        R.drawable.baseline_close_24 // cross
                    else
                        R.drawable.baseline_search_24 // search
                ),
                contentDescription = "Search",
                tint = colorResource(R.color.app_green)
            )
        }
    }
}

@Composable
fun BottomBarItem(
    icon:Int,
    text:String
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        IconButton(onClick = {}) {
            Icon(
                painter = painterResource(icon),
                contentDescription = text, tint = Color.Gray,
                modifier = Modifier.size(30.dp)
            )
        }
        Text(text, fontSize = 17.sp, color = Color.Gray)
    }
}

@Composable
fun CategoryItem(
    img:Int,
    name:String
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(Modifier.clip(CircleShape)) {
            Image(
                painter = painterResource(img),
                contentDescription = name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(60.dp).clip(CircleShape)
            )
        }
        Text(name, fontSize = 14.sp)
    }
}
@Composable
fun ProductCard(
    name: String,
    price: String,
    unit: String,
    rating: Float,
    imageRes: Int,
    onAddClick: () -> Unit,

) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image with favorite icon
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = name,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                    contentScale = ContentScale.Crop
                )


            }

            Spacer(Modifier.height(8.dp))

            // Product name
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            // Rating
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                repeat(5) { index ->
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star",
                        tint = if (index < rating.toInt()) Color(0xFFFFA000) else Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            // Price row with add button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$price/$unit",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color(0xFF008324),
                        fontWeight = FontWeight.Bold
                    )
                )
                IconButton(
                    onClick = onAddClick,
                    modifier = Modifier
                        .size(32.dp)
                        .background(Color(0xFF008324), CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

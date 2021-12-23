package com.example.buahin.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buahin.R
import com.example.buahin.ui.components.*
import com.example.buahin.ui.theme.*
import cz.levinzonr.saferoute.core.annotations.Route
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Route("productDetail")
@Composable
fun ProductDetailScreen() {
    val scaffoldState = rememberCollapsingToolbarScaffoldState()
    Scaffold(
        floatingActionButton = {
            RoundedButton.Filled(
                "Add to Cart",
                onClick = {},
                modifier = Modifier.padding(horizontal = 20.dp),
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) {
        CollapsingToolbarScaffold(
            modifier = Modifier.fillMaxSize(),
            state = scaffoldState,
            scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
            toolbar = {
                val radius = (25 * scaffoldState.toolbarState.progress).dp
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .height(300.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(bottomStart = radius, bottomEnd = radius))
                        .parallax(1f)
                        .background(Grey200),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.apple_large),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(45.dp)
                    )
                }
                TopBar(
                    elevation = 0.dp,
                    backgroundColor = Color.Transparent,
                    onBackPressed = {},
                    modifier = Modifier.pin(),
                    trailing = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_share),
                                contentDescription = null
                            )

                        }
                    }
                )


            }
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                item {
                    Row(
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                    ) {
                        Column(modifier = Modifier.weight(1f, true)) {
                            Text(
                                text = "Naturel Red Apple",
                                style = Typography.h6,
                                fontWeight = FontWeight.Bold,
                            )
                            Text(
                                text = "1kg, Price",
                                style = Typography.subtitle2,
                                lineHeight = 18.sp,
                                fontWeight = FontWeight.Medium,
                                color = Grey500,
                            )
                        }
                        Icon(
                            painter = painterResource(id = R.drawable.ic_favourite),
                            contentDescription = "",
                            tint = Grey500,
                        )
                    }
                }
                item {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                    ) {
                        Counter(onDecreased = {}, onIncreased = {})
                        Text(
                            text = "Rp. 120.000",
                            style = Typography.h6,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                item {
                    ExpandableListTile(
                        "Product Details",
                        "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet."
                    )
                }
                item {
                    ExpandableListTile(
                        "Nutrition",
                        "this is nutrition"
                    )
                }
                item {
                    ExpandableListTile(
                        "Review",
                        "this is review"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ProductDetailScreenPreview() {
    BuahinTheme {
        ProductDetailScreen()
    }
}
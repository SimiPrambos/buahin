package com.example.buahin.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.buahin.R
import com.example.buahin.ui.components.*
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Grey200
import com.example.buahin.ui.theme.Grey500
import com.example.buahin.ui.theme.Typography
import com.example.buahin.viewmodel.*
import cz.levinzonr.saferoute.core.annotations.Route
import cz.levinzonr.saferoute.core.annotations.RouteArg
import kotlinx.coroutines.launch
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Route("productDetail", [RouteArg(name = "id", isOptional = false)])
@Composable
fun ProductDetailScreen(
    navController: NavController,
    vm: ProductDetailViewModel = hiltViewModel(),
) {
    val state = vm.state.value

    LaunchedEffect(true) {
        vm.onEvent(ProductDetailEvent.Load)
    }

    when (state) {
        is ProductDetailState.Empty -> {
            Scaffold {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Product not found!")
                }
            }
        }
        is ProductDetailState.Success -> {
            val scaffoldState = rememberCollapsingToolbarScaffoldState()
            val qtyState = remember { mutableStateOf(1) }
            val cart: CartViewModel = hiltViewModel()
            val scope = rememberCoroutineScope()

            fun onAddToCardPressed() {
                val qty = qtyState.value
                qtyState.value = 1
                scope.launch {
                    cart.onEvent(CartEvent.CartAdded(state.value, qty))
                }
            }

            Scaffold(
                floatingActionButton = {
                    AddToCartWidget(
                        cart.state.value.items.size,
                        onAddToCartPressed = ::onAddToCardPressed,
                        onShowCartPressed = {
//                            navController.popBackStack()
                            navController.navigateToCart()
                        },
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
                                .parallax(0.5f)
                                .background(Grey200),
                        ) {
                            Image(
                                painter = rememberImagePainter(state.value.thumbnail),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize(),
                            )
                        }
                        TopBar(
                            elevation = 0.dp,
                            backgroundColor = Color.Transparent,
                            onBackPressed = {
                                navController.popBackStack()
                            },
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
                                        text = state.value.name,
                                        style = Typography.h6,
                                        fontWeight = FontWeight.Bold,
                                    )
                                    Text(
                                        text = state.value.summary,
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
                                Counter(
                                    value = qtyState.value,
                                    onDecreased = { qtyState.value = qtyState.value - 1 },
                                    onIncreased = { qtyState.value = qtyState.value + 1 },
                                )
                                Text(
                                    text = state.value.idr(),
                                    style = Typography.h6,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                        if (!state.value.description.isNullOrEmpty())
                            item {
                                ExpandableListTile(
                                    "Product Details",
                                    state.value.description,
                                    expand = true,
                                )
                            }
                        if (!state.value.nutrition.isNullOrEmpty())
                            item {
                                ExpandableListTile(
                                    "Nutrition",
                                    state.value.nutrition
                                )
                            }
                        if (!state.value.howToSave.isNullOrEmpty())
                            item {
                                ExpandableListTile(
                                    "How to Save",
                                    state.value.howToSave
                                )
                            }
                    }
                }
            }
        }
        else -> {
            Scaffold {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }


}

@Preview
@Composable
fun ProductDetailScreenPreview() {
    BuahinTheme {
        ProductDetailScreen(rememberNavController())
    }
}
package com.example.poc.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    // on below line we are adding green color
    private val greenColor = Color(0xFF0F9D58)

    @OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // on below line we are calling tab
                // layout method for displaying tab layout
                Box(modifier = Modifier.fillMaxSize()) {
                    TabLayout()
                    val sheetState = androidx.compose.material3.rememberModalBottomSheetState()
                    val scope = rememberCoroutineScope()
                    var showBottomSheet by remember { mutableStateOf(false) }
                    Button(onClick = {
                        showBottomSheet = true
                    }) {
                        Text("Show bottom sheet")
                    }

                    if (showBottomSheet) {
                        ModalBottomSheet(
                            onDismissRequest = {
                                showBottomSheet = false
                            },
                            sheetState = sheetState,
                        ) {
                            // Sheet content
                            Button(onClick = {
                                scope.launch { sheetState.hide() }.invokeOnCompletion {
                                    if (!sheetState.isVisible) {
                                        showBottomSheet = false
                                    }
                                }
                            }) {
                                Text("Hide bottom sheet")
                            }
                        }
                    }
                }
            }
        }
    }

    // on below line we are creating a
// composable function for our tab layout
    @ExperimentalPagerApi
    @Composable
    fun TabLayout() {

        // on below line we are creating variable for pager state.
        val pagerState = rememberPagerState(0)

        // on below line we are creating a column for our widgets.
        Column(
            // for column we are specifying modifier on below line.
            modifier = Modifier.background(Color.White)
        ) {
            // on the below line we are specifying the top app bar
            // and specifying background color for it.
            TopAppBar(backgroundColor = greenColor) {
                // on below line we are specifying a column
                // for our text view to display a text
                // in our top app bar.
                Column(
                    modifier = Modifier.fillMaxSize(),
                    // on below line we are providing alignment for our
                    // column to center of our top app bar.
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // on below line we are specifying a text and
                    // specifying a text as "Tab Layout Example"
                    Text(
                        text = "Tab Layout Example",
                        style = TextStyle(color = Color.White),
                        fontWeight = FontWeight.Bold,
                        fontSize = TextUnit(
                            18F,
                            TextUnitType.Sp
                        ),
                        // on below line we are specifying a modifier
                        // to our text and adding passing from all sides.
                        modifier = Modifier.padding(all = Dp(5F)),
                        // on below line we are aligning
                        // our text to center.
                        textAlign = TextAlign.Center
                    )
                }
            }
            // on below line we are calling tabs
            Tabs(pagerState = pagerState)
            // on below line we are calling tabs content
            // for displaying our page for each tab layout
            TabsContent(pagerState = pagerState)
        }
    }

    // on below line we are
// creating a function for tabs
    @ExperimentalPagerApi
    @Composable
    fun Tabs(pagerState: PagerState) {
        // in this function we are creating a list
        // in this list we are specifying data as
        // name of the tab and the icon for it.
        val list = listOf(
            "Home" to Icons.Default.Home,
            "Shopping" to Icons.Default.ShoppingCart,
            "Settings" to Icons.Default.Settings
        )
        // on below line we are creating
        // a variable for the scope.
        val scope = rememberCoroutineScope()
        // on below line we are creating a
        // individual row for our tab layout.
        TabRow(
            // on below line we are specifying
            // the selected index.
            selectedTabIndex = pagerState.currentPage,

            // on below line we are
            // specifying background color.
            backgroundColor = greenColor,

            // on below line we are specifying content color.
            contentColor = Color.White,

            // on below line we are specifying
            // the indicator for the tab
            indicator = { tabPositions ->
                // on below line we are specifying the styling
                // for tab indicator by specifying height
                // and color for the tab indicator.
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                    height = 2.dp,
                    color = Color.White
                )
            }
        ) {
            // on below line we are specifying icon
            // and text for the individual tab item
            list.forEachIndexed { index, _ ->
                // on below line we are creating a tab.
                Tab(
                    // on below line we are specifying icon
                    // for each tab item and we are calling
                    // image from the list which we have created.
                    icon = {
                        Icon(imageVector = list[index].second, contentDescription = null)
                    },
                    // on below line we are specifying the text for
                    // the each tab item and we are calling data
                    // from the list which we have created.
                    text = {
                        Text(
                            list[index].first,
                            // on below line we are specifying the text color
                            // for the text in that tab
                            color = if (pagerState.currentPage == index) Color.White else Color.LightGray
                        )
                    },
                    // on below line we are specifying
                    // the tab which is selected.
                    selected = pagerState.currentPage == index,
                    // on below line we are specifying the
                    // on click for the tab which is selected.
                    onClick = {
                        // on below line we are specifying the scope.
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }
    }

    // on below line we are creating a tab content method
// in which we will be displaying the individual page of our tab .
    @ExperimentalPagerApi
    @Composable
    fun TabsContent(pagerState: PagerState) {
        // on below line we are creating
        // horizontal pager for our tab layout.
        HorizontalPager(
            count = 3,
            state = pagerState,
        ) {
            // on below line we are specifying
            // the different pages.
                page ->
            when (page) {
                // on below line we are calling tab content screen
                // and specifying data as Home Screen.
                0 -> TabContentScreen(data = "Welcome to Home Screen")
                // on below line we are calling tab content screen
                // and specifying data as Shopping Screen.
                1 -> TabContentScreen(data = "Welcome to Shopping Screen")
                // on below line we are calling tab content screen
                // and specifying data as Settings Screen.
                2 -> TabContentScreen(data = "Welcome to Settings Screen")
            }
        }
    }

    // on below line we are creating a Tab Content
// Screen for displaying a simple text message.
    @Composable
    fun TabContentScreen(data: String) {
        // on below line we are creating a column
        Column(
            // in this column we are specifying modifier
            // and aligning it center of the screen on below lines.
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // in this column we are specifying the text
            Text(
                // on below line we are specifying the text message
                text = data,

                // on below line we are specifying the text style.
                style = MaterialTheme.typography.h5,

                // on below line we are specifying the text color
                color = greenColor,

                // on below line we are specifying the font weight
                fontWeight = FontWeight.Bold,

                //on below line we are specifying the text alignment.
                textAlign = TextAlign.Center
            )
        }
    }
}

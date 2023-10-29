package com.example.project

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.project.ui.theme.ProjectTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController();

            ProjectTheme {
                val items = listOf(
                    BottomNavigationItem(
                        title = "Home",
                        selectedIcon = painterResource(id =R.drawable.s_anlytics ),
                        unSelectedIcon = painterResource(id =R.drawable.un_anlytics ),
                        hasNews = false,
                    ),
                    BottomNavigationItem(
                        title = "History",
                        selectedIcon = painterResource(id =R.drawable.s_home ),
                        unSelectedIcon =painterResource(id =R.drawable.un_home ),
                        hasNews = false,
                        badgeCount =4
                    ),
                    BottomNavigationItem(
                        title = "Home",
                        selectedIcon = painterResource(id =R.drawable.plus ) ,
                        unSelectedIcon =painterResource(id =R.drawable.plus ),
                        hasNews = false,
                    ),
                    BottomNavigationItem(
                        title = "Cards",
                        selectedIcon =  painterResource(id =R.drawable.s_cards ),
                        unSelectedIcon = painterResource(id =R.drawable.un_cards ),
                        hasNews = false,
                    ),
                    BottomNavigationItem(
                        title = "Settings",
                        selectedIcon = painterResource(id =R.drawable.s_settings ),
                        unSelectedIcon = painterResource(id =R.drawable.un_settings ),
                        hasNews = false,
                    )
                )
                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold (
                        bottomBar = {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentRoute = navBackStackEntry?.destination?.route


                            if (currentRoute != Screens.Login.route) {
                                NavigationBar (
                                    containerColor = Color.White
                                ) {

                                    items.forEachIndexed { index, item ->
                                        NavigationBarItem(
                                            selected = selectedItemIndex == index,
                                            onClick = {
                                                selectedItemIndex = index
                                                navController.navigate(item.title)
                                            },
                                            label = { Text(text = item.title) },

                                            icon = {
                                                BadgedBox(
                                                    badge = {
                                                        if (item.badgeCount != null) {
                                                            Badge {
                                                                Text(text = item.badgeCount.toString())
                                                            }
                                                        } else if (item.hasNews) {
                                                            Badge()
                                                        }

                                                    }
                                                ) {

                                                    Icon(
                                                        painter = if (index == selectedItemIndex) {
                                                            item.selectedIcon
                                                        } else item.unSelectedIcon,
                                                        contentDescription = item.title
                                                    )


                                                }
                                            }
                                        )
                                    }
                                }
                            }
                        }

                    )
                    {
                        NavHost(navController = navController, startDestination = Screens.Home.route) {

                            composable(Screens.Home.route) { HomeScreeen() }
                            composable(Screens.Cards.route) { Cards() }
                            composable(Screens.Login.route) { LoginScreen() }

                        }
//
                        }
                    }
                }
            }
        }
    }




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjectTheme {
        HomeScreen()
    }
}
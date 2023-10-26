@file:OptIn(ExperimentalFoundationApi::class)

package com.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.ui.theme.ProjectTheme
import kotlinx.coroutines.delay
import java.lang.Thread.yield

class CardsScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Cards()
                }
            }
        }
    }
}

@Composable
fun Cards(){

    Box {
        Column( modifier = Modifier
//            .height(70.dp)
            .background(Color(0xFF211064))


            .fillMaxHeight(0.1f)
            .fillMaxSize()
        )
        {
            Image(
                painter = painterResource(R.drawable.image), contentDescription = null)

        }
        Column (
            modifier = Modifier
//                .background(Color(0xFF787878), shape = RoundedCornerShape(15.dp))
//                .padding(24.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 40.dp)
                .clip(shape = RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp))


        ) {
            Column (
                modifier = Modifier
                    .background(Color(0xFFF8F9F9))
                    .fillMaxSize()

            ){
                Column (modifier = Modifier.padding(24.dp)){
                        Text(text = "Your Cards", fontSize = 35.sp, fontWeight = FontWeight.Bold, color = Color(0xFF211064))
                        Text(text = "2 physical cards 1 virtual", fontSize = 16.sp , fontWeight = FontWeight.Light , color = Color.Gray)
                }
                Row (modifier = Modifier.padding(horizontal = 10.dp)) {
                        TextButton(text = "Physical Card")
                    TextButton(text = "Virtual Card")

                }
              Column (modifier = Modifier.padding(24.dp)) {
                  Image (painter = painterResource(id = R.drawable.card), contentDescription = null)
              }

                Column (
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.padding(24.dp)
                ) {
                    Text(text = "Card Settings",fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color(0xFF211064))
                    CardSetting()
                    CardSetting()
                    CardSetting()
                }


            }
        }


    }

}

@Composable
fun CardSetting(){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(5.dp)
            )
            .background(Color.White)
            .padding(vertical = 15.dp, horizontal = 20.dp)
    ){

        Row (
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically

        ){

            Box(modifier = Modifier.wrapContentSize()) {
                // Create another box that covers the icon
                Box(
                    modifier = Modifier
                        // Match the size of the icon
                        .size(46.dp)
                        // Clip the box to a circle shape
                        .clip(RoundedCornerShape(10.dp))

                        // Set the background color to white
                        .background(Color(0xFFECECEC))
                )
                // Create an icon from a vector drawable resource
                Icon(
                    Icons.Filled.ShoppingCart,
                    contentDescription = "icon",
                    // Set the tint color of the icon
                    tint = Color.Black,
                    // Set the size of the icon
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.Center)
                )
            }
            Column {
                Text(text = "Groceries", fontSize = 20.sp, fontWeight = FontWeight.Medium)
            }
        }

        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = { checked = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                uncheckedThumbColor = Color.White,
                checkedTrackColor = Color( 0xFF211064),
                uncheckedTrackColor = Color(0xFF77869E)
            )
        )
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    ProjectTheme {
        Cards()
    }
}
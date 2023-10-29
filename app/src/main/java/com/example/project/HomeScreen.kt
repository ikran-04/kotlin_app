package com.example.project

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.ui.theme.ProjectTheme

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    HomeScreeen()
                }
            }
        }
    }
}
@Composable
fun HomeScreeen(modifier: Modifier = Modifier){
    val incomeImg = painterResource(id = R.drawable.income)
    val expensesImg = painterResource(id = R.drawable.expenses)

    val scrollState = rememberScrollState ()


    val Green = Color(0xFF0EB400)
    val Orange = Color(0xFFFF5C00)
    Column (
    )
    {

        Column (

            modifier = Modifier
                .background(Color(0xFF280D75))
                .padding(24.dp)
                .fillMaxWidth()
        )
        {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            )
            {
                Column {
                    Text(text = "$25,390.50", color = Color.White, fontSize = 30.sp, fontWeight = FontWeight(700))
                    Text(text = "Available Balance", color = Color.White)
                }
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Icon(
                        Icons.Filled.Notifications,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                    Image(

                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,


                        modifier = Modifier
                            .clip(CircleShape)
                            .size(40.dp)
                            .border(
                                BorderStroke(4.dp, Color.White),
                                CircleShape
                            )
//                    .padding(horizontal = 10.dp)

                    )

                }

            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            ){

                IconBox("Send" , icon = painterResource(id = R.drawable.wallet))
                IconBox("Request" , icon = painterResource(id = R.drawable.money_hand))
                IconBox("Loan", icon = painterResource(id = R.drawable.money_bag))
                IconBox("Topup", icon = painterResource(id = R.drawable.loan))

            }



        }
        Column(
            modifier = Modifier
                .background(Color(0xFFF8F9F9), shape = RoundedCornerShape(15.dp))
                .padding(vertical = 34.dp, horizontal = 24.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(shape = RoundedCornerShape(20.dp))

        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,

                modifier = Modifier.fillMaxWidth()
            ){
                Text(text = "Recent Transactions", fontSize = 24.sp, fontWeight = FontWeight.Medium)
                Text(text = "See All")
            }
            Row (
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                TextButton("All")
                IconText("Income" , icon =incomeImg)
                IconText("Expenses",icon = expensesImg)
            }

            //today
            Column {
                Text(
                    text = "Today" ,
                    fontSize = 18.sp, color = Color(0xFFD8D8D8),modifier= Modifier.padding(vertical = 10.dp))
                Column (
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ){
                    Transaction(Orange , icon = painterResource(id = R.drawable.cart))
                    Transaction(Orange , icon = painterResource(id = R.drawable.ubber))
                }
            }
            //Yesterday
            Column {
                Text(
                    text = "Yesterday" ,
                    fontSize = 18.sp, color = Color(0xFFD8D8D8),modifier= Modifier.padding(vertical = 10.dp))
                Column (
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                    .verticalScroll(scrollState)

                ){
                    Transaction(Green , icon = painterResource(id = R.drawable.ubber))
                    Transaction(Green ,icon = painterResource(id = R.drawable.cart_greem))
                    Transaction(Green ,icon = painterResource(id = R.drawable.cart_greem))
                    Transaction(Green ,icon = painterResource(id = R.drawable.cart_greem))
                }
            }
        }

    }


}

@Composable
fun Transaction(clr: Color , icon: Painter){
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
                    painter = icon,
                    contentDescription = "icon",
                    // Set the tint color of the icon
                    tint = Color(0xFF7158B8),
                    // Set the size of the icon
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.Center)
                )
            }
            Column {
                Text(text = "Groceries", fontSize = 20.sp, fontWeight = FontWeight.Medium)
                Text(text = "Eatly DownTown", fontSize = 12.sp, color = Color.Gray)
            }
        }

        Column (
            horizontalAlignment = Alignment.End
        )  {
            Text(text = "-$40.78", fontSize = 20.sp, fontWeight = FontWeight.Medium , color = clr)
            Text(text = "Feb1" , textAlign = TextAlign.Left,fontSize = 12.sp, color = Color.Gray)
        }
    }
}

@Composable
fun IconBox(lable:String="", icon: Painter){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
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
                painter = icon,
                contentDescription = "icon",
                // Set the tint color of the icon
                tint = Color(0xFF7158B8),
                // Set the size of the icon
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.Center)
            )
        }
        Text(
            text = lable,
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.White,
            ),
            textAlign = TextAlign.Center,
            // Align the text to the bottom center of the box
            modifier = Modifier.padding(top = 8.dp)
        )
    }


}

@Composable
fun TextButton(text:String) {

    // Create a box that wraps the content size
    Box(modifier = Modifier
        .wrapContentSize()
        .padding(vertical = 10.dp, horizontal = 10.dp)
        .clip(RoundedCornerShape(20.dp))) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 15.sp,
                color = Color.Black,
            ),
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 20.dp, vertical = 6.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(30.dp))
                .padding(10.dp)
        )
    }
}

@Composable
fun IconText(text:String , icon: Painter) {
    // Create a row that wraps the content size
    Box (modifier = Modifier
        .wrapContentSize()
        .clip(
            RoundedCornerShape(20.dp)
        )){
        Row(
            verticalAlignment = Alignment.CenterVertically,

            modifier = Modifier
                .wrapContentSize()
                .background(Color.White)
                .padding(vertical = 6.dp, horizontal = 15.dp)
        ) {
            Image(
                painter = icon,
                contentDescription = "icon",
                // Set the size of the icon
                modifier = Modifier.size(20.dp)
            )
            // Add some horizontal space between the icon and the text
            Spacer(modifier = Modifier.width(8.dp))
            // Create a text with some content and style
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Black,
                ),
                // Align the text to the center vertically
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    ProjectTheme {
        HomeScreeen()
    }
}
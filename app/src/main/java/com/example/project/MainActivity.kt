package com.example.project

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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
import com.example.project.ui.theme.ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    val mContext = LocalContext.current

    // Create a column that fills the maximum width of the screen
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Create a text with the title of the screen
        Text(
            text = "Login",
            style = TextStyle(
                fontSize = 32.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            ),
            // Align the text to the center horizontally
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        // Add some vertical space between the title and the label
        Spacer(modifier = Modifier.height(16.dp))
        // Create a text with the label of the username field
        Text(
            text = "Username",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal
            ),
            // Add some horizontal padding to the text
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        // Add some vertical space between the label and the field
        Spacer(modifier = Modifier.height(8.dp))
        // Create a text field for the username input
        TextField(
            value = "", // You can use a state variable to store and update the value of the field
            onValueChange = {}, // You can use a lambda function to handle the value change event
            placeholder = { Text("Enter your username") }, // You can use a placeholder text to indicate what to enter
            singleLine = true, // You can set the field to accept only one line of input
            modifier = Modifier
                // Fill the maximum width of the column
                .fillMaxWidth()
                // Add some horizontal padding to the field
                .padding(horizontal = 16.dp)
        )
        // Add some vertical space between the fields
        Spacer(modifier = Modifier.height(16.dp))
        // Create a text with the label of the password field
        Text(
            text = "Password",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal
            ),
            // Add some horizontal padding to the text
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        // Add some vertical space between the label and the field
        Spacer(modifier = Modifier.height(8.dp))
        // Create a text field for the password input
        TextField(
            value = "", // You can use a state variable to store and update the value of the field
            onValueChange = {}, // You can use a lambda function to handle the value change event
            placeholder = { Text("Enter your password") }, // You can use a placeholder text to indicate what to enter
            singleLine = true, // You can set the field to accept only one line of input
            visualTransformation = PasswordVisualTransformation(), // You can use a visual transformation to mask the password input
            modifier = Modifier
                // Fill the maximum width of the column
                .fillMaxWidth()
                // Add some horizontal padding to the field
                .padding(horizontal = 16.dp)
        )
        // Add some vertical space between the field and the button
        Spacer(modifier = Modifier.height(16.dp))
        // Create a button for the login action
        Button(
            onClick = {
                mContext.startActivity(Intent(mContext, HomeScreen::class.java))
            },

            colors = ButtonDefaults.buttonColors( Color(0xFF280D75)),
            shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                .align(Alignment.CenterHorizontally)

        ) {
            // Create a text with the label of the button
            Text(
                text = "Login",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )
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
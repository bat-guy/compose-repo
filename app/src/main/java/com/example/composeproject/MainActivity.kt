package com.example.composeproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeproject.mvvm.CategoryScreen
import com.example.composeproject.screens.QuoteDetail
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CategoryScreen()
        }
    }


    @Composable
    fun samPleFun(text: String) {
        Box(
            contentAlignment = Alignment.Center
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = text,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Sample Image",
                colorFilter = ColorFilter.tint(Color.Blue),
                contentScale = ContentScale.Inside
            )
            TextField(value = "This is a textField",
                onValueChange = {},
                label = { Text("Enter a message") },
                placeholder = { })
            Button(
                onClick = {}, colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White, backgroundColor = Color.Gray
                )
            ) {
                Text(text = "Click")
            }
        }
    }

    @Composable
    fun textFieldCompose() {
        val state = remember { mutableStateOf("") }
        TextField(value = state.value, onValueChange = {
            state.value = it
            Log.e("**TextField**", it)
        }, label = { Text("Enter a message") }, placeholder = { })
    }

    @Composable
    fun listViewItem(imgId: Int, name: String, occupation: String, modifier: Modifier) {
        Row(
            modifier.padding(top = 8.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imgId),
                contentDescription = "Profile Picture"
            )
            Column() {
                Text(text = name, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                Text(text = occupation, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
            }
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun PreviewFunction() {
        Column() {
        }
    }
}

package com.example.democompose.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import com.example.democompose.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    @Inject
    lateinit var moduleChar : String
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate===== ${moduleChar}")

        setContent {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Image(
                    painter = painterResource(id = R.drawable.happy_meal),
                    contentDescription = "Rishi",
                    modifier = Modifier.height(300.dp),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.padding(top = 10.dp, start = 10.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(text = "Happy Meal", style = TextStyle(
                            fontSize = 26.sp,
                            color = Color.Black
                        ))
                        Text(
                            text = "$10:00",
                            style = TextStyle(
                            fontSize = 26.sp,
                            color = Color.Black,
                        ), modifier = Modifier.align(Alignment.CenterVertically))
                    }
                    Spacer(modifier = Modifier.padding(top = 4.dp))
                    Text(text = "800 calories",style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Gray
                    ))
                    Button(onClick = {
                                     
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text(text = "Order Now")
                    }
                }
            }
        }
    }
}

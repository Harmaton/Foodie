package com.njagi.foodie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.njagi.foodie.presentation.HomeScreen
import com.njagi.foodie.ui.theme.FoodieTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodieTheme {

                    HomeScreen()

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodieTheme {
       HomeScreen()
    }
}
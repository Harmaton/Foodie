package com.njagi.foodie.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.njagi.foodie.ui.theme.FoodieTheme

@Composable
fun HeaderText(text: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 4.dp, end = 10.dp, bottom = 10.dp)
            .height(50.dp)
            ,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {

             Text(
                  text = text,
                  fontSize = 20.sp,
                  color = Color.Red,
                  fontWeight = FontWeight.Black ,
                  fontFamily = FontFamily.Monospace,
                  modifier = Modifier.padding(start = 10.dp),
                   style = TextStyle(fontStyle = FontStyle.Normal)

                  )
          }



    }


@Preview(showBackground = true)
@Composable
fun headerPreview(){

    FoodieTheme() {
        HeaderText(text = "Vegeterian")
        
    }
}
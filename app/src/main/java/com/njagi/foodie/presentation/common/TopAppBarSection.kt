package com.njagi.foodie.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.njagi.foodie.R
import com.njagi.foodie.ui.theme.FoodieTheme
import org.w3c.dom.Text

@Composable
fun TopAppSection(
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_style_24),
                    contentDescription = "mode switch",
                )
            }

            TextFoodie()

            IconButton(
                onClick = { /*TODO*/ },

                ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_next_plan_24),
                    contentDescription = ""
                )
            }

        }


    }



@Composable
fun TextFoodie() {
    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Top) {


        Text(
            text = " Hey Foodie!", color = Color.Red,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Italic,
            fontSize = 28.sp
        )
        //  Icon(painter = painterResource(id = drawable), contentDescription = "")
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    FoodieTheme() {
        TopAppSection()
    }
}
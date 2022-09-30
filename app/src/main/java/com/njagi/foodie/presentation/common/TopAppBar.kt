package com.njagi.foodie.presentation.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material.icons.sharp.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.njagi.foodie.ui.theme.FoodieTheme

@Composable
fun TopAppSection(
    // TODO -> IMPLEMENT CHANGE OF SIZE WITH SCROLL
) {
    TopAppBar(
        backgroundColor = Color.Transparent,
        contentColor = Color.Red,
        elevation = 10.dp,
        contentPadding = PaddingValues(10.dp),
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
            , verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Sharp.Share,
                    contentDescription = "Search Meal",
                    modifier = Modifier.padding(end = 20.dp))

            }

            Text(text = "Foodie!", color = Color.Red,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Italic,
                fontSize = 28.sp
            )

            IconButton(onClick = { /*TODO*/ },

                ) {
                Icon(imageVector = Icons.Sharp.Search,
                    contentDescription = "Search Meal",
                    modifier = Modifier.padding(end = 20.dp))
            }


        }
    }
}

@Composable
fun TextFoodie() {
    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Top) {

       // val drawable = LocalContext.current.getDrawable()
        Text(text = "Foodie!", color = Color.Red,
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
    FoodieTheme(){
        TopAppSection()
    }
}
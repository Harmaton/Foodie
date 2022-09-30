package com.njagi.foodie.presentation.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.njagi.foodie.ui.theme.FoodieTheme
import com.njagi.foodie.ui.theme.Purple700

@Composable
fun TopAppSection(
    // TODO -> IMPLEMENT CHANGE OF SIZE WITH SCROLL
) {
    TopAppBar(
        backgroundColor = Purple700,
        contentColor = Color.White,
        elevation = 10.dp,
        contentPadding = PaddingValues(10.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
            , verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Foodie!", color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Italic
            )

            Icon(imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "Search Meal",
                modifier = Modifier.padding(end = 20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    FoodieTheme(){
        TopAppSection()
    }
}
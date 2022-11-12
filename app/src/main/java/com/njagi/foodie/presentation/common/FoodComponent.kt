package com.njagi.foodie.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.njagi.foodie.R
import com.njagi.foodie.ui.theme.FoodieTheme


@Composable
fun FoodComponent(){
    Box(modifier = Modifier
        .height(80.dp)
        .width(70.dp)) {
        Column( modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp),
                shape = RoundedCornerShape( bottomStart = 8.dp)
            ){
                Image(painter = painterResource(id = R.mipmap.randoom_2_foreground),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                    )
            }

            Spacer(modifier = Modifier.height(2.dp))

            Text(text = "Beef pepperoni",
                fontSize = 8.sp,
                fontStyle = FontStyle.Italic ,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp) ,
                )
            Spacer(modifier = Modifier.height(2.dp))

            Row(modifier = Modifier.fillMaxWidth().padding(3.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Icon(painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                    contentDescription = null )
                Icon(painter = painterResource(id = R.drawable.baseline_thumb_up_24),
                    contentDescription = null )
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun FoodComponentPreview(){
    FoodieTheme {
        FoodComponent()
    }
}
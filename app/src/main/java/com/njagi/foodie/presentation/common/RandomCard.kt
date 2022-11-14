package com.njagi.foodie.presentation.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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
fun RandomCard(
//    painter: Painter,
//    text: String
){

    var expanded by remember {
        mutableStateOf(false)
    }

    Card( modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .height(200.dp)
        .clickable {

        } ,
        elevation = 0.dp,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(0.dp, Color.Black)

        ){
//        Image(painter = rememberAsyncImagePainter(
//            ImageRequest.Builder(LocalContext.current)
//                .data(data = R.mipmap.random)
//                .apply (block = fun ImageRequest.Builder.() {
//                    crossfade(true)
//                }).build()
//
//        ), contentDescription = null,
//            modifier = Modifier
//                .fillMaxSize(),
//            contentScale = ContentScale.Inside)
        Box(modifier = Modifier.height(140.dp),
        ){
            Image(painter = painterResource(id = R.mipmap.randoom_3_foreground),
                contentDescription = null,
                modifier = Modifier.fillMaxSize() ,
                contentScale = ContentScale.Crop
            )
        }

        Row(  modifier = Modifier
            .padding(start = 10.dp, end = 2.dp)
            .fillMaxWidth(),
           horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
            ) {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Wanna try out something new ? ",
                    modifier = Modifier.padding(10.dp),
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic,
                    color = Color.Black,
                    fontSize = 18.sp
                )



                AnimatedVisibility(visible = true
                    ) {
                    OutlinedButton(onClick = { /*TODO*/ },
                        border = BorderStroke(1.dp, Color.LightGray),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .padding(end = 12.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Red,
                            backgroundColor = Color.Red,
                        ) ) {
                        Text(text = "Random Food",
                            color = Color.White,
                            fontSize = 8.sp,
                        )
                        Icon(painter = painterResource(id = R.drawable.baseline_play_arrow_24),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(15.dp)
                            )
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun RandomCardPreview(){
    FoodieTheme {
        RandomCard()
    }
}
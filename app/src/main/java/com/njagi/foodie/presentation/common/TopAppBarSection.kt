package com.njagi.foodie.presentation.common


import android.widget.ImageButton
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.njagi.foodie.R
import com.njagi.foodie.ui.theme.FoodieTheme

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
            TextFoodie()

        val infiniteTransition = rememberInfiniteTransition()
        val rotateAnimation = infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 240f,
            animationSpec = infiniteRepeatable(tween(1000, easing = LinearEasing))
        )

         val brush = listOf(
             Color.Red,
             Color.Black,
             Color.White
         )
            IconButton(
                onClick = { /*TODO*/ },

                ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_message_24),
                    contentDescription = null,
                    modifier = Modifier.drawBehind {
                        rotate(rotateAnimation.value){
                            drawCircle(brush = Brush.horizontalGradient(brush), style = Stroke(1f))
                        }


                    }
                )
            }

        }


    }




@Composable
fun TextFoodie() {
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top) {

        val gradient = listOf(
            Color.Black,
            Color.Red,
            Color.DarkGray
        )

        Text(
            text = " Hey Foodie!", color = Color.Black,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace,

            fontSize = 28.sp,

        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    FoodieTheme {
        TopAppSection()
    }
}
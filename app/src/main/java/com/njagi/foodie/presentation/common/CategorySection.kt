package com.njagi.foodie.presentation.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.njagi.foodie.feature_category.Category

@Composable
fun CategorySection(categories: List<Category>) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {

        Text(
            text = "Category", color = Color.Red,
            letterSpacing = 5.sp,
            fontSize = 20.sp
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(30.dp)
        ) {
            items(categories.size) {
                CategoryItem(categoryX = categories[it])
            }
        }
    }
}


@Composable
fun CategoryItem(categoryX: Category) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp),
        border = BorderStroke(width = 1.dp, color = Color.Red),
        backgroundColor = Color.Transparent,
        elevation = 10.dp
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            Image(painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = categoryX.categories.strCategoryThumb)
                    .apply (block = fun ImageRequest.Builder.() {
                        placeholder(coil.base.R.drawable.notification_template_icon_bg)
                        crossfade(true)
                    }).build()

            ), contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                contentScale = ContentScale.FillWidth)

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = categoryX.categories.strCategory)

            Text(text = categoryX.categories.strCategoryDescription, maxLines = 2)
        }


    }

}

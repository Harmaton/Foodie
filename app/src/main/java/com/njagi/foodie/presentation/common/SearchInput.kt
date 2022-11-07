package com.njagi.foodie.presentation.common

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SearchInputBox() {

    OutlinedTextField(value = "",
        onValueChange = {},
        placeholder = { Text(text = "Search for Recipes e.t.c ...", modifier = Modifier.fillMaxWidth() ) },
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = com.njagi.foodie.R.drawable.baseline_filter_list_24),
                    contentDescription = null
                )
            }

        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 10.dp)
            .background(androidx.compose.ui.graphics.Color.White), shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = androidx.compose.ui.graphics.Color.Red,
            unfocusedBorderColor = androidx.compose.ui.graphics.Color.LightGray,
            cursorColor = androidx.compose.ui.graphics.Color.Gray,
            trailingIconColor = androidx.compose.ui.graphics.Color.Red
        ))
}

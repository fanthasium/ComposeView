package com.example.cmposetest.ui.view.main

import android.widget.SearchView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cmposetest.R

@Composable
fun SearchView() {
    var text by remember { mutableStateOf("") }
    
    Surface(
        modifier = Modifier.width(450.dp),
        shape = RoundedCornerShape(corner = CornerSize(15.dp))
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            textStyle = TextStyle(fontSize = 17.sp),
            label = { Text("Search replies", modifier = Modifier.offset(x = 20.dp)) },
            singleLine = true,
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_person_search_24),
                    contentDescription = null,
                    modifier = Modifier
                        .width(30.dp)
                        .height(40.dp)
                        .offset(10.dp)
                )
            },

            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}
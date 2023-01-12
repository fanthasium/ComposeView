package com.example.cmposetest.ui.view.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SubIconImg(subImg : List<Int>){
    Column() {
        subImg.forEach() { subImg ->

            Spacer(modifier = Modifier.height(40.dp))
            Image(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
                painter = painterResource(id = subImg),
                contentDescription = "Tap",
            )
        }
    }
}

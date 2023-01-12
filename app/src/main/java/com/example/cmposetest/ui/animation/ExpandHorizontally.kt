package com.example.cmposetest.ui.animation

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp


@Composable
fun Animation(visible: Boolean, composable : @Composable (() -> Unit)){

    AnimatedVisibility(
       visible = visible,
        modifier = Modifier.offset(x = 30.dp),
        enter = expandHorizontally(
        )+ fadeIn(),
        exit = shrinkHorizontally() + fadeOut()
    ){
        composable.invoke()
    }
}
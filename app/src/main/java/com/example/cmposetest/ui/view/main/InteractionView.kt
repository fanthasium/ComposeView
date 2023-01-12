package com.example.cmposetest.ui.view.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cmposetest.dataclass.Conversation
import com.example.cmposetest.ui.theme.Beige300
import com.example.cmposetest.R


@Composable
fun UserInfo(msg: Conversation,){
    Row(
        modifier = Modifier
            .width(730.dp)
            .height(120.dp)
            .background(
                color = Beige300,
                shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
            )
            .offset(x = 45.dp, y = 15.dp)
    ) {
        Column() {

            Text(
                text = msg.subTittle,
                fontSize = 40.sp,
                fontWeight = FontWeight.Thin,
            )

            Text(
                text = "3 Messages (request Modifier)",
                fontWeight = FontWeight.Light,
                fontSize = 15.sp
            )
        }
        Spacer(modifier = Modifier.width(350.dp))
        Row(modifier = Modifier.offset(y = 20.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_delete_24),
                contentDescription = "delete",
                modifier = Modifier
                    .width(45.dp)
                    .height(50.dp)
                    .align(Alignment.CenterVertically)
                    .clickable { }
            )
            /*   Spacer(modifier = Modifier.width(10.dp))
               Image(
                   painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_left_24),
                   contentDescription = "close",
                   modifier = Modifier
                       .width(55.dp)
                       .height(55.dp)
                       .align(Alignment.CenterVertically)
                       .clickable {

                       }
               )*/
        }

    }
}
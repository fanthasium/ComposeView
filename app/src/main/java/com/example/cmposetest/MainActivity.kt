package com.example.cmposetest


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cmposetest.dataclass.Conversation
import com.example.cmposetest.dataclass.SampleData
import com.example.cmposetest.ui.animation.Animation
import com.example.cmposetest.ui.view.main.SearchView
import com.example.cmposetest.ui.view.main.SubIconImg
import com.example.cmposetest.ui.view.main.UserInfo
import com.example.cmposetest.ui.theme.Beige200
import com.example.cmposetest.ui.theme.Beige300

val mainList = listOf(
    R.drawable.ic_baseline_format_list_bulleted_24,
    R.drawable.ic_baseline_edit_note_24
)

val subMainList = listOf(
    R.drawable.ic_baseline_forum_24,
    R.drawable.ic_baseline_list_alt_24,
    R.drawable.ic_baseline_chat_bubble_24,
    R.drawable.ic_baseline_videocam_24
)

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Beige200) {
                MessageList(SampleData.conversationSample)
            }
        }
    }
}


@Composable
fun MessageList(messages: List<Conversation>) {
    var openPag by remember {
        mutableStateOf(false)
    }

    var positionData by remember {
        mutableStateOf(Conversation("", "", "", "", ""))
    }


    Row() {
        MainIcon(mainList)

        Column(modifier = Modifier.offset(x = 80.dp, y = 20.dp)) {
            SearchView()
            LazyColumn {

                itemsIndexed(items = messages) { _, messages ->

                    Column(modifier = Modifier.clickable {
                        positionData = messages
                        openPag = openPag.not()
                    }) {
                        MessageRow(obj = messages)
                    }
                }
            }
        }

            Column(modifier = Modifier.offset(x = 70.dp, y = 15.dp)) {
                    Animation(openPag) {
                        InteractRow(msg = positionData, openPag)
                    }
            }

    }

}

@Composable
fun MessageRow(
    obj: Conversation,
    width: Dp = 450.dp,
    paddingDp: Dp = 20.dp,
    cornerDp: Dp = 10.dp,
    color: Color = Beige300,
    bool: Boolean = false
) {
    var touch by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .width(width)
            .padding(vertical = 5.dp)
            .background(color, shape = RoundedCornerShape(corner = CornerSize(cornerDp)))
    ) {

        Row(modifier = Modifier.padding(paddingDp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "user_icon",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(10.dp))

            Column() {
                Text(text = obj.name, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(1.dp))
                Text(text = obj.timer, fontSize = 15.sp, fontWeight = FontWeight.ExtraLight)
            }
        }

        Column() {
            if (bool) {
                Text(
                    text = obj.caller,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.offset(x = 20.dp)
                )
            } else {
                Text(
                    text = obj.subTittle,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.offset(x = 20.dp)
                )
            }


            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = obj.text,
                fontSize = 20.sp,
                maxLines = if (touch) Int.MAX_VALUE else 4,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .clickable { touch = !touch }
            )
        }
    }
}

@Composable
fun InteractRow(
    msg: Conversation,
    close: Boolean
) {
        Column(
            Modifier
                .padding(all = 5.dp)
                .width(720.dp)
                .background(color = Color.White, shape = RoundedCornerShape(CornerSize(25.dp)))
        ) {
            UserInfo(msg = msg)

            MessageRow(
                msg,
                width = 720.dp,
                paddingDp = 25.dp,
                cornerDp = 25.dp,
                color = Color.White,
                bool = close
            )
        }


}

@Composable
fun MainIcon(imgList: List<Int>) {

    var visible by remember { mutableStateOf(false) }

    Column() {

        imgList.forEach { imgList ->
            Spacer(modifier = Modifier.height(40.dp))
            /*
              count++
             if (count == 3) {
                    Spacer(modifier = Modifier.height(70.dp))
                }*/
            Image(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .offset(x = 30.dp)
                    .clickable {
                        when (imgList) {
                            R.drawable.ic_baseline_format_list_bulleted_24 -> visible =
                                visible.not()
                        }
                    },
                painter = painterResource(id = imgList),
                contentDescription = "Tap",
            )
        }
        Spacer(modifier = Modifier.height(70.dp))
        SubIcon(visible)
    }
}

@Composable
fun SubIcon(visible: Boolean) {
    Animation(visible = visible) {
        SubIconImg(subMainList)
    }
}


@Preview(showBackground = true, widthDp = 2000, heightDp = 1200)
@Composable
fun ButtonPreview() {
    MessageList(SampleData.conversationSample)
}




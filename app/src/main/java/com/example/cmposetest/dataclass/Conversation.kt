package com.example.cmposetest.dataclass

import android.text.Html

data class Conversation(
    val name: String,
    val timer: String,
    val subTittle: String,
    val text: String,
    val caller : String
)

object SampleData {
    val conversationSample = listOf(
        Conversation(
            "Andrew",
            "10 min ago",
            "Dinner Club",
                    "I think it's time for us to finally try that new\n" +
                    "noodle shop downtown that doesn't use me\n" +
                    "if u want come to my party plz !!",
            "To me,Ziad,and Lily"
        ),
        Conversation(
            "翼桥",
            "12 min ago",
            "市中心",
            "饭局\n" +
                    "我想我们终于该尝试那个新东西了\n" +
                    "市中心一家不用我的面条店.\n" +
                    "如果你想来我的派对请！！\n" +
                    "市中心一家不用我的面条店 如果你想来我的派对请",
         "对我 来说,张敏镐 和 东珠\n"
        ),
        Conversation(
            "Lily MacDonald",
            "2 hours ago",
            "mumble",
            "This food show is made for you\n" +
                    "Ping - you'd love this new food show i started watching.\n" +
                    "It's produced by a Thai drummer\n" +
                    "I don't know what im say it just mumble mumble ",
            "To me,Tomas,and Julia"
        )
    )
}

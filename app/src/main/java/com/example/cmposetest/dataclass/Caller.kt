package com.example.cmposetest.dataclass

data class Caller(val caller: String)

object Reply{
    val caller = listOf(Caller(
        "To me,Ziad,and Lily"
    ),
    Caller("对我 来说,张敏镐 和 东珠\n"),
        Caller("To me,Tomas,and Julia")
    )
}

package com.yoloyoj.hse_homework1

fun naming(years: Float): String {
    if (years < 0)
        return "всё сложно"

    if (years < 1)
        return "<1 года"

    val y = years.toInt()
    if ((y % 10 == 1) and (y != 11))
        return "$y год"
    if (y / 10 != 1)
        when (y % 10) {
            2, 3, 4 -> return "$y года"
        }
    return "$y лет"
}

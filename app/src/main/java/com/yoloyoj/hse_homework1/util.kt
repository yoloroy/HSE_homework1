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

// List<A>, List<B> -> List<Pair<A, B>>
fun <A, B> List<A>.product(other: List<B>)
        = mapIndexed { index, a -> a to other[index] }

fun <T> Iterable<T>.filterBy(filter: List<Boolean>): Iterable<T>
        = filterIndexed { index, _ -> filter[index] }

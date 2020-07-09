package com.yoloyoj.hse_homework1.filter_recycler_adapter.models

import com.yoloyoj.hse_homework1.naming

class FilterItem(
    var exp: Float,
    var value: Boolean = true
) {
    val text get() = naming(exp)
}

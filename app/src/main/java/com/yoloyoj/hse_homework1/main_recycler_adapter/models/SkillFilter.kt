package com.yoloyoj.hse_homework1.main_recycler_adapter.models

// It stores same objects like adapter because it's holder implement adapter's filter control
class SkillFilter(
    var items: List<SkillItem>,
    val filter: List<Boolean>
)

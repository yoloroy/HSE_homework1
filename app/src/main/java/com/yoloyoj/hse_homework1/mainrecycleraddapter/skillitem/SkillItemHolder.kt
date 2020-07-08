package com.yoloyoj.hse_homework1.mainrecycleraddapter.skillitem

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.skill_card_item.view.*

class SkillItemHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var skillItem: SkillItem

    fun bind(skillItem: SkillItem) {
        view.apply {
            skill_name.text = skillItem.name
            experience.text =
                naming(
                    skillItem.experience
                )
        }

        this.skillItem = skillItem
    }
}

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

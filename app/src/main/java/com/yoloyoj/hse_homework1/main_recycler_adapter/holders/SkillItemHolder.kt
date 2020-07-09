package com.yoloyoj.hse_homework1.main_recycler_adapter.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.SkillItem
import com.yoloyoj.hse_homework1.naming
import kotlinx.android.synthetic.main.skill_card_item.view.*

class SkillItemHolder(val view: View) : RecyclerView.ViewHolder(view) {
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

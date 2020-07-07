package com.yoloyoj.hse_homework1.skillitem

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yoloyoj.hse_homework1.projectidea.ProjectIdea
import kotlinx.android.synthetic.main.project_info.view.*
import kotlinx.android.synthetic.main.skill_card_item.view.*

class SkillItemHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var skillItem: SkillItem

    fun bind(skillItem: SkillItem) {
        view.skill_name.text = skillItem.name
        view.experience.text = skillItem.experience.toString()

        this.skillItem = skillItem
    }
}

package com.yoloyoj.hse_homework1.mainrecycleraddapter.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yoloyoj.hse_homework1.mainrecycleraddapter.models.SkillFilter
import kotlinx.android.synthetic.main.header_skills.view.*

class SkillFilterHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var skillFilter: SkillFilter

    fun bind(skillFilter: SkillFilter) {
        view.apply {
            filter_button.setOnClickListener {
                return@setOnClickListener // TODO
            }
        }

        this.skillFilter = skillFilter
    }
}

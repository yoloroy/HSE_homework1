package com.yoloyoj.hse_homework1.main_recycler_adapter.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.SkillFilter

class SkillFilterHolder(val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var skillFilter: SkillFilter

    fun bind(skillFilter: SkillFilter) {
        this.skillFilter = skillFilter
    }
}

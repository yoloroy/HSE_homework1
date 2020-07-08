package com.yoloyoj.hse_homework1.main_recycler_adapter.holders

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yoloyoj.hse_homework1.FilterActivity
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.SkillFilter
import kotlinx.android.synthetic.main.header_skills.view.*

class SkillFilterHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var skillFilter: SkillFilter

    fun bind(skillFilter: SkillFilter) {
        view.apply {
            filter_button.setOnClickListener {
                it.context.startActivity(Intent(it.context, FilterActivity::class.java))
            }
        }

        this.skillFilter = skillFilter
    }
}

package com.yoloyoj.hse_homework1.main_recycler_adapter.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yoloyoj.hse_homework1.MainActivity
import com.yoloyoj.hse_homework1.R
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.SkillFilter
import kotlinx.android.synthetic.main.header_skills.view.*

class SkillFilterHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private lateinit var skillFilter: SkillFilter

    fun bind(skillFilter: SkillFilter) {
        this.skillFilter = skillFilter

        if (skillFilter.filter.contains(false))
            view.filter_button.setImageResource(
                R.drawable.ic_filter_alt_black_checked_24dp
            )

        view.filter_button.setOnClickListener {
            (view.context as MainActivity).updateFiltering(
                skillFilter.items,
                skillFilter.filter
            )
        }
    }
}

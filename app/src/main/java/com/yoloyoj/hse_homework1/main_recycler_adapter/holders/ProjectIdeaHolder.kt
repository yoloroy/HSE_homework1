package com.yoloyoj.hse_homework1.main_recycler_adapter.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.ProjectIdea
import kotlinx.android.synthetic.main.project_info.view.*

class ProjectIdeaHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var projectIdea: ProjectIdea

    fun bind(projectIdea: ProjectIdea) {
        view.apply {
            project_idea.text = projectIdea.text
        }

        this.projectIdea = projectIdea
    }
}

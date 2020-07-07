package com.yoloyoj.hse_homework1.projectidea

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.project_info.view.*

class ProjectIdeaHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var projectIdea: ProjectIdea

    fun bind(projectIdea: ProjectIdea) {
        view.project_idea.text = projectIdea.text

        this.projectIdea = projectIdea
    }
}

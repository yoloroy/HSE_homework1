package com.yoloyoj.hse_homework1.mainrecycleraddapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.yoloyoj.hse_homework1.R
import com.yoloyoj.hse_homework1.mainrecycleraddapter.projectidea.ProjectIdea
import com.yoloyoj.hse_homework1.mainrecycleraddapter.projectidea.ProjectIdeaHolder
import com.yoloyoj.hse_homework1.mainrecycleraddapter.skillfilter.SkillFilter
import com.yoloyoj.hse_homework1.mainrecycleraddapter.skillfilter.SkillFilterHolder
import com.yoloyoj.hse_homework1.mainrecycleraddapter.skillitem.SkillItem
import com.yoloyoj.hse_homework1.mainrecycleraddapter.skillitem.SkillItemHolder
import com.yoloyoj.hse_homework1.mainrecycleraddapter.userinfo.UserInfo
import com.yoloyoj.hse_homework1.mainrecycleraddapter.userinfo.UserInfoHolder

class MainRecyclerAdapter(private var items: List<Any>) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemViewType(position: Int) =
        when (position) {
            0 -> 0 // user_info
            1 -> 1 // project_info
            2 -> 2 // header_skills
            else -> 3 // skill_card_item
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> UserInfoHolder(
                inflater.inflate(
                    R.layout.user_info,
                    parent,
                    false
                )
            )
            1 -> ProjectIdeaHolder(
                inflater.inflate(
                    R.layout.project_info,
                    parent,
                    false
                )
            )
            2 -> SkillFilterHolder(
                inflater.inflate(
                    R.layout.header_skills,
                    parent,
                    false
                )
            )
            3 -> SkillItemHolder(
                inflater.inflate(
                    R.layout.skill_card_item,
                    parent,
                    false
                )
            )
            else -> throw Exception("Wrong viewType")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            0 -> (holder as UserInfoHolder).bind(items[position] as UserInfo)
            1 -> (holder as ProjectIdeaHolder).bind(items[position] as ProjectIdea)
            2 -> (holder as SkillFilterHolder).bind(items[position] as SkillFilter)
            3 -> (holder as SkillItemHolder).bind(items[position] as SkillItem)
        }
    }

    override fun getItemCount() =
        items.count()
}
class EmptyViewHolder(itemView: View) : ViewHolder(itemView)

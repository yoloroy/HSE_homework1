package com.yoloyoj.hse_homework1.main_recycler_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.yoloyoj.hse_homework1.MainActivity
import com.yoloyoj.hse_homework1.R
import com.yoloyoj.hse_homework1.main_recycler_adapter.holders.ProjectIdeaHolder
import com.yoloyoj.hse_homework1.main_recycler_adapter.holders.SkillFilterHolder
import com.yoloyoj.hse_homework1.main_recycler_adapter.holders.SkillItemHolder
import com.yoloyoj.hse_homework1.main_recycler_adapter.holders.UserInfoHolder
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.ProjectIdea
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.SkillFilter
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.SkillItem
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.UserInfo
import kotlinx.android.synthetic.main.header_skills.view.*

const val USER_INFO = 0
const val PROJECT_INFO = 1
const val HEADER_SKILLS = 2
const val SKILL_ITEM = 3

class MainRecyclerAdapter(
    private var items: List<Any>,
    private val filter: List<Boolean>
) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemViewType(position: Int) =
        when (position) {
            0 -> USER_INFO
            1 -> PROJECT_INFO
            2 -> HEADER_SKILLS
            else -> SKILL_ITEM
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            USER_INFO -> UserInfoHolder(
                inflater.inflate(
                    R.layout.user_info,
                    parent,
                    false
                )
            )
            PROJECT_INFO -> ProjectIdeaHolder(
                inflater.inflate(
                    R.layout.project_info,
                    parent,
                    false
                )
            )
            HEADER_SKILLS -> SkillFilterHolder(
                inflater.inflate(
                    R.layout.header_skills,
                    parent,
                    false
                )
            )
            SKILL_ITEM -> SkillItemHolder(
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
        @Suppress("UNCHECKED_CAST")
        when (getItemViewType(position)) {
            USER_INFO ->
                (holder as UserInfoHolder).bind(items[position] as UserInfo)
            PROJECT_INFO ->
                (holder as ProjectIdeaHolder).bind(items[position] as ProjectIdea)
            HEADER_SKILLS ->
                (holder as SkillFilterHolder).bind(SkillFilter(
                    items.slice(3 until items.count()) as List<SkillItem>,
                    filter
                ))
            SKILL_ITEM ->
                (holder as SkillItemHolder).bind(items.available[position] as SkillItem)
        }
    }

    override fun getItemCount() =
        items.available.count()

    private val List<Any>.available
        get() = filterIndexed { index, _ ->
            (index < 3) or filter.run {
                if (this.isNotEmpty() and (index >= 3))
                    get(index - 3)
                else
                    true
            }
        }

}

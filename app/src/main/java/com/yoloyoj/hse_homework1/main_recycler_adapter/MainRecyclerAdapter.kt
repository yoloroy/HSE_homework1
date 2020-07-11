package com.yoloyoj.hse_homework1.main_recycler_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.yoloyoj.hse_homework1.R
import com.yoloyoj.hse_homework1.main_recycler_adapter.holders.*
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.ProjectIdea
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.SkillFilter
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.SkillItem
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.UserInfo

const val TYPE_USER_INFO = 0
const val TYPE_PROJECT_INFO = 1
const val TYPE_HEADER_SKILLS = 2
const val TYPE_SKILL_ITEM = 3

class MainRecyclerAdapter(
    private var items: List<Any>,
    private val filter: List<Boolean>
) : RecyclerView.Adapter<ViewHolder>() {
    @Suppress("UNCHECKED_CAST")
    val skillFilter: SkillFilter
        get() = SkillFilter(
            items.slice(3 until items.count()) as List<SkillItem>,
            filter
        )

    override fun getItemViewType(position: Int) =
        when (position) {
            0 -> TYPE_USER_INFO
            1 -> TYPE_PROJECT_INFO
            2 -> TYPE_HEADER_SKILLS
            else -> TYPE_SKILL_ITEM
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_USER_INFO -> UserInfoHolder(
                inflater.inflate(
                    R.layout.user_info,
                    parent,
                    false
                )
            )
            TYPE_PROJECT_INFO -> ProjectIdeaHolder(
                inflater.inflate(
                    R.layout.project_info,
                    parent,
                    false
                )
            )
            TYPE_HEADER_SKILLS -> SkillFilterHolder(
                inflater.inflate(
                    R.layout.header_skills,
                    parent,
                    false
                )
            )
            TYPE_SKILL_ITEM -> SkillItemHolder(
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

        holder as BindableHolder
        when (getItemViewType(position)) {

            TYPE_USER_INFO ->
                holder.bind(items[position] as UserInfo)

            TYPE_PROJECT_INFO ->
                holder.bind(items[position] as ProjectIdea)

            TYPE_HEADER_SKILLS ->
                holder.bind(skillFilter)

            TYPE_SKILL_ITEM ->
                holder.bind(items.available[position] as SkillItem)
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

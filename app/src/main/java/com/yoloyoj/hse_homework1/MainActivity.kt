package com.yoloyoj.hse_homework1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoloyoj.hse_homework1.main_recycler_adapter.MainRecyclerAdapter
import com.yoloyoj.hse_homework1.main_recycler_adapter.SpaceItemDecoration
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.ProjectIdea
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.SkillItem
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.UserInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val attrs = listOf(
        UserInfo(
            "Ларюшкин Сергей",
            "Выпускник",
            "https://github.com/yoloroy"
        ),
        ProjectIdea(
            "очень крутой проект с очень оригинальными идеями"
        ),
        Any() // initialization in the adapter {SkillFilter}
    )

    private var skills = listOf(
        SkillItem(
            "SQL",
            1f
        ),
        SkillItem(
            "Python",
            4f
        ),
        SkillItem(
            "C++",
            3f
        ),
        SkillItem(
            "Kotlin",
            0.7f
        )
    )

    private var filter = skills.map { it.experience.toInt() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this)

        loadAdapter()
        recycler_view.addItemDecoration(SpaceItemDecoration())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        filter = data?.getIntArrayExtra(FILTER_STATES)!!.toList()
        loadAdapter()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putIntArray(FILTER_STATES, filter.toIntArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        filter = savedInstanceState.getIntArray(FILTER_STATES)!!.asList()
        loadAdapter()
    }

    private fun loadAdapter() {
        val adapter =
            MainRecyclerAdapter(
                attrs + skills,
                skills.map { (it.experience.toInt() in filter) }
            )

        recycler_view.adapter = adapter
    }

    fun updateFiltering(items: List<SkillItem>, currentFilter: List<Boolean>) {
        val intent = Intent(this, FilterActivity::class.java)
        intent.putExtra(
            YEARS_TO_FILTER,
            items
                .map { item ->
                    item.experience
                }
                .distinct()
                .toFloatArray()
        )
        intent.putExtra(
            CURRENT_FILTER,
            currentFilter.toBooleanArray()
        )
        startActivityForResult(intent, 0)
    }
}

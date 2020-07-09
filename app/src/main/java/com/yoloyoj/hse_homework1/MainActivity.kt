package com.yoloyoj.hse_homework1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoloyoj.hse_homework1.main_recycler_adapter.MainRecyclerAdapter
import com.yoloyoj.hse_homework1.main_recycler_adapter.SpaceItemDecoration
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.ProjectIdea
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.SkillFilter
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.SkillItem
import com.yoloyoj.hse_homework1.main_recycler_adapter.models.UserInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
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

    private var filter = emptyList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this)

        loadAdapter()
        recycler_view.addItemDecoration(SpaceItemDecoration())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        filter = data?.getIntArrayExtra("filter")!!.toList()
        loadAdapter()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putIntArray("filter", filter.toIntArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        filter = savedInstanceState.getIntArray("filter")!!.asList()
        loadAdapter()
    }

    private fun loadAdapter() {
        val adapter =
            MainRecyclerAdapter(
                listOf(
                    UserInfo(
                        "Ларюшкин Сергей",
                        "Выпускник",
                        "https://github.com/yoloroy"
                    ),
                    ProjectIdea(
                        "очень крутой проект с очень оригинальными идеями"
                    ),
                    SkillFilter()
                ) + skills,
                skills.map { (it.experience.toInt() in filter) or filter.isEmpty() }
            )

        recycler_view.adapter = adapter
    }
}

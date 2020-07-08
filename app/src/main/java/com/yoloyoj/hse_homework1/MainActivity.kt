package com.yoloyoj.hse_homework1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoloyoj.hse_homework1.mainrecycleraddapter.MainRecyclerAdapter
import com.yoloyoj.hse_homework1.mainrecycleraddapter.SpaceItemDecoration
import com.yoloyoj.hse_homework1.mainrecycleraddapter.projectidea.ProjectIdea
import com.yoloyoj.hse_homework1.mainrecycleraddapter.skillfilter.SkillFilter
import com.yoloyoj.hse_homework1.mainrecycleraddapter.skillitem.SkillItem
import com.yoloyoj.hse_homework1.mainrecycleraddapter.userinfo.UserInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this)

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
                    SkillFilter(),
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
            )

        recycler_view.adapter = adapter
        recycler_view.addItemDecoration(SpaceItemDecoration())
    }
}

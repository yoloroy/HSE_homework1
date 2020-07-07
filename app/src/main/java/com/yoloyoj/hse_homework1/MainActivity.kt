package com.yoloyoj.hse_homework1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoloyoj.hse_homework1.projectidea.ProjectIdea
import com.yoloyoj.hse_homework1.skillitem.SkillItem
import com.yoloyoj.hse_homework1.userinfo.UserInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this)

        val adapter = MainRecyclerAdapter(
            listOf(
                UserInfo("Ларюшкин Сергей", "Выпускник", "https://github.com/yoloroy"),
                ProjectIdea("очень крутой проект с очень оригинальными идеями"),
                Any(),
                SkillItem("SQL", 1f),
                SkillItem("Python", 4f),
                SkillItem("C++", 3f)
            )
        )

        recycler_view.adapter = adapter
        recycler_view.adapter!!.notifyDataSetChanged()
    }

    public fun onClickGotoGithub(view: View) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/yoloroy")))
    }
}

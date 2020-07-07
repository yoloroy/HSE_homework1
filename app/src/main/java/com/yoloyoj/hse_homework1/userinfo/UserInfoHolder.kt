package com.yoloyoj.hse_homework1.userinfo

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yoloyoj.hse_homework1.R
import kotlinx.android.synthetic.main.user_info.view.*

class UserInfoHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var userInfo: UserInfo

    fun bind(userInfo: UserInfo) {
        view.apply {
            user_name.text = userInfo.userName
            grade.text = userInfo.grade
            goto_github.setOnClickListener {
                view.context.startActivity(
                    Intent(Intent.ACTION_VIEW, Uri.parse(userInfo.link))
                )
            }
        }

        this.userInfo = userInfo
    }
}

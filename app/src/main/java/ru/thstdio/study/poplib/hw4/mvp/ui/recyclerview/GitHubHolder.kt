package ru.thstdio.study.poplib.hw4.mvp.ui.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.hw4_item_rv.view.*

class GitHubHolder(val view: View) : RecyclerView.ViewHolder(view), GutHubItemView {
    override fun setreposName(name: String) {
        view.txtRepoName.text = name
    }

    override fun setId(id: Long) {
        view.txtId.text = id.toString()
    }
}
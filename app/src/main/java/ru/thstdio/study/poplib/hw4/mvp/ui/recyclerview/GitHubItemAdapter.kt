package ru.thstdio.study.poplib.hw4.mvp.ui.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.thstdio.study.poplib.R
import ru.thstdio.study.poplib.hw4.mvp.presenter.IListPresenter

class GitHubItemAdapter(val presenter: IListPresenter) : RecyclerView.Adapter<GitHubHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): GitHubHolder {
        return GitHubHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.hw4_item_rv, parent, false))
    }

    override fun getItemCount(): Int = presenter.getSize()


    override fun onBindViewHolder(holder: GitHubHolder, position: Int) {
        presenter.bindView(holder, position)
    }
}
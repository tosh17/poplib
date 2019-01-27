package ru.thstdio.study.poplib.hw4.mvp.presenter

import ru.thstdio.study.poplib.hw4.mvp.model.entity.UserRepos
import ru.thstdio.study.poplib.hw4.mvp.ui.recyclerview.GutHubItemView

class GithubListPresenter : IListPresenter {
    var repos: List<UserRepos> = ArrayList()
    override fun getSize(): Int = repos.size
    override fun bindView(holder: GutHubItemView, position: Int) {
        val item = repos[position]
        holder.setId(item.id)
        holder.setreposName(item.name)
    }
}
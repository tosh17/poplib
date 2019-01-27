package ru.thstdio.study.poplib.hw4.mvp.presenter

import android.annotation.SuppressLint
import io.reactivex.Scheduler
import ru.thstdio.study.poplib.hw4.mvp.model.GitHubRepo
import ru.thstdio.study.poplib.hw4.mvp.ui.MainView

class MainPresenter(private val mainThread: Scheduler) {
    private var listPresenter: GithubListPresenter = GithubListPresenter()
    private lateinit var view: MainView
    private lateinit var gitHubRepo: GitHubRepo

    fun attachView(view: MainView) {
        this.view = view
        gitHubRepo = GitHubRepo()
        view.init()
        loadData("tosh17")
    }

    fun getListPresenter(): IListPresenter {
        return listPresenter
    }

    @SuppressLint("CheckResult")
    private fun loadData(userName: String) {
        gitHubRepo.getUserRepos(userName)
            .observeOn(mainThread)
            .subscribe({ repos ->
                listPresenter.repos = repos
                view.updateUserReposList()
            }, { throwable ->
                //Handle error
            })
    }
}
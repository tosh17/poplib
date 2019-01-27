package ru.thstdio.study.poplib.hw4.mvp.model

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import ru.thstdio.study.poplib.hw4.mvp.model.entity.UserRepos

class GitHubRepo {
    fun getUserRepos(username: String): Observable<List<UserRepos>> {

        return ApiHolder.getInstance().api.getUsersRepos(username).subscribeOn(Schedulers.io())
    }

}
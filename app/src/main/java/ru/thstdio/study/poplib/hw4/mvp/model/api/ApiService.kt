package ru.thstdio.study.poplib.hw4.mvp.model.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import ru.thstdio.study.poplib.hw4.mvp.model.entity.UserRepos

interface ApiService {
    @GET("users/{user}/repos")
    fun getUsersRepos(@Path("user") userName: String): Observable<List<UserRepos>>
}
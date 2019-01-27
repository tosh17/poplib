package ru.thstdio.study.poplib.hw4.mvp.model

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.thstdio.study.poplib.hw4.mvp.model.api.ApiService

class ApiHolder private constructor() {

    val api: ApiService

    init {
        val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            // .excludeFieldsWithoutExposeAnnotation()
            .create()
        this.api = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService::class.java)
    }

    companion object {

        private var instance: ApiHolder? = ApiHolder()

        fun getInstance(): ApiHolder {
            if (instance == null) {
                instance = ApiHolder()
            }
            return instance as ApiHolder
        }


    }
}
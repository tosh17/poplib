package ru.thstdio.study.poplib

import android.app.Application
import android.content.Context

class PopLibApp: Application() {
    companion object {
      lateinit var contextApp: Context
    }

    override fun onCreate() {
        super.onCreate()
        contextApp=baseContext
    }
}
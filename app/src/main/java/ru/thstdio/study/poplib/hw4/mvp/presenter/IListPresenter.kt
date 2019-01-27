package ru.thstdio.study.poplib.hw4.mvp.presenter

import ru.thstdio.study.poplib.hw4.mvp.ui.recyclerview.GutHubItemView

interface IListPresenter {
    fun getSize(): Int
    fun bindView(holder: GutHubItemView, position: Int)
}
package ru.thstdio.study.poplib.hw3.mvp.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface Hw3View : MvpView {

    fun showPopUp()
    fun closePopUp()
}
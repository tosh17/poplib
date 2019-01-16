package ru.thstdio.study.poplib.mvp.presenter

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Scheduler
import ru.thstdio.study.poplib.mvp.model.Model
import ru.thstdio.study.poplib.mvp.view.MainView

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {
    var model: Model = Model()
    lateinit var sheduler: Scheduler


    fun clickButtonOne() {
        var x = model.setAt(0)
            .observeOn(sheduler)
            .subscribe({ result ->
                viewState.setButtonOneValue(result)
            }, { error -> Log.e("Error",error.toString()) }
            )

    }

    fun clickButtxonTwo() {
        var x = model.setAt(1)
            .observeOn(sheduler)
            .subscribe({ result ->
                viewState.setButtonTwoValue(result)
            }, { error -> Log.e("Error",error.toString()) }
            )
    }

    fun clickButtonThree() {
        var x = model.setAt(2)
            .observeOn(sheduler)
            .subscribe({ result ->
                viewState.setButtonTreeValue(result)
            }, { error -> Log.e("Error",error.toString()) }
            )
    }
}
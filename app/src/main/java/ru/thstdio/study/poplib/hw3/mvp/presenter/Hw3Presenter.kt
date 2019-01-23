package ru.thstdio.study.poplib.hw3.mvp.presenter

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import ru.thstdio.study.poplib.hw3.mvp.model.ConvertModel
import ru.thstdio.study.poplib.hw3.mvp.ui.Hw3View
import ru.thstdio.study.poplib.hw3.util.CoupleObject

@InjectViewState
class Hw3Presenter(var sheduler: Scheduler) : MvpPresenter<Hw3View>() {
    val model: ConvertModel = ConvertModel()
    fun clickStartConvert(coupleFileName: CoupleObject<String, String>) {
        convertFile(coupleFileName)
        viewState.showPopUp()
    }

    fun clickCancelConvert() {
        Log.d("PopLibLog","Convert Cancel")
        convertAction?.dispose()
    }

    private var convertAction: Disposable? = null

    private fun convertFile(couple: CoupleObject<String, String>) {
        convertAction = model.convertJpegToPng(couple).observeOn(sheduler)
            .subscribe { result -> convertFileComplite(result) }
    }

    private fun convertFileComplite(result: Boolean) {
        viewState.closePopUp()
    }

}
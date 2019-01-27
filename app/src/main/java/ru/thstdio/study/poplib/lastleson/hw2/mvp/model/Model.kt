package ru.thstdio.study.poplib.lastleson.hw2.mvp.model

import android.graphics.Color
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.*
import io.reactivex.subjects.PublishSubject


class Model {
    var counters: MutableList<Int>
    var source = PublishSubject.create<Int>()

    init {
        counters = ArrayList()
        counters.add(0)
        counters.add(0)
        counters.add(0)
    }

    fun getAt(pos: Int): Int = counters[pos]

    fun setAt(pos: Int): Single<Int> {

        return Single.just(pos)
            .observeOn(Schedulers.io())
            .map {
                Thread.sleep(3_000)
                counters[it] = getAt(it) + 1
                source.onNext(getColor())
                counters[it]
            }
    }

    fun getColorPart(index: Int): Int = (counters[index] * 10) % 256
    fun getColor(): Int = Color.rgb(getColorPart(0), getColorPart(1), getColorPart(2))
}

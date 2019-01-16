package ru.thstdio.study.poplib.mvp.model

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.*

class Model {
    var counters: MutableList<Int>

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
                counters[it]
            }
    }
}

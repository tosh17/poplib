package ru.thstdio.study.poplib.hw3.mvp.model

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.thstdio.study.poplib.hw3.util.CoupleObject
import ru.thstdio.study.poplib.hw3.util.GraphUtil


class ConvertModel {

    fun convertJpegToPng(pair: CoupleObject<String, String>): Single<Boolean> {
        return Single.just(pair)
            .observeOn(Schedulers.io())
            .map(this::sleep)
            .map { couple -> GraphUtil.convert(couple.first, couple.second) }

    }

    private fun sleep(couple: CoupleObject<String, String>): CoupleObject<String, String> {
        Thread.sleep(5000)
        return couple
    }
}
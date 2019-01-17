package ru.thstdio.study.poplib

import android.os.Bundle
import android.util.Log
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.jakewharton.rxbinding2.widget.RxTextView

import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import ru.thstdio.study.poplib.mvp.presenter.MainPresenter
import ru.thstdio.study.poplib.mvp.view.MainView


class MainActivity : MvpAppCompatActivity(), View.OnClickListener, MainView {


    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCounter1.setOnClickListener(this)
        btnCounter2.setOnClickListener(this)
        btnCounter3.setOnClickListener(this)
        val editTextSub = RxTextView.textChanges(editText).subscribe { result -> textView.text = result }


    }

    @ProvidePresenter(type = PresenterType.GLOBAL)
    fun provideMainPresenter(): MainPresenter = MainPresenter(AndroidSchedulers.mainThread())


    override fun onClick(v: View) {
        when (v) {
            btnCounter1 -> presenter.clickButtonOne()
            btnCounter2 -> presenter.clickButtxonTwo()
            btnCounter3 -> presenter.clickButtonThree()
        }

    }


    override fun setButtonOneValue(value: Int) {
        btnCounter1.text = String.format(getString(R.string.countEquals), value)
    }

    override fun setButtonTwoValue(value: Int) {
        btnCounter2.text = String.format(getString(R.string.countEquals), value)
    }

    override fun setButtonTreeValue(value: Int) {
        btnCounter3.text = String.format(getString(R.string.countEquals), value)
    }

    override fun setImageColor(color: Int) {
        Log.d("Color",color.toString())
        imageView.setColorFilter(color)
         }
}

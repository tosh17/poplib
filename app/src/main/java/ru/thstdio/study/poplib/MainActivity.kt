package ru.thstdio.study.poplib

import android.os.Bundle
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
import org.reactivestreams.Subscription




class MainActivity : MvpAppCompatActivity(), View.OnClickListener, MainView {

    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCounter1.setOnClickListener(this)
        btnCounter2.setOnClickListener(this)
        btnCounter3.setOnClickListener(this)
        presenter.sheduler=AndroidSchedulers.mainThread()
       val editTextSub = RxTextView.textChanges(editText).subscribe { result->textView.text=result}


    }

    @ProvidePresenter(type = PresenterType.GLOBAL)
    fun provideMainPresenter(): MainPresenter = MainPresenter()


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
}

package ru.thstdio.study.poplib.hw3

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.arellomobile.mvp.presenter.ProvidePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_hw3.*
import ru.thstdio.study.poplib.R
import ru.thstdio.study.poplib.hw3.mvp.presenter.Hw3Presenter
import ru.thstdio.study.poplib.hw3.mvp.ui.Hw3View
import ru.thstdio.study.poplib.hw3.util.CoupleObject

class Hw3Activity : MvpAppCompatActivity(), View.OnClickListener, Hw3View {

    val MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 10001
    private val inFileName = "dog.jpg"
    private val outFileName = "dog.png"
    private val coupleFileName=CoupleObject(inFileName,outFileName)
    var dialog: AlertDialog? = null

    override fun showPopUp() {
        if (dialog == null) dialog = createDialog()
        dialog?.show()
    }

    override fun closePopUp() {
        dialog?.cancel()
    }

    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var presenter: Hw3Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw3)
        buttonConvert.isEnabled = false
        checkPermissions()
    }

    private fun initBtn() {
        buttonConvert.isEnabled = true
        buttonConvert.setOnClickListener(this)
    }

    private fun checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE
            )

        } else {
            initBtn()
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    initBtn()
                } else {
                    //error
                }
                return
            }
            else -> {
                // Ignore all other requests.
            }
        }
    }

    @ProvidePresenter(type = PresenterType.GLOBAL)
    fun provideMainPresenter(): Hw3Presenter =
        Hw3Presenter(AndroidSchedulers.mainThread())

    override fun onClick(v: View?) {
        presenter.clickStartConvert(coupleFileName)
    }


    private fun createDialog(): AlertDialog {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Custom dialog")
        dialogBuilder.setMessage("Выхотите отменить конвертацию")
        dialogBuilder.setPositiveButton("да") { dialog, whichButton ->
            presenter.clickCancelConvert()
        }
        dialogBuilder.setNegativeButton("Нет") { dialog, whichButton ->
            dialog.cancel()
        }
        return dialogBuilder.create()
    }
}

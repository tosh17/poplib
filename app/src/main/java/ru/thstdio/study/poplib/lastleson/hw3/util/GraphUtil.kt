package ru.thstdio.study.poplib.lastleson.hw3.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import android.util.Log
import ru.thstdio.study.poplib.PopLibApp
import java.io.File
import java.io.FileOutputStream

class GraphUtil {
    companion object {
        private const val JPEG_QUALITY = 80
        fun convert(fileJpgName: String, filePngName: String): Boolean {
            try {
                val stream = PopLibApp.contextApp.assets.open(fileJpgName)
                val bmp = BitmapFactory.decodeStream(stream)
                val filePath = Environment.getExternalStorageDirectory().absolutePath + "/pic"
                val dir = File(filePath)
                if (!dir.exists()) dir.mkdirs()
                val file = File(dir, filePngName)
                if (file.exists()) file.delete()
                val out = FileOutputStream(file)
                bmp.compress(Bitmap.CompressFormat.PNG, JPEG_QUALITY, out)
                out.close()

            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("PopLibLog","Convert Error")
                return false
            }
            Log.d("PopLibLog","Convert Done")
            return true
        }
    }

}
package com.example.clase25febrero

import android.content.Context
import java.io.IOException
import java.io.InputStream



class MIscelanius {
    companion object {

        const val PERMISSION_READ_CONTACTS = 10
        const val PERMISSION_CAMERA = 20

        fun loadJSONFromAsset(context: Context, fileName: String): String? {
            var json: String? = null
            try {
                val isStream: InputStream = context.assets.open(fileName)
                val size = isStream.available()
                val buffer = ByteArray(size)
                isStream.read(buffer)
                isStream.close()
                json = String(buffer, charset("UTF-8"))
            } catch (ex: IOException) {
                ex.printStackTrace()
                return null
            }
            return json
        }
    }
}
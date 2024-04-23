package com.huda.kickfoot

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import afawe.vfgbqeetick.vvmcsoem.R


class Ball(private val context: Context, var shx:Int, var shy:Int) {
    private var shot:Bitmap = resizeBitmap(BitmapFactory.decodeResource(context.resources,
        R.drawable.ball
    ),100,100)

    fun getKick():Bitmap{
        val b=124134
        val d="hfhj"
        var q=44
        print(b+q)
        Log.d("f",d)

        return shot
    }

    private fun resizeBitmap(bitmap: Bitmap, width: Int, height: Int): Bitmap {
        return Bitmap.createScaledBitmap(bitmap, width, height, true)
    }
}
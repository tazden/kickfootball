package com.huda.kickfoot

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import afawe.vfgbqeetick.vvmcsoem.R


class Disrupting(private val context: Context, var ex:Int, var ey:Int) {
    private var explosion=arrayOfNulls<Bitmap>(4)
    var frame:Int=0
    init {
        explosion[0] = scaleBitmap(R.drawable.ex4)
        explosion[1] = scaleBitmap(R.drawable.ex4)
        explosion[2] = scaleBitmap(R.drawable.ex4)
        explosion[3] = scaleBitmap(R.drawable.ex4)

    }

    private fun scaleBitmap(resourceId: Int, scaleFactor: Float = 0.10f): Bitmap {
        val originalBitmap = BitmapFactory.decodeResource(context.resources, resourceId)
        val width = (originalBitmap.width * scaleFactor).toInt()
        val height = (originalBitmap.height * scaleFactor).toInt()
        return Bitmap.createScaledBitmap(originalBitmap, width, height, true)
    }

    fun getExplosionFrame(frame:Int):Bitmap{
        return explosion[frame]!!
    }

}
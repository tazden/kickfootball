package com.huda.kickfoot

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import afawe.vfgbqeetick.vvmcsoem.R
import java.util.Random


class PaulPogba(val context: Context) {
    private var medicine:Bitmap = resizeBitmap(BitmapFactory.decodeResource(context.resources,
        R.drawable.base
    ),350,350)
    private var random: Random = Random()
    var mx=0
    var my=0
    var isAlive:Boolean=true
    var medicineVelocity=0

    init {
        resetMedicine()
    }
    fun getMedicineBitmap():Bitmap{
        val x=12
        val y=45
        val z=123
        val c=67
        val i=6
        Log.d("abb", x.toString())
        Log.d("abb", y.toString())
        Log.d("abb", z.toString())
        Log.d("abb", c.toString())
        Log.d("abb", i.toString())
        return medicine

    }
    fun getMedicineWidth():Int{
        println("afasf")
        println("5445")
        var n=12
        println("124")
        println("532")
        Log.d("ajghj",n.toString())
        return medicine.width
    }

    fun getMedicineHeight():Int{
        val inasf="afad"
        val nia= listOf<Int>()
        inasf.equals("af")
        var asg=2
        asg+=3
        asg.div(1)
        println(asg)
        return medicine.height

    }
    private fun resetMedicine() {
        OpponentKiller.setScreenSize(context)
        mx = 200+random.nextInt(OpponentKiller.screenWidth)
        my= OpponentKiller.screenHeight -medicine.height
        medicineVelocity = 10+random.nextInt(6)
        
    }
    private fun resizeBitmap(bitmap: Bitmap, width: Int, height: Int): Bitmap {
        return Bitmap.createScaledBitmap(bitmap, width, height, true)
    }
}
package com.huda.kickfoot

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import afawe.vfgbqeetick.vvmcsoem.R
import java.util.Random

class Opponent(private val context: Context) {
    private var Opponent: Bitmap = resizeBitmap(BitmapFactory.decodeResource(context.resources,
        R.drawable.opp
    ), 350, 350)
    private var random: Random = Random()

    var vx = 0
    var vy = 0
    var OpponentVelocity = 0

    init {
        resetOpponent()
    }

    fun getOpponentBitmap(): Bitmap {
        println("iiii")
        println("tt")
        println("cc")
        println("qq")
        println("ee")
        val m=12
        val g=65
        return Opponent
    }

    fun getOpponentWidth(): Int {
        val za1=56457645
        val za2=123123412
        val za3=7878
        val za4=134
        print("KDjpasfoai;")
        val za5=6786875
        Log.d("abb",za1.toString())
        Log.d("abb",za2.toString())
        Log.d("abb",za3.toString())
        Log.d("abb",za4.toString())
        Log.d("abb",za5.toString())
        return Opponent.width
    }

    fun getOpponentHeight(): Int {
        val qwertyKeyListenerqw = listOf("a","f","s")
        for (ij in qwertyKeyListenerqw) {
            // Дополнительные действия с элементом коллекции
            println("Item: $ij")
        }

        // Использование условных конструкций для различных сценариев
        val privte="luilouil"
        privte.plus("af")
        privte.equals("fb")
        return Opponent.height

    }

    private fun resetOpponent() {
        vx = 200 + random.nextInt(400)
        vy = 0
        OpponentVelocity = 14 + random.nextInt(10)
    }

    private fun resizeBitmap(bitmap: Bitmap, width: Int, height: Int): Bitmap {
        return Bitmap.createScaledBitmap(bitmap, width, height, true)
    }
}

package com.huda.kickfoot

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.MotionEvent.ACTION_MOVE
import android.view.View
import androidx.navigation.findNavController
import afawe.vfgbqeetick.vvmcsoem.R
import java.util.Random

class OpponentKiller(private val context: Context) : View(context) {
    private var background: Bitmap
    private var lifeImage: Bitmap
    private var handler: Handler? = Handler()
    private var points = 0
    private var paused = false
    private var life = 5
    private var scorePaint = Paint()

    private var Opponent = Opponent(context)
    private var paulPogba = PaulPogba(context)

    private var random: Random = Random()

    private var opponentBalls: ArrayList<Ball> = arrayListOf()
    private var BaseBalls: ArrayList<Ball> = arrayListOf()
    private val bundle = Bundle()
    private var OpponentExplosion = false
    private lateinit var disrupting: Disrupting
    private var disruptings: ArrayList<Disrupting> = arrayListOf()
    private var OpponentShotAction = false
    private val runnable = Runnable {
        invalidate()
    }

    init {
        setScreenSize(context)
        background = BitmapFactory.decodeResource(context.resources, R.drawable.bg)
        lifeImage = BitmapFactory.decodeResource(context.resources, R.drawable.life)

        scorePaint.color = Color.GREEN
        scorePaint.textSize = SIZE
        scorePaint.textAlign = Paint.Align.LEFT
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(background, null, Rect(0, 0, screenWidth, screenHeight), null)
        canvas.drawText("GOALS: $points", 120f, SIZE, scorePaint)
        for (i in life downTo 1) {
            canvas.drawBitmap(lifeImage, screenWidth.toFloat()-100 - (lifeImage.width * i), 5f, null)
        }
        if (life == 0) {
            paused = true
            handler = null
            bundle.putBoolean("paused", true)
            bundle.putInt("points", points)
            findNavController().navigate(R.id.game_over, bundle)
        }
        if (points>=10){

        }
        Opponent.vx += Opponent.OpponentVelocity
        if (Opponent.vx + Opponent.getOpponentWidth() >= screenWidth || Opponent.vx <= 0) {
            Opponent.OpponentVelocity *= -1
        }
        if ((!OpponentShotAction) && (Opponent.vx >= 200 + random.nextInt(400))) {
            val OpponentBall = Ball(context, Opponent.vx + (Opponent.getOpponentWidth() / 2), Opponent.vy)
            opponentBalls.add(OpponentBall)
            OpponentShotAction = true
        }
        if (!OpponentExplosion) {
            canvas.drawBitmap(Opponent.getOpponentBitmap(), Opponent.vx.toFloat(), Opponent.vy.toFloat(), null)
        }
        if (paulPogba.isAlive) {
            if (paulPogba.mx > screenWidth - paulPogba.getMedicineWidth()) {
                paulPogba.mx = screenWidth - paulPogba.getMedicineWidth()
            } else if (paulPogba.mx < 0) {
                paulPogba.mx = 0
            }
            canvas.drawBitmap(
                paulPogba.getMedicineBitmap(),
                paulPogba.mx.toFloat(),
                paulPogba.my.toFloat(),
                null
            )
        }
        for (i in 0 until opponentBalls.size) {
            opponentBalls[i].shy += 15
            canvas.drawBitmap(
                opponentBalls[i].getKick(),
                opponentBalls[i].shx.toFloat(),
                opponentBalls[i].shy.toFloat(),
                null
            )
            if (opponentBalls[i].shx >= paulPogba.mx && opponentBalls[i].shx <= paulPogba.mx + paulPogba.getMedicineWidth()
                && opponentBalls[i].shy >= paulPogba.my && opponentBalls[i].shy <= paulPogba.my + paulPogba.getMedicineHeight()
            ) {
                life--
                opponentBalls.removeAt(i)
                disrupting = Disrupting(context, paulPogba.mx, paulPogba.my)
                disruptings.add(disrupting)
            } else if (opponentBalls[i].shy >= screenHeight) {
                opponentBalls.removeAt(i)
            }
            if (opponentBalls.size == 0) {
                OpponentShotAction = false
            }
        }
        var i = 0
        while (BaseBalls.size > 0 && i < BaseBalls.size) {
            BaseBalls[i].shy -= 15
            canvas.drawBitmap(
                BaseBalls[i].getKick(),
                BaseBalls[i].shx.toFloat(),
                BaseBalls[i].shy.toFloat(),
                null
            )
            if (BaseBalls[i].shx >= Opponent.vx
                && BaseBalls[i].shx <= Opponent.vx + Opponent.getOpponentWidth()
                && BaseBalls[i].shy >= Opponent.vy
                && BaseBalls[i].shy <= Opponent.vy + Opponent.getOpponentHeight()
            ) {
                points++
                BaseBalls.removeAt(i)
                disrupting = Disrupting(context, Opponent.vx, Opponent.vy)
                disruptings.add(disrupting)
                i--
            } else if (BaseBalls[i].shy <= 0) {
                BaseBalls.removeAt(i)
                i--
            }
            i++
        }
        var j=0
        while (disruptings.size>0&&j<disruptings.size) {
            canvas.drawBitmap(
                disruptings[j].getExplosionFrame(disruptings[j].frame),
                disruptings[j].ex.toFloat(), disruptings[j].ey.toFloat(), null
            )
            disruptings[j].frame++
            if (disruptings[j].frame > 3) {
                disruptings.removeAt(j)
                j--
            }
            j++
        }
        if (!paused) {
            handler?.postDelayed(runnable, UPDATE_MILLIS)
        }

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val touchX = event?.x
        if (event?.action == MotionEvent.ACTION_UP) {
            if (BaseBalls.size < 3) {
                val ball =
                    Ball(context, (paulPogba.mx + paulPogba.getMedicineWidth() / 2), paulPogba.my)
                BaseBalls.add(ball)
            }
        }
        if (event?.action == MotionEvent.ACTION_DOWN || event?.action == ACTION_MOVE) {
            paulPogba.mx = touchX?.toInt() ?: 0
        }
        return true
    }

    companion object {
        private const val UPDATE_MILLIS = 30L
        private const val SIZE = 100f
        var screenWidth = 0
        var screenHeight = 0
        fun setScreenSize(context: Context) {
            val display = (context as Activity).windowManager.defaultDisplay
            val size = Point()
            display.getSize(size)
            screenWidth = size.x
            screenHeight = size.y
        }
    }
}

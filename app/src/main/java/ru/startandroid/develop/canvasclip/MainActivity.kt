package ru.startandroid.develop.canvasclip

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(DrawView(this))
    }

    /*internal inner class DrawView(context: Context): View(context) {
        private var p: Paint = Paint()
        private var rect: Rect

        init {
            p.style = Paint.Style.STROKE
            p.strokeWidth = 3f
            rect = Rect(210, 210, 410, 510)
        }

        /*override fun onDraw(canvas: Canvas?) {
            canvas!!.drawARGB(80, 102, 204, 255)

            p.color = Color.BLUE
            drawGrid(canvas)

            p.color = Color.RED
            canvas.drawRect(rect, p)
        }*/

        override fun onDraw(canvas: Canvas?) {
            canvas!!.drawARGB(80, 102, 204, 255)

            p.color = Color.BLUE
            drawGrid(canvas)

            p.color = Color.RED
            canvas.drawRect(rect, p)

            canvas.translate(600f, 0f)

            canvas.clipRect(rect)

            p.color = Color.BLUE
            drawGrid(canvas)
        }

        private fun drawGrid(canvas: Canvas?) {
            run {
                var i = 25
                while (i  < 400) {
                    canvas!!.drawLine((100 + i).toFloat(), 100f, (100 + i).toFloat(), 600f, p)
                    i += 25
                }
            }

            var i = 25
            while (i < 500) {
                canvas!!.drawLine(100f, (100 + i).toFloat(), 500f, (100 + i).toFloat(), p)
                i += 25
            }
        }
    }*/

    internal class DrawView(context: Context?) : View(context) {
        private var p: Paint = Paint()
        private var rect1: Rect
        private var rect2: Rect
        private var op: Region.Op = Region.Op.UNION

        init {
            p.style = Paint.Style.STROKE
            p.strokeWidth = 3f
            rect1 = Rect(180, 220, 340, 380)
            rect2 = Rect(280, 320, 440, 480)
        }

        override fun onDraw(canvas: Canvas) {
            canvas.drawARGB(80, 102, 204, 255)

            p.color = Color.BLUE
            drawGrid(canvas)

            p.color = Color.RED
            canvas.drawRect(rect1, p)
            canvas.drawRect(rect2, p)

            canvas.translate(600f, 0f)

            canvas.clipRect(rect1)
            canvas.clipRect(rect2, op)

            p.color = Color.BLUE
            drawGrid(canvas)
        }

        private fun drawGrid(canvas: Canvas) {
            run {
                var i = 25
                while (i < 400) {
                    canvas.drawLine((100 + i).toFloat(), 100f, (100 + i).toFloat(), 600f, p)
                    i += 25
                }
            }
            var i = 25
            while (i < 500) {
                canvas.drawLine(100f, (100 + i).toFloat(), 500f, (100 + i).toFloat(), p)
                i += 25
            }
        }
    }
}
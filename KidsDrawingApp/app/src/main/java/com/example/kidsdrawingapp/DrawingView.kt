package com.example.kidsdrawingapp

import android.view.View
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.Toast

class DrawingView(context: Context,attrs: AttributeSet) : View(context,attrs){
 private var mDrawPath:custompath?=null
 private var mDrawPathArray: ArrayList<custompath>?=null
 private var mUndoPathArray: ArrayList<custompath>?=null
 private var mDrawPaint:Paint? = null
 private var canvas: Canvas? = null
 private var mBitMapSize: Bitmap? =null
 private var color=Color.BLACK
 private var brushsize=10F
// private var
 init {
     setupdrawing()
 }
 private fun setupdrawing(){
     mDrawPath=custompath(color,brushsize)
     mDrawPaint=Paint()
     mDrawPathArray=ArrayList<custompath>()
     mUndoPathArray=ArrayList<custompath>()
     mDrawPaint?.color= color
     mDrawPaint?.style = Paint.Style.STROKE
     mDrawPaint?.strokeJoin = Paint.Join.ROUND
     mDrawPaint?.strokeCap = Paint.Cap.ROUND
     mDrawPaint?.strokeWidth = brushsize


 }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mBitMapSize =Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888)
        canvas= Canvas(mBitMapSize!!)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val touchX=event.x
        val touchY=event.y
        when(event.action){
            MotionEvent.ACTION_DOWN->{
                mDrawPath?.color=color
                mDrawPath?.moveTo(touchX,touchY)

            }
            MotionEvent.ACTION_MOVE->{
                mDrawPath?.lineTo(touchX,touchY)
            }
            MotionEvent.ACTION_UP->{
                mDrawPath?.lineTo(touchX,touchY)
                mDrawPathArray?.add(mDrawPath!!)
                mDrawPath=custompath(color, brushsize)

            }
            else-> return false
        }
     invalidate()
     return true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mBitMapSize.let {
            canvas?.drawBitmap(it!!, 0f,   0f, mDrawPaint)
        }

        for (p in mDrawPathArray!!){
            mDrawPaint!!.color = p.color
            canvas?.drawPath(p,mDrawPaint!!)
        }
        if (!mDrawPath!!.isEmpty) {
            mDrawPaint!!.color= mDrawPath!!.color
            canvas?.drawPath(mDrawPath!!, mDrawPaint!!)
        }
    }
    fun undo(){
        if(mDrawPathArray!!.size>0){
        mUndoPathArray!!.add( mDrawPathArray!!.removeAt(mDrawPathArray!!.size-1))
            invalidate()
        }

    }

    fun selectmarker(colour: Int){
        color= colour
    }

    internal inner class custompath(var color: Int,var brushsize: Float):Path()
}
package com.aplus.camera.utils

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.LightingColorFilter
import android.graphics.Paint
import android.widget.ImageView


class ImageFilter {

    fun toGrayscale(bmpOriginal: Bitmap): Bitmap? {
        val height: Int = bmpOriginal.height
        val width: Int = bmpOriginal.width
        val bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val c = Canvas(bmpGrayscale)
        val paint = Paint()
        val cm = ColorMatrix()
        cm.setSaturation(0f)
        val f = ColorMatrixColorFilter(cm)
        paint.colorFilter = f
        c.drawBitmap(bmpOriginal, 0f, 0f, paint)
        return bmpGrayscale
    }

    fun changeBitmapColor(sourceBitmap: Bitmap, color: Int): Bitmap? {
        val resultBitmap = Bitmap.createBitmap(
            sourceBitmap, 0, 0,
            sourceBitmap.width - 1, sourceBitmap.height - 1
        )
        val p = Paint()
        val filter: ColorFilter = LightingColorFilter(color, 1)
        p.colorFilter = filter
        val canvas = Canvas(resultBitmap)
        canvas.drawBitmap(resultBitmap, 0f, 0f, p)
        return resultBitmap
    }
}
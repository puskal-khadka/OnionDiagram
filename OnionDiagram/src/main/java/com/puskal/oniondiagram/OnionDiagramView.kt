package com.puskal.oniondiagram

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.puskal.oniondiagramdemo.R

/**
 * Created by Puskal khadka
 */
class OnionDiagramView : View {

    private var textColor: Int = 0
    private var bgColor: Int = 0
    private var textSize: Int = 0
    var valueList = arrayListOf<Float>()
    var colorList = arrayListOf<Int>()

    private enum class TextAlignPatternIs {
        SAME_ROW,
        DIFFERENT_ROW
    }

    var textAlignPattern: Int = 0
    var diagramType: Int = 0


    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val typedArray: TypedArray =
            context.obtainStyledAttributes(attrs, R.styleable.OnionDiagramView, 0, 0)
        textSize = typedArray.getDimensionPixelSize(R.styleable.OnionDiagramView_textSize, 14)
        textColor = typedArray.getColor(R.styleable.OnionDiagramView_textColor, Color.BLACK)
        bgColor = typedArray.getColor(R.styleable.OnionDiagramView_backgroundColor, Color.WHITE)

        textAlignPattern = typedArray.getInt(R.styleable.OnionDiagramView_onionTextAlign, 1)
        diagramType = typedArray.getInt(R.styleable.OnionDiagramView_diagramType, 0)
        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val x = width.toFloat()
        val y = height.toFloat()
        val r1 = 50F
        val r2 = 100F

        val paint = Paint()
        paint.style = Paint.Style.FILL


        if (valueList.isEmpty()) {
            //for testing --> incase if data not send
            colorList =
                arrayListOf<Int>(Color.RED, Color.CYAN, Color.YELLOW, Color.MAGENTA, Color.GREEN)
            valueList = arrayListOf<Float>(300F, 200F, 350F,250F)
        }


        val integratedColorList = arrayListOf<Int>()
        for (i in 0 until valueList.size) {
            when (colorList.size) {
                0 -> integratedColorList.add(MyUtils.ColorList[i % (MyUtils.ColorList.size)])
                else -> integratedColorList.add(colorList[i % colorList.size])
            }
        }

        valueList.sort()
        valueList.reverse()


        var total = 0F
        for (item in valueList) {
            total += item
        }


        val largeRadius = width / 2.toFloat()


        val dataList = arrayListOf<Float>()

        for (item in valueList) {
            dataList.add(item / total * 100)
        }

        /**mainRadius is Radius for each layer
         */
        var mainRadius = largeRadius

        /**
         * xPix and yPix is center co-ordinate of iew
         */
        var xPix = x / 2
        var yPix = y / 2

        /**
         * textYPix and textXPix is co-ordinate of text
         */
        var textYPix = y / 2
        var textXPix = x / 2


        for (i in 0 until valueList.size) {
            paint.color = integratedColorList[i]

            when (diagramType) {
                0 -> {
                    mainRadius = (largeRadius / dataList[0]) * dataList[i]
                    xPix = (x / 2) + largeRadius - mainRadius - i * 10
                }
                1 -> {

                    if (i != 0) {
                        mainRadius = mainRadius - (largeRadius / dataList.size) + (largeRadius / (dataList.size * 4F))

                        xPix = ((x / 2) + largeRadius) - mainRadius - i * 10

                    } else {
                        mainRadius = (largeRadius / dataList[0]) * dataList[i]

                    }
                }
            }

            canvas?.drawCircle(xPix, yPix, mainRadius, paint)



            paint.textAlign = Paint.Align.LEFT
            paint.setColor(textColor)
            paint.textSize = textSize.toFloat()

            when (textAlignPattern) {
                0 -> textYPix = y / 2
                1 -> textYPix = y / 2 + (i * 20)
            }

            if (i == valueList.size - 1) {
                textXPix = xPix - 20
                textYPix = y / 2
            } else
                textXPix = xPix - mainRadius + 8

            canvas?.drawText("%.1f ".format(dataList[i])+"%", textXPix, textYPix, paint)


        }


    }


}
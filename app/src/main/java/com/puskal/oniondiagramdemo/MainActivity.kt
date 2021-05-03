package com.puskal.oniondiagramdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.puskal.oniondiagram.OnionDiagramView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onionDiagramView=findViewById<OnionDiagramView>(R.id.viewOnion)

        /**@author Puskal Khadka
         * valuelist is for list of data (float) that you want to show in diagram
         */
        onionDiagramView.valueList=arrayListOf<Float>(300F, 200F,350F,150F,250F)

        /**@author Puskal khadak
         * colorList is optional. Give color List here if you want to show custom color
         * otherwise default set color will be shown.
         * while defining custom color, if color list size if less than data, then color will be repeated.
         */
//        onionDiagramView.colorList= arrayListOf(Color.RED,Color.GREEN,Color.Blue)
    }
}
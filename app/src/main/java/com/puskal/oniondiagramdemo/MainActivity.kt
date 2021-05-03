package com.puskal.oniondiagramdemo

import android.graphics.Color
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
//        onionDiagramView.colorList= arrayListOf(Color.RED,Color.GREEN,Color.YELLOW)

        /**NOTE ---------------------->>>>>
         * Read Carefully below
         * if you want your onion diagram's layers size according to passed value then use   app:diagramType="CalculatedPrecise" in your xml defined
         * but in some case you may want your onion layer size should be uniform irrespective to value so in that case use app:diagramType="UniformDecreasing"
         * By default diagram type is "CalculatedPrecise"

         */
    }
}
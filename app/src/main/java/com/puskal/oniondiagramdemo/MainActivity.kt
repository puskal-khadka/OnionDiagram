package com.puskal.oniondiagramdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.puskal.oniondiagram.OnionDiagramView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onionDiagramView = findViewById<OnionDiagramView>(R.id.viewOnion)

        /**@author Puskal Khadka
         * valuelist is for list of data (float) that you want to show in diagram
         */
        onionDiagramView.valueList = arrayListOf<Float>(300F, 200F, 350F, 150F, 250F)

        /** if you want to show same data as passed above in value list then make below true
         * but if you want to show calculated percentage data from above then make below false
         */
        onionDiagramView.showRawData = false

        /**@author Puskal khadak
         * colorList is optional. Give color List here if you want to show custom color
         * otherwise default set color will be shown. (color will repeat if passed data list size is greater then color list size
         */
//        onionDiagramView.colorList= arrayListOf(Color.RED,Color.GREEN,Color.YELLOW)

        /**NOTE ------------------  * Read Carefully below *---->>>>>
         * if you want your onion diagram's layers size according to passed value then use   app:diagramType="CalculatedPrecise" in your xml defined
         * but in some case you may want your onion layer size should be uniform irrespective to value so in that case use app:diagramType="UniformDecreasing"
         * By default diagram type is "CalculatedPrecise"

         */
    }
}
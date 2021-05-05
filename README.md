# Onion Diagram / Stacked Vann Diagram

Android library for onion diagram i.e also refered as stacked vann diagram



<img src="screenshot/ss1_onion.jpg" width="285"/>         <img src="screenshot/ss2_onion.jpg" width="285"/>
## Gradle


```bash
dependencies {
    ...
    implementation 'com.github.puskal-khadka:OnionDiagram:1.0.2'
}
```

## Maven

```bash 
	<dependency>
	    <groupId>com.github.puskal-khadka</groupId>
	    <artifactId>OnionDiagram</artifactId>
	    <version>1.0.2</version>
	</dependency>
```


## Usage

```bash
    <com.puskal.oniondiagram.OnionDiagramView
        android:id="@+id/viewOnion"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="50dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:onionTextAlign="differentRow"
        app:textColor="#1111ff"
        app:textSize="8sp"
        app:diagramType="CalculatedPrecise"
        />

```

## SetUp data
```java
     val onionDiagramView=findViewById<OnionDiagramView>(R.id.viewOnion)

     onionDiagramView.valueList=arrayListOf<Float>(300F, 200F,350F,150F,250F)


     //if you want to give your custom color to each layer then passed color as follow otherwise skip
     val colorList= arrayListOf(
                     ContextCompat.getColor(requireContext(),R.color.red),
                     ContextCompat.getColor(requireContext(),R.color.green),
                     ContextCompat.getColor(requireContext(),R.color.yellow),
                 )
      
      

```

## PARAMETERS AND FUNCTIONS
* ```app:diagramType="CalculatedPrecise"```
  * Using it, each layer's size,radius will be as according to passed data . This is Default

* ```app:diagramType="UniformDecreasing"```
  * Each layer's radius will be unifrom, irrespective to data

* ```app:onionTextAlign="differentRow"```
  * Text in one layer will be at different row in comparasion to text in another laye . This is  default

* ```app:onionTextAlign="sameRow"```
  * Text in each layer will align in same row

* ```app:textColor="#11ffff"```
  * To change text color. Default color is black 

* ``` app:textSize="8sp" ```
  * To change text size. Default size 14sp
 
 * ```  onionDiagramView.showRawData=false ```
    * This is boolean field, if it is set false then passed data will be automatic conveted to percentage and shown in layer. If set true, same passed data will be shown

       


        

        

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

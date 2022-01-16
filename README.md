[![](https://jitpack.io/v/mehranelyas/RtlMarqueeView.svg)](https://jitpack.io/#mehranelyas/RtlMarqueeView)

# RtlMarqueeView

* **RTL marquee text view**
*  **can hande the speed of moving text**
* **can jump to the specefic position of the text at start**
* **can loop the marquee text ON or OFF**
*  **can set the first and last Delay**


# Installation

#### Step 1. Add the JitPack repository to your build file 

Add it in your root build.gradle at the end of repositories:


	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

  
  #### Step 2. Add the dependency
  
  	dependencies {
	        implementation 'com.github.mehranelyas:RtlMarqueeView:1.0.0'
	}


# Usage

### Step 1. Put this on layout file

    <com.mehranelyas.rtlmarquee.RtlMarqueeView
        android:id="@+id/rtlMarqueeView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

  ### Step 2. Add this code tho your activity or else...
  
  ```
  rtlMarqueeView = findViewById(R.id.rtlMarqueeView);
  
 ```
 ## setText
 set text and it will start
 ```
 rtlMarqueeView.setText(YOUR_TEXT_HERE);
 ```
  ## setLoopForever
  set loop forever (Default is true)
 ```
rtlMarqueeView.setLoopForever(true or false);
 ```
  ## setDuration
   if this set the text will animate it your specific time
 ```
rtlMarqueeView.setDuration(MILISECOND);
 ```

  ## setCurrentTime
   if this set the text will jump to the specific time that you set at the start
 ```
rtlMarqueeView.setCurrentTime(MILISECOND);
 ```
 
  ## setFirstGap
   set the start delay Defaul is 1000 (1 second)
 ```
rtlMarqueeView.setFirstGap(MILISECOND);
 ```
  ## setLastGap
   set the end delay Defaul is 2000 (2 second)
 ```
rtlMarqueeView.setLastGap(MILISECOND);
 ```
  ## setSpeed
   set the speed of moving text, Default is 4.0 (if this set the duration will calculate Automaticly)
   
 ```
rtlMarqueeView.setSpeed(FLOAT);
 ```

   ## small amounts are faster for example:
   **1.0** is very fast

   **2.0** is fast

   **3.0** is normall 

   **and more...**

   you can **test** it
   

 
 

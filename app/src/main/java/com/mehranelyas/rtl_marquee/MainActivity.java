package com.mehranelyas.rtl_marquee;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mehranelyas.rtlmarquee.RtlMarqueeView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    RtlMarqueeView rtlMarqueeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rtlMarqueeView = findViewById(R.id.marqueeView);
//        rtlMarqueeView.setTextTextViews("لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است. چاپگرها و متون بلکه روزنامه و مجله در ستون و سطرآنچنان که لازم است و برای شرایط فعلی تکنولوژی مورد نیاز و کاربردهای متنوع با هدف بهبود ابزارهای کاربردی می باشد. کتابهای زیادی در شصت و سه");

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        rtlMarqueeView.setLoopForever(false);
//                        rtlMarqueeView.setDuration(new Random().nextInt(8000)+3000);

                        rtlMarqueeView.setTextTextViews("کاربردهای متنوع با هدف بهبود ابزارهای کاربردی می باشد. کتابهای زیادی در شصت و سه");

                    }
                });
            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
//            rtlMarqueeView.init();
        }
    }
}
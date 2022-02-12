package com.mehranelyas.rtl_marquee;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mehranelyas.rtlmarquee.RtlMarqueeView;


public class MainActivity extends AppCompatActivity {
    RtlMarqueeView rtlMarqueeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rtlMarqueeView = findViewById(R.id.rtlMarqueeView);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rtlMarqueeView.setTypeface(Typeface.DEFAULT_BOLD);
                        rtlMarqueeView.setDuration(3000);
                        rtlMarqueeView.setCurrentTime(5000);

                        rtlMarqueeView.setText("لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است");

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
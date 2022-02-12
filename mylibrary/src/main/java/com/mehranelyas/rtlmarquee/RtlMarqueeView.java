package com.mehranelyas.rtlmarquee;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class RtlMarqueeView extends LinearLayout {
    private HorizontalScrollView hScrollTxt;
    private TextView txtAya;
    private boolean canScrollH = false;
    private int hTextWidth;
    private int duration = 0;
    private int settedDuration = 0;
    private int currentTime = 0;
    private int firstGap = 0;
    private int lastGap = 0;
    private float period = 4;
    private int hScrollWidth = 0;
    private long curentTime = 0;
    private long lastTime = 0;
    private Handler handler = new Handler();
    private boolean isEnable = true;
    private Context context;
    private boolean isLoop = true;
    private String text;
    private Typeface typeface = null;
    private boolean isSpeedSet = true;


    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
        if (txtAya!=null) {
            txtAya.setTypeface(typeface);
        }
    }

    public void setFirstGap(int millisecond) {
        this.firstGap = millisecond;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public void setLastGap(int millisecond) {
        this.lastGap = millisecond;
    }

    public void setLoopForever(boolean loopForever) {
        this.isLoop = loopForever;
    }

    public void setDuration(int millisecond) {
        this.settedDuration = millisecond;
        isSpeedSet = false;
    }


    public void setSpeed(float speed) {
        this.period = speed;
        isSpeedSet = true;
    }


    private static final String TAG = "RtlMarqueeView";


    boolean isStarted = false;

    public void setText(String text) {
        this.text = text;
        canScrollH = false;

        duration = (int) (period * text.length());
        if (settedDuration > 0) {
            duration = settedDuration;
        }
        if (lastTime < curentTime) {
            handler.removeCallbacksAndMessages(null);
            Log.d(TAG, "setTextTextViews: removeCallbacksAndMessages");
        }

        txtAya.setText("");
        txtAya.setText(text);


        hScrollTxt.scrollTo(0, 0);


        if (isEnable) {
            try {
                isStarted = false;
                txtAya.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        isStarted = true;
                        txtAya.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        start();
                    }


                });
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, "setTextTextViews: error=>" + e.getMessage());
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!isStarted) {
                        start();
                    }
                }
            }, 250);

        } else {
            handler.removeCallbacksAndMessages(null);
            hScrollTxt.scrollTo(0, 0);
            Log.d(TAG, "setTextTextViews: not enable");
        }

    }

    private void start() {

        hTextWidth = (int) txtAya.getLayout().getLineWidth(0);
//                Toast.makeText(MainActivity.this, scroll_pos+" px-"+durationAya+" dur", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "hTextWidth: " + hTextWidth);

        curentTime = System.currentTimeMillis();
        if (lastTime < curentTime) {
            handler.removeCallbacksAndMessages(null);
            Log.d(TAG, "onGlobalLayout: currentTime=>" + currentTime);

            if (hTextWidth > hScrollWidth) {
                hTextWidth = hTextWidth - (hScrollWidth - dp2px(context, 32));
                if (!isSpeedSet) {
                    period = ((float) ((duration) - (firstGap + lastGap)) / hTextWidth);
                }

                Log.d(TAG, "onGlobalLayout: period=>" + period);


                if (currentTime > 0) {
                    if (currentTime > firstGap) {
                        currentTime = currentTime - firstGap;
                        final int passedPixel = (int) ((currentTime) / period);
                        lastTime = System.currentTimeMillis() + 100;
                        int all = (((hTextWidth - passedPixel) > 0) ? (hTextWidth - passedPixel) : 1);
                        Log.d(TAG, "onGlobalLayout: currentTime=>" + currentTime + " period=>" + period + " passedPixel=>" + passedPixel + " hTextWidth-passedPixel=>" + (hTextWidth - passedPixel)+ " all=>"+all);
                        for (int i = 0; i < all; i++) {
                            final int finalI = i + passedPixel;

                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Log.d(TAG, "run:indx indexValextra=>" + finalI);
                                    if (!canScrollH) {
                                        hScrollTxt.scrollTo(finalI, 0);
                                    }
                                    if (finalI == (all - 1)) {
                                        if (isLoop) {
                                            setText(text);
                                            handler.removeCallbacksAndMessages(null);
                                        }
                                    }
                                }
                            }, (long) (period * i));
                        }
                    } else {
                        int all = hTextWidth;
                        for (int i = 0; i < all; i++) {
                            final int finalI = i;

                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Log.d(TAG, "run:indx indexVal2000=>" + finalI);
                                    if (!canScrollH) {
                                        hScrollTxt.scrollTo(finalI, 0);
                                    }
                                    if (finalI == (all - 1)) {
                                        if (isLoop) {
                                            setText(text);
                                        }
                                    }
                                }
                            }, (long) ((period * i) + firstGap - currentTime));
                        }
                    }


                } else {
                    int all = hTextWidth;
                    for (int i = 0; i < all; i++) {
                        final int finalI = i;

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Log.d(TAG, "run:indx indexValnormal=>" + finalI);
                                if (!canScrollH) {
                                    hScrollTxt.scrollTo(finalI, 0);
                                    Log.d(TAG, "run:scrollTo=>" + finalI);

                                    if (finalI == (all - 1)) {
                                        if (isLoop) {
                                            setText(text);
                                        }
                                    }
                                }
                            }
                        }, (long) ((period * i) + firstGap + (Math.abs(currentTime))));
                    }

                }

            }
        }
        currentTime = 0;
    }


    public static int dp2px(Context context, float dp) {
        return (int) (dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }


    public RtlMarqueeView(Context context) {
        super(context);
        this.context = context;
        init(context);
    }

    public RtlMarqueeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context);
    }

    public RtlMarqueeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(context);
    }

    public void init(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.rtl_marquee, this, true);
        txtAya = v.findViewById(R.id.ayaContex);
        hScrollTxt = v.findViewById(R.id.hScrollTxt);
        hScrollTxt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // Remove immediately so it only fires once
                hScrollTxt.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                hScrollWidth = hScrollTxt.getWidth();
                Log.d(TAG, "hScrollWidth: " + hScrollWidth);
//                setTextTextViews();

            }

        });


        hScrollTxt.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        canScrollH = true;
                        Log.d(TAG, "onTouch: ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_UP:
                        canScrollH = false;
                        Log.d(TAG, "onTouch: ACTION_UP");
                        break;
                }


                return false;
            }
        });

        txtAya.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        canScrollH = true;
                        Log.d(TAG, "onTouch: ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_UP:
                        canScrollH = false;
                        Log.d(TAG, "onTouch: ACTION_UP");
                        break;
                }


                return false;
            }
        });
    }
}

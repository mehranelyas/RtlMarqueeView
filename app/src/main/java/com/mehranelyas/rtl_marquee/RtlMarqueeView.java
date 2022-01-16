//package com.mehranelyas.rtl_marquee;
//
//import android.content.Context;
//import android.os.Handler;
//import android.util.AttributeSet;
//import android.util.DisplayMetrics;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.ViewTreeObserver;
//import android.widget.HorizontalScrollView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//
//
//public class RtlMarqueeView extends LinearLayout {
//    private HorizontalScrollView hScrollTxt;
//    private TextView txtAya;
//    private boolean canScrollH = false;
//    private int hTextWidth;
//    private int durationAya = 20000;
//    private int currentTime=2500;
//    private int period;
//    int hScrollWidth = 0;
//    long curentTime = 0;
//    long lastTime = 0;
//    private Handler handler = new Handler();
//    private boolean isEnable = true;
//    Context context;
//
//    private static final String TAG = "RtlMarqueeView";
//
//    public RtlMarqueeView(Context context) {
//        super(context);
//        this.context = context;
//        init(context);
//    }
//
//    public RtlMarqueeView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//        this.context = context;
//        init(context);
//    }
//
//    public RtlMarqueeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        this.context = context;
//        init(context);
//    }
//
//
//
//
//    public void init(Context context) {
//        View v = LayoutInflater.from(context).inflate(R.layout.aaa, this, true);
//        txtAya = v.findViewById(R.id.ayaContex);
//        hScrollTxt = v.findViewById(R.id.hScrollTxt);
//        hScrollTxt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                // Remove immediately so it only fires once
//                hScrollTxt.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//                hScrollWidth = hScrollTxt.getWidth();
//                Log.d(TAG, "hScrollWidth: " + hScrollWidth);
//                setTextTextViews();
//
//            }
//
//        });
//    }
//
////    public void init() {
////        setTextTextViews();
////
////    }
//
//    public void setTextTextViews() {
//        canScrollH = false;
//
//            txtAya.setText("");
//            txtAya.setText("لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است. چاپگرها و متون بلکه روزنامه و مجله در ستون و سطرآنچنان که لازم است و برای شرایط فعلی تکنولوژی مورد نیاز و کاربردهای متنوع با هدف بهبود ابزارهای کاربردی می باشد. کتابهای زیادی در شصت و سه درصد گذشته، حال و آینده شناخت فراوان جامعه و متخصصان را می طلبد تا با نرم افزارها شناخت بیشتری را برای طراحان رایانه ای علی الخصوص طراحان خلاقی و فرهنگ پیشرو در زبان فارسی ایجاد کرد. در این صورت می توان امید داشت که تمام و دشواری موجود در ارائه راهکارها و شرایط سخت تایپ به پایان رسد وزمان مورد نیاز شامل حروفچینی دستاوردهای اصلی و جوابگوی سوالات پیوسته اهل دنیای موجود طراحی اساسا مورد استفاده قرار گیرد.");
////            txtAya.setText("asdadadasdasdsdfasdfsdfgsdfgdfgdfjhfgjhhjkukljkghjfghfghdsfgdsfgaserfWERAEWFAW");
//
//
//
//        if (lastTime < curentTime) {
//            handler.removeCallbacksAndMessages(null);
//        }
//        hScrollTxt.scrollTo(0, 0);
//
//
//
//        for (int i = 0; i < 100; i++) {
//            final int finalI = i;
//
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//
//                    hScrollTxt.scrollTo(finalI*5, 0);
//
//                }
//            }, (period * i) + 2000 );
//        }
//
//        if (isEnable) {
//            try {
//                txtAya.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//                    @Override
//                    public void onGlobalLayout() {
//                        txtAya.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//
//                        hTextWidth = (int) txtAya.getLayout().getLineWidth(0);
////                Toast.makeText(MainActivity.this, scroll_pos+" px-"+durationAya+" dur", Toast.LENGTH_SHORT).show();
//                        Log.d(TAG, "hTextWidth: " + hTextWidth);
//
//                        curentTime = System.currentTimeMillis();
//                        if (lastTime < curentTime) {
//                            handler.removeCallbacksAndMessages(null);
//                            Log.d(TAG, "onGlobalLayout: currentTime=>" + currentTime);
//
//                            if (hTextWidth > hScrollWidth) {
//                                hTextWidth = hTextWidth - (hScrollWidth - dp2px(context, 32));
//                                period = ((int) ((durationAya) - 4000) / hTextWidth);
//                                Log.d(TAG, "onGlobalLayout: period=>" + period);
//
//                                if (currentTime > 0) {
//                                    if (currentTime > 2000) {
//                                        currentTime = currentTime - 2000;
//                                        final int passedPixel = ((int) (currentTime) / period);
//                                        lastTime = System.currentTimeMillis() + 100;
//                                        Log.d(TAG, "onGlobalLayout: currentTime=>" + currentTime + " period=>" + period + " passedPixel=>" + passedPixel + " hTextWidth-passedPixel=>" + (hTextWidth - passedPixel));
//                                        for (int i = 0; i < (((hTextWidth - passedPixel) > 0) ? (hTextWidth - passedPixel) : 1); i++) {
//                                            final int finalI = i + passedPixel;
//
//                                            handler.postDelayed(new Runnable() {
//                                                @Override
//                                                public void run() {
//                                                    Log.d(TAG, "run:indx indexValextra=>" + finalI);
//                                                    if (!canScrollH) {
//                                                        hScrollTxt.scrollTo(finalI, 0);
//                                                    }
//                                                }
//                                            }, (period * i));
//                                        }
//                                    } else {
//
//                                        for (int i = 0; i < hTextWidth; i++) {
//                                            final int finalI = i;
//
//                                            handler.postDelayed(new Runnable() {
//                                                @Override
//                                                public void run() {
//                                                    Log.d(TAG, "run:indx indexVal2000=>" + finalI);
//                                                    if (!canScrollH) {
//                                                        hScrollTxt.scrollTo(finalI, 0);
//                                                    }
//                                                }
//                                            }, (period * i) + 2000 - currentTime);
//                                        }
//                                    }
//
//
//                                } else {
//                                    for (int i = 0; i < hTextWidth; i++) {
//                                        final int finalI = i;
//
//                                        handler.postDelayed(new Runnable() {
//                                            @Override
//                                            public void run() {
//                                                Log.d(TAG, "run:indx indexValnormal=>" + finalI);
//                                                if (!canScrollH) {
//                                                    hScrollTxt.scrollTo(finalI, 0);
//                                                    Log.d(TAG, "run:scrollTo=>" + finalI);
//                                                }
//                                            }
//                                        }, (period * i) + 2000 + (Math.abs(currentTime)));
//                                    }
//
//                                }
//
//                            }
//                        }
//                        currentTime = 0;
//                    }
//
//                });
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        } else {
//            handler.removeCallbacksAndMessages(null);
//            hScrollTxt.scrollTo(0, 0);
//            Log.d(TAG, "setTextTextViews: not enable");
//        }
//
//    }
//
//    public static int dp2px(Context context, float dp) {
//        return (int) (dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
//    }
//}

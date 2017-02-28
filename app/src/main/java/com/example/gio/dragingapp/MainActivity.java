package com.example.gio.dragingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  ekranis zomebis gageba
        //=========================================================================

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
//        int height = metrics.heightPixels;
        final int width = metrics.widthPixels;

        //=========================================================================

        tvDrag = (TextView) findViewById(R.id.tvDrag);

        tvDrag.setOnTouchListener(new View.OnTouchListener() {
            float dX, dY , frameX, framXLEft;


            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()){

                    case MotionEvent.ACTION_DOWN:

                        frameX = motionEvent.getX();
                        framXLEft= view.getWidth()-frameX;

                        dX =  motionEvent.getRawX() -view.getX();

                        dY = motionEvent.getRawY() - view.getY() ;

                        break;

                    case MotionEvent.ACTION_MOVE:
                        if((motionEvent.getRawX() + framXLEft)<width  && (motionEvent.getRawX()- frameX) > 0) {
                            view.animate()
                                    .x(motionEvent.getRawX() - dX)
                                    .y(motionEvent.getRawY() - dY)
                                    .setDuration(0)
                                    .start();
                        }
                        break;
                }

                return true;
            }
        });

    }
}

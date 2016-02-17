package com.example.apurv.customanimationdemo;

import android.graphics.drawable.RippleDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class RippleEffectDemo extends AppCompatActivity implements View.OnTouchListener {

    private RippleDrawable rippleDrawable;
    private Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ripple_effect_demo);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button1.setOnTouchListener(this);
        button2.setOnTouchListener(this);
        rippleDrawable = (RippleDrawable) button1.getBackground();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (v.getId()) {
            case R.id.button1:
                /*rippleDrawable.setHotspot(event.getX(), event.getY());
                rippleDrawable.setColor(ColorStateList.valueOf(getResources().getColor(R.color.red)));*/
                break;
            case R.id.button2:
                /*rippleDrawable.setHotspot(event.getX(), event.getY());
                rippleDrawable.setColor(ColorStateList.valueOf(getResources().getColor(R.color.red)));*/
                break;
        }
        return false;
    }


}

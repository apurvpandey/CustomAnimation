package com.example.apurv.customanimationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRipple, buttonReveal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonRipple = (Button) findViewById(R.id.button_activity_Ripple);
        buttonReveal = (Button) findViewById(R.id.button_activity_reveal);
        buttonRipple.setOnClickListener(this);
        buttonReveal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_activity_Ripple:
                Intent intent = new Intent(this, RippleEffectDemo.class);
                startActivity(intent);
                break;

            case R.id.button_activity_reveal:
                Intent intent1 = new Intent(this, RevealEffectDemo.class);
                startActivity(intent1);
                break;
        }
    }
}

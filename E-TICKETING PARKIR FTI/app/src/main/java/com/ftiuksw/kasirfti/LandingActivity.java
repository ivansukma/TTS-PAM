package com.ftiuksw.kasirfti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class LandingActivity extends AppCompatActivity {
    private Button btnorange, btnblue, btncontine;
    private View background, changingbackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        final String[] tema = {""};
        btnblue = findViewById(R.id.btnblue);
        btnorange = findViewById(R.id.btnorange);
        btncontine = findViewById(R.id.btncontinue);
        background = findViewById(R.id.background);
        changingbackground = findViewById(R.id.changingbackground);

        background.setBackgroundResource(R.drawable.bgblue);
        background.setScaleX(3);
        background.setScaleY(3);


        btnorange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tema[0] = "orange";

                changingbackground.animate().scaleX(3).scaleY(3).setDuration(800).start();
                changingbackground.setBackgroundResource(R.drawable.bgorange);

                btnorange.setBackgroundResource(R.drawable.bgorangebutton2);
                btnblue.setBackgroundResource(R.drawable.bgbluebutton);
                btncontine.setTextColor(Color.parseColor("#D5A55D"));

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        background.setScaleX(3);
                        background.setScaleY(3);
                        background.setBackgroundResource(R.drawable.bgorange);
                        changingbackground.setScaleX(0);
                        changingbackground.setScaleY(0);
                    }
                }, 850);
            }
        });
        btnblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tema[0] = "blue";
                changingbackground.animate().scaleX(3).scaleY(3).setDuration(800).start();
                changingbackground.setBackgroundResource(R.drawable.bgblue);

                btnorange.setBackgroundResource(R.drawable.bgorangebutton);
                btnblue.setBackgroundResource(R.drawable.bgbluebutton2);

                btncontine.setTextColor(Color.parseColor("#5D7F98"));

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        background.setScaleX(3);
                        background.setScaleY(3);
                        background.setBackgroundResource(R.drawable.bgblue);
                        changingbackground.setScaleX(0);
                        changingbackground.setScaleY(0);
                    }
                }, 850);
            }
        });

        btncontine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LandingActivity.this, MainActivity.class);
                i.putExtra("tema", tema[0]);
                startActivity(i);
            }
        });
    }
}
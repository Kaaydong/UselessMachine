package com.example.uselessmachine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Switch theSwitch;
    private ConstraintLayout background;
    private Button buttonDo;
    private ProgressBar loading;
    private TextView text;
    private int color;
    private int white;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();
        color = Color.rgb(255,5,5);
        white = Color.rgb(255,255,255);
        button.setBackgroundColor(color);
    }
    public void setListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(10000, 1000) {
                    int tickNumber = 11;

                    @Override


                    public void onTick(long l) {

                        tickNumber--;
                        if (tickNumber % 2 != 0) {
                            button.setBackgroundColor(color);
                            background.setBackgroundColor(white);
                        } else {
                            button.setBackgroundColor(white);
                            background.setBackgroundColor(color);
                        }
                        button.setText(tickNumber + "");
                    }


                    @Override
                    public void onFinish() {
                        int oniichan = 0 / 0;
                        // finish();
                    }
                }.start();
            }
        });

        theSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                new CountDownTimer(2000, 1000) {
                    @Override

                    // cancels the timer if switch is turned off before automatically being turned
                    // off
                    public void onTick(long l) {
                        if (!theSwitch.isChecked()) {
                            cancel();
                        }
                    }

                    @Override
                    public void onFinish() {
                        theSwitch.setChecked(false);
                    }
                }.start();
//                if(isChecked){
//                    Toast.makeText(MainActivity.this, "SWITCH IS ON", Toast.LENGTH_SHORT).show();}
//                else{
//                    Toast.makeText(MainActivity.this,"SWITCH IS OFF", Toast.LENGTH_SHORT).show();
//                }
            }
        });
        buttonDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setVisibility(View.INVISIBLE);
                theSwitch.setVisibility(View.INVISIBLE);
                buttonDo.setVisibility(View.INVISIBLE);
                loading.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                new CountDownTimer(10000,1000)
                {
                    int x = 0;
                    @Override
                    public void onTick(long l) {
                        loading.setProgress(x);
                        x+=10;
                    }

                    @Override
                    public void onFinish() {
                        button.setVisibility(View.VISIBLE);
                        theSwitch.setVisibility(View.VISIBLE);
                        buttonDo.setVisibility(View.VISIBLE);
                        loading.setVisibility(View.INVISIBLE);
                        text.setVisibility(View.INVISIBLE);
                    }
                }.start();

            }
        });

    }

    public void wireWidgets()
    {
            button = findViewById(R.id.button_mian_destruct);
            theSwitch = findViewById(R.id.switch_main_useless);
            background = findViewById(R.id.constraint_main_layout);
            buttonDo = findViewById(R.id.button_main_loadingBar);
            loading = findViewById(R.id.progressBar_main_loading);
            text = findViewById((R.id.textView_main_update));

        }
    }


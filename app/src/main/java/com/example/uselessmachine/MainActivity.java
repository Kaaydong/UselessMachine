package com.example.uselessmachine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Switch theSwitch;
    private ConstraintLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();
        int color = Color.rgb(255,5,5);
        button.setBackgroundColor(color);
    }
    public void setListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(10000, 1000) {
                    int tickNumber = 11;
                    @Override

                    // cancels the timer if switch is turned off before automatically being turned
                    // off



                        public void onTick (long l){

                        tickNumber--;
                            button.setText(tickNumber + "");
                        }


                    @Override
                    public void onFinish() {
                        int oniichan = 0/0;
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
                        if(!theSwitch.isChecked())
                        {
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
    }

    public void wireWidgets()
    {
            button = findViewById(R.id.button_mian_destruct);
            theSwitch = findViewById(R.id.switch_main_useless);
            background = findViewById(R.id.constraint_main_layout);

        }
    }


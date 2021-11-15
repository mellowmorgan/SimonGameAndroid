package com.example.simongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Game newGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void startGame(View v){
        //Toast.makeText(this, "hey", Toast.LENGTH_SHORT).show();
        newGame= new Game();
        startRound();

    }


    public void startRound()
    {
        newGame.getPattern();
        final Handler handler = new Handler();
        Button b = findViewById(R.id.buttonSimon);
       int delay=2000;
        for(int i=0;i<newGame.currentPattern.size();i++){
            if(newGame.currentPattern.get(i)=="yellow"){

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        b.setBackgroundColor(Color.YELLOW);
                    }
                }, delay);
                delay+=2000;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        b.setBackgroundColor(Color.GRAY);
                    }
                }, delay);
                delay+=2000;

            }
            if(newGame.currentPattern.get(i)=="blue"){

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        b.setBackgroundColor(Color.BLUE);
                    }
                }, delay);
                delay+=2000;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        b.setBackgroundColor(Color.GRAY);
                    }
                },delay);
                delay+=2000;

            }
            if(newGame.currentPattern.get(i)=="green"){

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        b.setBackgroundColor(Color.GREEN);
                    }
                }, delay);
                delay+=2000;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        b.setBackgroundColor(Color.GRAY);
                    }
                }, delay);
                delay+=2000;
            }
            if(newGame.currentPattern.get(i)=="red") {

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        b.setBackgroundColor(Color.RED);
                    }
                }, delay);
                delay+=2000;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        b.setBackgroundColor(Color.GRAY);
                    }
                }, delay);
                delay+=2000;
            }

            if (i==newGame.currentPattern.size()-1){
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        testPlayer();
                    }
                }, delay);
            }

        }

    }
    public void testPlayer(){
        final Handler handler = new Handler();
        TextView t = findViewById(R.id.textView);
        t.setText("Copy the color pattern that flashed!");

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 2s = 2000ms
                    Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
                }
            }, 2000*newGame.round);

       // newGame.currentPattern;

    }
}
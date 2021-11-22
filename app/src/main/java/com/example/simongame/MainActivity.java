package com.example.simongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.appcompat.app.*;
import androidx.appcompat.content.res.AppCompatResources;

import android.graphics.drawable.*;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public Game newGame;
    public Handler handler = new Handler();
    public ArrayList<String> userColorsClicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            final Button buttonSimon = (Button) findViewById(R.id.buttonSimon);
            buttonSimon.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    handler.removeCallbacksAndMessages(null);
                    resetColors();

                    userColorsClicked = new ArrayList<String>();
                    newGame= new Game();
                    startRound();
                }
            });



    }
//    public void startGame(View v){
//        userColorsClicked = new ArrayList<String>();
//        newGame= new Game();
//        startRound();
//
//    }
    public void resetColors(){
        //gotta fix this to be gradients default
        TextView bYellowReset = findViewById(R.id.buttonYellow);
        TextView bRedReset = findViewById(R.id.buttonRed);
        TextView bBlueReset = findViewById(R.id.buttonBlue);
        TextView bGreenReset = findViewById(R.id.buttonGreen);
        GradientDrawable gradientDrawableReset1 = (GradientDrawable) bYellowReset.getBackground().mutate();
        gradientDrawableReset1.setColor(Color.YELLOW);
        GradientDrawable gradientDrawableReset2 = (GradientDrawable) bBlueReset.getBackground().mutate();
        gradientDrawableReset2.setColor(Color.BLUE);
        GradientDrawable gradientDrawableReset3 = (GradientDrawable) bGreenReset.getBackground().mutate();
        gradientDrawableReset3.setColor(Color.GREEN);
        GradientDrawable gradientDrawableReset4 = (GradientDrawable) bRedReset.getBackground().mutate();
        gradientDrawableReset4.setColor(Color.RED);

    }

    public void startRound()
    {
        TextView t = findViewById(R.id.textView);
        if (newGame.round==1){
            t.setText("New Game: Round 1");
        }


        newGame.getPattern();
        //final Handler handler = new Handler();
        TextView bYellow = findViewById(R.id.buttonYellow);
        TextView bRed = findViewById(R.id.buttonRed);
        TextView bBlue = findViewById(R.id.buttonBlue);
        TextView bGreen = findViewById(R.id.buttonGreen);
       int delay=1000;
        for(int i=0;i<newGame.currentPattern.size();i++){
            if(newGame.currentPattern.get(i)=="yellow") {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        GradientDrawable gradientDrawable = (GradientDrawable) bYellow.getBackground();
                        gradientDrawable.setColors(new int[] {Color.WHITE,Color.YELLOW});

                        //
                    }


                }, delay);
                delay += 1000;

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        GradientDrawable gradientDrawable = (GradientDrawable) bYellow.getBackground();
                        gradientDrawable.setColors(new int[] {Color.YELLOW,Color.YELLOW});
                    }
                }, delay);
                delay+=1000;

            }
            if(newGame.currentPattern.get(i)=="blue"){

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        GradientDrawable gradientDrawable = (GradientDrawable) bBlue.getBackground();
                        gradientDrawable.setColors(new int[] {Color.parseColor("#26ABFF"),Color.BLUE});
                        //android:startColor="#26abff"
                        //SetColors(new int[] { Color.Blue, Color.Green
                       //
                    }
                }, delay);
                delay+=1000;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        GradientDrawable gradientDrawable = (GradientDrawable) bBlue.getBackground();
                        gradientDrawable.setColors(new int[] {Color.BLUE,Color.BLUE});
                    }
                },delay);
                delay+=1000;

            }
            if(newGame.currentPattern.get(i)=="green"){

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        GradientDrawable gradientDrawable = (GradientDrawable) bGreen.getBackground();
                        gradientDrawable.setColors(new int[] {Color.WHITE,Color.GREEN});

                      //  Color.

                    }
                }, delay);
                delay+=1000;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        GradientDrawable gradientDrawable = (GradientDrawable) bGreen.getBackground();
                        gradientDrawable.setColors(new int[] {Color.GREEN,Color.GREEN});
                    }
                }, delay);
                delay+=1000;
            }
            if(newGame.currentPattern.get(i)=="red") {

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        GradientDrawable gradientDrawable = (GradientDrawable) bRed.getBackground();
                        gradientDrawable.setColors(new int[] {Color.parseColor("#ffcccb"),Color.RED});
                      //
                    }
                }, delay);
                delay+=1000;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        GradientDrawable gradientDrawable = (GradientDrawable) bRed.getBackground();
                        gradientDrawable.setColors(new int[] {Color.RED,Color.RED});
                    }
                }, delay);
                delay+=600;
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
       // final Handler handler = new Handler();
        TextView t = findViewById(R.id.textView);
        userColorsClicked = new ArrayList<String>();
        t.setText("Copy the color pattern that flashed!");

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    String s = userColorsClicked.toString();
                    Boolean isCorrect = false;
                    if(userColorsClicked.size()==newGame.currentPattern.size()){
                        for(int i=0;i<userColorsClicked.size();i++){
                            if(userColorsClicked.get(i)==newGame.currentPattern.get(i)){
                                isCorrect=true;
                            }
                            else{
                                isCorrect=false;
                                break;
                            }
                        }
                    }
                    evaluateRound(isCorrect);
                   // Toast.makeText(MainActivity.this, isCorrect.toString(), Toast.LENGTH_SHORT).show();
                }
            }, 1500*newGame.round);

       // newGame.currentPattern;

    }
    public void evaluateRound(Boolean userEval){
       // final Handler handler = new Handler();
        if(userEval){
            TextView t = findViewById(R.id.textView);
            t.setText("Correct. Get ready for round "+newGame.round);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {


                    startRound();
                }
            }, 1000);

        }
        else{
            TextView t = findViewById(R.id.textView);
            t.setText("Game Over");

        }
    }

    public void setClickedGreen(View v){
        userColorsClicked.add("green");
    }
    public void setClickedYellow(View v){
        userColorsClicked.add("yellow");
    }
    public void setClickedRed(View v){
        userColorsClicked.add("red");

    }

    public void setClickedBlue(View v){
        userColorsClicked.add("blue");
    }

}
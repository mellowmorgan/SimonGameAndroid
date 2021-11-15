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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public Game newGame;
    public ArrayList<String> userColorsClicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void startGame(View v){
        userColorsClicked = new ArrayList<String>();
        newGame= new Game();
        startRound();

    }


    public void startRound()
    {
        TextView t = findViewById(R.id.textView);
        t.setText("");
        newGame.getPattern();
        final Handler handler = new Handler();
        Button b = findViewById(R.id.buttonSimon);
       int delay=1000;
        for(int i=0;i<newGame.currentPattern.size();i++){
            if(newGame.currentPattern.get(i)=="yellow"){

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        b.setBackgroundColor(Color.YELLOW);
                    }
                }, delay);
                delay+=1000;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        b.setBackgroundColor(Color.GRAY);
                    }
                }, delay);
                delay+=1000;

            }
            if(newGame.currentPattern.get(i)=="blue"){

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        b.setBackgroundColor(Color.BLUE);
                    }
                }, delay);
                delay+=1000;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        b.setBackgroundColor(Color.GRAY);
                    }
                },delay);
                delay+=1000;

            }
            if(newGame.currentPattern.get(i)=="green"){

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        b.setBackgroundColor(Color.GREEN);
                    }
                }, delay);
                delay+=1000;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        b.setBackgroundColor(Color.GRAY);
                    }
                }, delay);
                delay+=1000;
            }
            if(newGame.currentPattern.get(i)=="red") {

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        b.setBackgroundColor(Color.RED);
                    }
                }, delay);
                delay+=1000;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        b.setBackgroundColor(Color.GRAY);
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
        final Handler handler = new Handler();
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
        final Handler handler = new Handler();
        if(userEval){
            TextView t = findViewById(R.id.textView);
            t.setText("Correct. Get ready for next round.");
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
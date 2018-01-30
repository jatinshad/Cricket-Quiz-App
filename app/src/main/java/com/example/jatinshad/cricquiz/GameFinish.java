package com.example.jatinshad.cricquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class GameFinish extends AppCompatActivity {

    TextView finalScore;
    TextView high;

    public void playAgain(View view)
    {
        Intent intent1 =new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_finish);

        Intent intent = getIntent();
        int score =intent.getIntExtra("Score ",1);

        finalScore=(TextView)findViewById(R.id.textView4);

        high=(TextView)findViewById(R.id.highestScore);

        finalScore.setText("Your Final Score is "+Integer.toString(score));

        SharedPreferences obj =this.getSharedPreferences("com.example.jatinshad.cricquiz", Context.MODE_PRIVATE);
        //int highestScore=score;
        obj.edit().putInt("highest score",8).apply();
       int  highestScore = obj.getInt("highest score",0);
        if(score>highestScore)
        {
            highestScore=score;
            obj.edit().putInt("highest score",highestScore).apply();
        }
       // high.setText("Highest Score : "+Integer.toString(highestScore));


    }
}

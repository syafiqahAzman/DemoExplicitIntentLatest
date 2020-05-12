package com.myapplicationdev.android.demoexplicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //These request identify who started the second activity
    int requestCodeForSupermanStats = 1;
    int requestCodeForBatmanStats = 2;

    TextView tvSuperman, tvBatman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSuperman = findViewById(R.id.textViewSuperman);
        tvBatman = findViewById(R.id.textViewBatman);

        tvSuperman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create Hero object of Strength 100
                // & technical 60
                Hero superman = new Hero("Superman", 100, 60);
                Intent i = new Intent(MainActivity.this, HeroStatsActivity.class);

                //Put the hero object in intent
                i.putExtra("hero", superman);

                //Start activity with requestCodeForSupermanStats to
                // identify it was started by clicking on Superman
                startActivityForResult(i,requestCodeForSupermanStats);

                //startActivity(i);
            }
        });

        tvBatman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Hero batman = new Hero("batman", 60, 90);
                Intent i = new Intent(MainActivity.this, HeroStatsActivity.class);
                i.putExtra("hero", batman);

                //Start activity with requestCodeForBatmanStats to
                // identify started by clicking Batman
                startActivityForResult(i,requestCodeForBatmanStats);

                //startActivity(i);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Only handles when 2nd activity closed normally
        // and data contains something
        //Will not handle if user press back
        if(resultCode == RESULT_OK) {
            if (data != null) {

                //Get the data passed back from 2nd activity
                String like = data.getStringExtra("like");
                String statement = "";

                //If the activity started when clicked on Superman,
                // create corresponding String
                if(requestCode == requestCodeForSupermanStats) {
                    statement = "You "+ like + " Superman";
                }

                //If the activity started when clicked on Batman,
                // create corresponding String
                if (requestCode == requestCodeForBatmanStats) {
                    statement = "You " + like + " Batman";
                }

                Toast.makeText(MainActivity.this, statement, Toast.LENGTH_LONG).show();
            }
        }
    }
}

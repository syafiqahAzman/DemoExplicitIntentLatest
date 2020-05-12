package com.myapplicationdev.android.demoexplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HeroStatsActivity extends AppCompatActivity {

    TextView tvName, tvStrength, tvTech;
    Button btnLike, btnDislike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);

        // Get the Intent
        Intent i = getIntent();

        // Get the Hero object from the MainActivity
        Hero hero = (Hero) i.getSerializableExtra("hero");

        tvName = findViewById(R.id.textViewName);
        tvStrength = findViewById(R.id.textViewStrength);
        tvTech = findViewById(R.id.textViewTechnicalProwess);

        btnLike = findViewById(R.id.buttonLike);
        btnDislike = findViewById(R.id.buttonDislike);

        //Use getters of object to get the attributes
        tvName.setText(hero.getName());
        tvStrength.setText("Strength: " + hero.getStrength());
        tvTech.setText("Technical: " + hero.getTechnicalProwess());

        //When button Like is clicked, set the results
        // accordingly and finish() to close this act
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("like", "like");

                //Set result to RESULT_OK to indicate normal
                // response and pass in the intent containing the like
                setResult(RESULT_OK, i);
                finish();
            }
        });

        //When button Dislike is clicked, set the results accordingly
        // and finish() to close the activity
        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("like", "dislike");

                //Set the result to RESULT_OK to indicate normal
                //response and pass in the intent containing the dislike
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}

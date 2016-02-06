package com.example.eric.crunchtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class CrunchedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crunched);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //do calorie conversions here
        Intent intent = getIntent();
        int numToConvert = Integer.parseInt(intent.getStringExtra(MainActivity.EXTRA_NUM));
        boolean pushups_bool = getIntent().getExtras().getBoolean("pushups_bool");
        boolean situps_bool = getIntent().getExtras().getBoolean("situps_bool");
        boolean jacks_bool = getIntent().getExtras().getBoolean("jacks_bool");
        boolean jogging_bool = getIntent().getExtras().getBoolean("jogging_bool");
        int caloriesBurned = 0;
        int equivPushups = 0;
        int equivSitups = 0;
        int equivJacks = 0;
        int equivJogging = 0;
        if(pushups_bool) {
            caloriesBurned = (numToConvert*100)/350;
            equivPushups = numToConvert;
            equivSitups = caloriesBurned*200/100;
            equivJacks = caloriesBurned*10/100;
            equivJogging = caloriesBurned*12/100;
        }
        else if (situps_bool) {
            caloriesBurned = (numToConvert*100)/200;
            equivPushups = caloriesBurned*350/100;
            equivSitups = numToConvert;
            equivJacks = caloriesBurned*10/100;
            equivJogging = caloriesBurned*12/100;
        }
        else if (jacks_bool) {
            caloriesBurned = (numToConvert*100)/10;
            equivPushups = caloriesBurned*350/100;
            equivSitups = caloriesBurned*200/100;
            equivJacks = numToConvert;
            equivJogging = caloriesBurned*12/100;
        }
        else if (jogging_bool) {
            caloriesBurned = (numToConvert*100)/12;equivPushups = 0;
            equivPushups = caloriesBurned*350/100;
            equivSitups = caloriesBurned*200/100;
            equivJacks = caloriesBurned*10/100;
            equivJogging = numToConvert;
        }
        TextView calorieView = (TextView) findViewById(R.id.calorieView);
        calorieView.setText(caloriesBurned+"");
        TextView pushupsView = (TextView) findViewById(R.id.textView5);
        pushupsView.setText(equivPushups+"");
        TextView situpsView = (TextView) findViewById(R.id.textView7);
        situpsView.setText(equivSitups+"");
        TextView jacksView = (TextView) findViewById(R.id.textView6);
        jacksView.setText(equivJacks+"");
        TextView joggingView = (TextView) findViewById(R.id.textView8);
        joggingView.setText(equivJogging+"");
    }

}

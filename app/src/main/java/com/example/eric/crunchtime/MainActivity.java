package com.example.eric.crunchtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_NUM = "com.example.eric.crunchtime.NUM";
    public static boolean pushups_bool = false;
    public static boolean situps_bool = false;
    public static boolean jacks_bool = false;
    public static boolean jogging_bool = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RadioButton pushupsrb = (RadioButton) findViewById(R.id.radioButton);
        RadioButton situpsrb = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton jumpingjacksrb = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton joggingrb = (RadioButton) findViewById(R.id.radioButton4);
        final TextView minutesOrReps = (TextView) findViewById(R.id.textView2);

        View.OnClickListener pushups_radio_listener = null;
        View.OnClickListener situps_radio_listener = null;
        View.OnClickListener jacks_radio_listener = null;
        View.OnClickListener minutes_radio_listener = null;

        pushups_radio_listener = new View.OnClickListener() {
            public void onClick(View v) {
                pushups_bool = true;
                situps_bool = false;
                jacks_bool = false;
                jogging_bool = false;
                minutesOrReps.setText("reps");
            }
        };
        situps_radio_listener = new View.OnClickListener() {
            public void onClick(View v) {
                situps_bool = true;
                jacks_bool = false;
                pushups_bool = false;
                jogging_bool = false;
                minutesOrReps.setText("reps");
            }
        };
        jacks_radio_listener = new View.OnClickListener() {
            public void onClick(View v) {
                jacks_bool = true;
                situps_bool = false;
                pushups_bool = false;
                jogging_bool = false;
                minutesOrReps.setText("minutes");
            }
        };
        minutes_radio_listener = new View.OnClickListener() {
            public void onClick(View v) {
                jogging_bool = true;
                situps_bool = false;
                jacks_bool = false;
                pushups_bool = false;
                minutesOrReps.setText("minutes");
            }
        };
        joggingrb.setOnClickListener(minutes_radio_listener);
        pushupsrb.setOnClickListener(pushups_radio_listener);
        situpsrb.setOnClickListener(situps_radio_listener);
        jumpingjacksrb.setOnClickListener(jacks_radio_listener);
    }

    //when crunch is clicked, switch views
    public void switchToCrunched(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, CrunchedActivity.class);
        EditText editText = (EditText) findViewById(R.id.numRepsOrMinutes);
        String numToConvert = editText.getText().toString();
        if (numToConvert.matches("")) {
            Toast.makeText(this, "Please enter an amount of exercise!", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        if (radioGroup.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(this, "Please choose a type of exercise!", Toast.LENGTH_SHORT).show();
            return;
        }
        intent.putExtra(EXTRA_NUM, numToConvert);
        intent.putExtra("pushups_bool", pushups_bool);
        intent.putExtra("situps_bool", situps_bool);
        intent.putExtra("jacks_bool", jacks_bool);
        intent.putExtra("jogging_bool", jogging_bool);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.button_counter_dupree;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //in every single class that i make i should make a private tag so that i dont have to keep calling it
    //like an identifier
    //now i can search at logcat to only work with my one particular class cuts out a lot of noise
    //Get into the habit of doing this for every class!!!!!!

    private String TAG = "MainActivity";

    private Button incButton;

    private Button decButton;

    private Button clearButton;

    private TextView display;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"I entered into onCreate()");

        //what is my display
        display = findViewById(R.id.displayId);

        incButton = findViewById(R.id.incButtonId);
        incButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hello World", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "********************************** I pressed the inc button *******************************");

                //increment count here
               incrementCounter();
            }
        });

        decButton = findViewById(R.id.displayId);
        decButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "********************************* I pressed the dec button ********************************");

                //decrement count here
                decrementCounter();
            }
        });

        clearButton = findViewById(R.id.displayId);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "******************************** I pressed the clear button ********************************");

                //clear the count here
                clearCounter();
            }
        });

    }

    //make a private method for your increment
    private void incrementCounter() {
        //here is where i write my code for this to work
        //i want to make my value and integer and grab the value from the textView on activity_main.xml
        //changed the name from textView to displayId
        //google how to take a string into an int - Integer.valueOf
       int currentValue = Integer.valueOf(display.getText().toString());

        //what do we want to do with currentValue??
        //we want to increment it by 1
        //below are some of the ways all work just different solutions
        //currentValue++;
        //currentValue+=1;
        //currentValue = currentValue +1;

        currentValue++;

        //now we want to turn it back into a string and back into display
        display.setText(String.valueOf(currentValue));


    }


    private void decrementCounter(){
        int currentValue = Integer.valueOf(display.getText().toString());

        currentValue--;

        display.setText(String.valueOf(currentValue));
    }


    private void clearCounter(){
        int currentValue = Integer.valueOf(display.getText().toString());

        currentValue = 0;

        display.setText(String.valueOf(currentValue));
    }

    //this is how we tell the app that whenever we change the screen that it will stay the same
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        String counterValue = display.getText().toString();
        outState.putString("display", counterValue);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String counterValue = savedInstanceState.getString("display");
        display.setText(counterValue);
    }

    //these are the life cycles of the app
    //i stands for info so for info messages this is what you use
    //good to use log statements to see what you are doing
    //by viewing logcat you are able to see what is going, what is working and what isn't
    //logcat is a good place to look at when you are debugging
    //remember that we are developing for mobile devices that are running more than one thing
    //things are constantly going from the foreground and background
    //we have to write code for whenever our app is pushed to the background what do we need to do


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "I entered into onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "I entered into onResume()");

    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "I entered into onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "I entered into onStop()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "I entered into onRestart()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "I entered into onDestroy()");

    }
}
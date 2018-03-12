package com.example.tomek.task_2_managment_data_states;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String tag="tag";
    EditText editText1;
    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.et1);
        editText2 = findViewById(R.id.et3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(getResources().getString(R.string.LOGCAT_TAG), "SA onResume: I'm being called");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(getResources().getString(R.string.LOGCAT_TAG), "SA onRestart: I'm being called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(getResources().getString(R.string.LOGCAT_TAG), "SA onDestroy: I'm being called");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(getResources().getString(R.string.LOGCAT_TAG), "SA onStop: I'm being called");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(getResources().getString(R.string.LOGCAT_TAG), "SA onPause: I'm being called");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(tag,editText1.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        editText2.setText(savedInstanceState.getString(tag, ""));
    }
}

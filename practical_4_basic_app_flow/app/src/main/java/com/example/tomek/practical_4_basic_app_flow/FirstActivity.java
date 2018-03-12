package com.example.tomek.practical_4_basic_app_flow;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import javax.security.auth.login.LoginException;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Log.i(getResources().getString(R.string.LOGCAT_TAG), "FA onCreate: I'm being called");
    }

    public void toSecond(View view) {
        Log.i(getResources().getString(R.string.LOGCAT_TAG), "toSecond: clicked on me");
        EditText text = (EditText) findViewById(R.id.firstedit);

        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        intent.putExtra("randint", RandSum());
        intent.putExtra("msg", text.getText().toString());
        startActivityForResult(intent, 1);
    }

    public int RandSum(){
        Random rand = new Random();
        int result=0;
        for (int i = 0;i<10000;i++)
        {
            result+=rand.nextInt();
        }
        return result;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            String result = data.getStringExtra("msg");
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

            EditText text = (EditText) findViewById(R.id.firstedit);
            text.getText().clear();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(getResources().getString(R.string.LOGCAT_TAG), "FA onResume: I'm being called");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(getResources().getString(R.string.LOGCAT_TAG), "FA onRestart: I'm being called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(getResources().getString(R.string.LOGCAT_TAG), "FA onDestroy: I'm being called");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(getResources().getString(R.string.LOGCAT_TAG), "FA onStop: I'm being called");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(getResources().getString(R.string.LOGCAT_TAG), "FA onPause: I'm being called");

    }
}

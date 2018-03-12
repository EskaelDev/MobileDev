package com.example.tomek.task_3_wordking_with_strings_styles_xml;

import android.app.Activity;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonCall(View view) {
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Random random = new Random();

        int pos = random.nextInt(5)+1;
        String[] fruits_array = getResources().getStringArray(R.array.fruits);

        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this, fruits_array[pos], Toast.LENGTH_SHORT).show();
        }
        if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, fruits_array[pos], Toast.LENGTH_SHORT).show();
        }
    }
}

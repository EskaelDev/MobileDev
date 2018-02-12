package com.example.tomek.practical_3_designing_layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lifeClick(View view){
        Toast.makeText(this, "LifeLog", Toast.LENGTH_SHORT).show();
    }

    public void taskClick(View view) {
        Toast.makeText(this, "Tasks", Toast.LENGTH_SHORT).show();
    }

    public void homeClick(View view) {
        Toast.makeText(this, "Get Me Home", Toast.LENGTH_SHORT).show();
    }

    public void rewardsClick(View view) {
        Toast.makeText(this, "Rewards", Toast.LENGTH_SHORT).show();
    }

    public void remindClick(View view) {
        Toast.makeText(this, "Reminders", Toast.LENGTH_SHORT).show();
    }

    public void profileClick(View view) {
        Toast.makeText(this, "My Profile", Toast.LENGTH_SHORT).show();
    }
}

package com.example.tomek.practical_4_basic_app_flow;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

    }

    public void toSecond(View view) {
        EditText text = (EditText) findViewById(R.id.firstedit);

        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        intent.putExtra("msg", text.getText().toString());
        startActivityForResult(intent, 1);
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


}

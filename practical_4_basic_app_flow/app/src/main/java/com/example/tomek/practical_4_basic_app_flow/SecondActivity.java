package com.example.tomek.practical_4_basic_app_flow;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = (TextView) findViewById(R.id.secondtext);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
        textView.setText(msg);
    }

    public void toFirst(View view) {
        Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
        TextView textView = findViewById(R.id.secondtext);

        intent.putExtra("msg", textView.getText().toString());
        setResult(Activity.RESULT_OK, intent    );
        finish();

    }
}

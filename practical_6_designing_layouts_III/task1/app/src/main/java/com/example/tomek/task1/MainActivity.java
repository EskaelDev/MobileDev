package com.example.tomek.task1;

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

    @Override
    protected void onResume() {
        super.onResume();
    }



    public void vertical_click(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.bl:
                        Toast.makeText(MainActivity.this, "Bottom left clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tr:
                        Toast.makeText(MainActivity.this, "Top right clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.br:
                        Toast.makeText(MainActivity.this, "Bottom right clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tl:
                        Toast.makeText(MainActivity.this, "Top left clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.mid:
                        Toast.makeText(MainActivity.this, "Middle clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tm:
                        Toast.makeText(MainActivity.this, "Top middle clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bm:
                        Toast.makeText(MainActivity.this, "Bottom middle clicked", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

}

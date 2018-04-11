package com.example.tomek.practical_lab_07_data_persistence_i;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class SharedPref_01 extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref_01);

        seekBar = findViewById(R.id.seek);
        textView = findViewById(R.id.textview);
        editText = findViewById(R.id.edittext);
        button = findViewById(R.id.button);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(!(preferences.contains("text")||preferences.contains("fontsize")))
        {
            seekBar.setProgress(25);
            editText.setTextSize(seekBar.getProgress());
            textView.setText("Font size: "+String.valueOf(seekBar.getProgress()));
        }
        else {
            String savedText = preferences.getString("text", "");
            int savedSize = preferences.getInt("fontsize", 25);

            editText.setText(savedText);
            seekBar.setProgress(savedSize);

            editText.setTextSize(seekBar.getProgress());
            textView.setText("Font size: "+String.valueOf(editText.getTextSize()));
        }



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                editText.setTextSize(seekBar.getProgress());
                textView.setText("Font size: "+String.valueOf(editText.getTextSize()));

                Log.i("FONTSIZE", "SeekBar progress: "+seekBar.getProgress());
                Log.i("FONTSIZE", "EditText text size: "+editText.getTextSize());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void Save(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("text",editText.getText().toString());
        editor.putInt("fontsize",seekBar.getProgress());
        editor.apply();
    }

    public void next(View view) {
        Intent intent = new Intent(this, intern_extern_store.class);
        startActivity(intent);
        finish();
    }
}

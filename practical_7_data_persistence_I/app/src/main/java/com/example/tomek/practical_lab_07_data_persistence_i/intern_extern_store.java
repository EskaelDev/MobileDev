package com.example.tomek.practical_lab_07_data_persistence_i;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class intern_extern_store extends AppCompatActivity {

    private static final String INTERNALFILENAME = "Internal save";
    private static final String EXTERNALFILENAME = "External save";

    EditText internEditText;
    EditText externEditText;

    Button save2;
    Button load2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intern_extern_store);

        internEditText = findViewById(R.id.internal);
        externEditText = findViewById(R.id.external);

        save2 = findViewById(R.id.save2);
        load2 = findViewById(R.id.load2);
    }

    public void save2(View view) {

        FileOutputStream fileOutS;
        ObjectOutputStream objOutS;
        DataOutputStream dataOutputStream;
        try {
            fileOutS = this.openFileOutput(INTERNALFILENAME, this.MODE_PRIVATE);
            dataOutputStream = new DataOutputStream(fileOutS);

            dataOutputStream.writeUTF(internEditText.getText().toString());

            dataOutputStream.close();
            fileOutS.close();
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }



    }

    public void load2(View view) {
        FileInputStream fis;
        ObjectInputStream ois;
        DataInputStream dataInputStream;
        try {
            fis = this.openFileInput(INTERNALFILENAME);
            dataInputStream = new DataInputStream(fis);

            String text = dataInputStream.readUTF();

            internEditText.setText(text);

            fis.close();


            Toast.makeText(this, "Loaded", Toast.LENGTH_SHORT).show();
        } catch (IOException  e) {
            e.printStackTrace();
        }

    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }


    public File getPublicAlbumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e("FILE", "Directory not created");
        }
        return file;
    }


}

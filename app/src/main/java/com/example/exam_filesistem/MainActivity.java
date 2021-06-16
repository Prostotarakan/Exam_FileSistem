package com.example.exam_filesistem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {


    private String file1 ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        file1=Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public void Button_file1_click (View view) {

        Intent intent = new Intent(MainActivity.this, FileSis.class);
        intent.putExtra("res", file1);
        intent.putExtra("flag",1);
        startActivity(intent);

    }
}
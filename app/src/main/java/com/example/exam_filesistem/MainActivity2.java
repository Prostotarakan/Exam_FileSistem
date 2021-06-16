package com.example.exam_filesistem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class MainActivity2 extends AppCompatActivity {

    private String buff = "";
    private String file1 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        file1 = getIntent().getExtras().getString("file1");
        TextView TB = (TextView) findViewById(R.id.text_file1);
        TB.setText(file1);

    }


    public void Button_file1_click (View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }


    public void Button_file2_click (View view) {

        Intent intent = new Intent(MainActivity2.this, FileSis.class);
        intent.putExtra("res", Environment.getExternalStorageDirectory().getAbsolutePath());
        intent.putExtra("file1", file1);
        intent.putExtra("flag",2);
        startActivity(intent);

    }
}
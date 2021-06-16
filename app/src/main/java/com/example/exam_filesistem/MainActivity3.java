package com.example.exam_filesistem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class MainActivity3 extends AppCompatActivity {

    private String file1s = "";
    private String file2s = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        file1s = getIntent().getExtras().getString("file1");
        file2s = getIntent().getExtras().getString("file2");
        TextView TB = (TextView) findViewById(R.id.text_file1);
        TB.setText(file1s);
        TB = (TextView) findViewById(R.id.text_file2);
        TB.setText(file2s);

    }

    public void Button_file1_click (View view) {
        Intent intent = new Intent(MainActivity3.this, MainActivity.class);
        startActivity(intent);
    }

    public void Button_file2_click (View view) {
        Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
        startActivity(intent);
    }

    public void Button_start_click (View view) {
        int flag=0;
        file1s = getIntent().getExtras().getString("file1");
        file2s = getIntent().getExtras().getString("file2");
        if (flag==0)
        {
            File file2 = getExternalFilesDir(file2s);
            File file1 = getExternalFilesDir(file1s);

            if (file1.isDirectory()) {
                String[] file1list =  file1.list();
                String[] file2list =  file2.list();
                int f1 = file1list.length;
                int f2 = file2list.length;

                String info;
                TextView res = (TextView) findViewById(R.id.text_info);
                res.clearComposingText();
                res.setText("");

                for (int i = 0; i < f1; i++) {
                    for (int j = 0; j < f2; j++) {
                        if (file1list[i].equalsIgnoreCase(file2list[j])) {

                            info = String.format(" %1$s \n", file1list[i]);
                            res.append(info);
                        }
                    }


                }

                if (res.length()==0)
                {
                    res.setText("Дубликатов не найдено");
                }
            }


        }

    }
}
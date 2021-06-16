package com.example.exam_filesistem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.File;

public class FileSis extends AppCompatActivity {

    private String buff = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_sis);
        String ctext = getIntent().getExtras().getString("res");
        buff=ctext;

        RadioOnChange();

        RadioGroup RG = (RadioGroup) findViewById(R.id.Radio);

        RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FindChange(group, checkedId);
            }
        });

    }

    public void FindChange(RadioGroup group, int Id) {

        RadioButton B = group.findViewById(Id);

        String str = (String) B.getText();
        buff=buff+"/"+str;

        RadioOnChange ();

    }



    public void RadioOnChange ( ) {

        TextView TB = (TextView) findViewById(R.id.text_help1);
        TB.setText(buff);

        File file1 = getExternalFilesDir(buff);


        if (file1.isDirectory()) {
            String[] file1list = file1.list();

            RadioGroup RG = (RadioGroup) findViewById(R.id.Radio);
            RG.removeAllViews();

            if (file1list.length > 0) {
                int f1 = file1list.length;
                String info;
                RadioButton rg;

                for (int i = 0; i < f1; i++) {
                    rg = new RadioButton(this);
                    rg.setText(file1list[i]);
                    File file2 = getExternalFilesDir(buff+"/"+file1list[i]);
                    if (file2.isFile()){
                        rg.setClickable(false);
                    }
                    RG.addView(rg, i);
                }
            }

        }


    }

    public void Button_back_click (View view) {

        File file1 = getExternalFilesDir(buff);
        //сделать проверку на директорию...
        file1=file1.getParentFile();
        if (file1.isDirectory()) {
            buff = file1.toString();
            RadioOnChange();
        }

    }

    public void Button_finish_click (View view) {
        File file2 = getExternalFilesDir(buff);
        if (file2.isDirectory()){
            int Flag = getIntent().getExtras().getInt("flag");

            if (Flag==1) {
                Intent intent = new Intent(FileSis.this, MainActivity2.class);
                TextView TB = (TextView) findViewById(R.id.text_help1);
                intent.putExtra("file1", TB.getText());
                startActivity(intent);
            }
            if (Flag==2){
                String file1 = getIntent().getExtras().getString("file1");
                Intent intent = new Intent(FileSis.this, MainActivity3.class);
                TextView TB = (TextView) findViewById(R.id.text_help1);
                intent.putExtra("file2", TB.getText());
                intent.putExtra("file1", file1);
                startActivity(intent);
            }
        }

    }
    public void Button_close_click (View view) {
        int Flag = getIntent().getExtras().getInt("flag");
        if (Flag==1) {
            Intent intent = new Intent(FileSis.this, MainActivity.class);
            startActivity(intent);
        }
        if (Flag==2){
            String file1 = getIntent().getExtras().getString("file1");
            Intent intent = new Intent(FileSis.this, MainActivity2.class);
            intent.putExtra("file1", file1);
            startActivity(intent);
        }

    }
}
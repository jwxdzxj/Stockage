package com.dzxj.stockage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {

    private EditText editText;
    private Button btn_save;
    private Button btn_show;
    private TextView textView;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preferences);

        editText=findViewById(R.id.et1);
        btn_save=findViewById(R.id.btn_save);
        btn_show=findViewById(R.id.btn_show);
        textView=findViewById(R.id.tv1);
        
        //保存数据
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                fileSave(str);
                Toast.makeText(FileActivity.this, "保存成功！",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //显示操作
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=fileRead();
                textView.setText(str);
                Toast.makeText(FileActivity.this,"显示成功！",
                        Toast.LENGTH_SHORT).show();
            }

        });
    }

    //封装一个方法将从控件的内容写到文件中
    private void fileSave(String str) {
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=openFileOutput("Stockage.txt",MODE_PRIVATE);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //封装一个方法将从文件的内容读到控件中
    private String fileRead() {
        FileInputStream fileInputStream=null;

        try {
            fileInputStream=openFileInput("Stockage.txt");
            byte[] bytes=new byte[1024];
            StringBuffer sb=new StringBuffer("");
            int len=0;
            while((len=fileInputStream.read(bytes))>0){
                sb.append(new String(bytes,0,len));
            }
            return sb.toString();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}


package com.dzxj.stockage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_share;
    private Button btn_file;
    private Button btn_sql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_share=findViewById(R.id.btn_share);
        btn_file=findViewById(R.id.btn_file);
        btn_sql=findViewById(R.id.btn_sql);
        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, SharePreferencesActivity.class);
                startActivity(intent);
            }
        });
        btn_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, FileActivity.class);
                startActivity(intent);
            }
        });
        btn_sql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, SqliteActivity.class);
                startActivity(intent);
            }
        });
    }
}

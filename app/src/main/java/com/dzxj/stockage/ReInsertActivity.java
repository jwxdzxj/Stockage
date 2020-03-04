package com.dzxj.stockage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReInsertActivity extends AppCompatActivity {

    private Button btn_reinsert;
    private Button btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_insert);
        btn_reinsert=findViewById(R.id.btn_reinsert);
        btn_back=findViewById(R.id.btn_back);
        btn_reinsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ReInsertActivity.this,InsertDateActivity.class);
                startActivity(intent);
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ReInsertActivity.this,SqliteActivity.class);
                startActivity(intent);
            }
        });
    }
}

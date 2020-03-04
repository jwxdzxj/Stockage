package com.dzxj.stockage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharePreferencesActivity extends AppCompatActivity {

    private EditText editText;
    private Button btn_save;
    private Button btn_show;
    private TextView textView;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preferences);

        editText=findViewById(R.id.et1);
        btn_save=findViewById(R.id.btn_save);
        btn_show=findViewById(R.id.btn_show);
        textView=findViewById(R.id.tv1);

        sharedPreferences=this.getSharedPreferences("DZXJ",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        //读取数据
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("dataInfo",editText.getText().toString());
                editor.commit();
                Toast.makeText(SharePreferencesActivity.this,"保存成功！",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //显示操作
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(sharedPreferences.getString("dataInfo","没有读取到数据"));
                Toast.makeText(SharePreferencesActivity.this,"显示成功！",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}

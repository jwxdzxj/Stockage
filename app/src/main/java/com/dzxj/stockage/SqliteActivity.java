package com.dzxj.stockage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dzxj.stockage.sqlite.DBDataBase;
import com.dzxj.stockage.sqlite.UserDAO;

public class SqliteActivity extends AppCompatActivity {

    private UserDAO dao;
    private Button btn_insert;
    private Button btn_delete;
    private Button btn_update;
    private Button btn_select;
    private EditText editText;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        btn_insert=findViewById(R.id.btn_insert);
        btn_delete=findViewById(R.id.btn_delete);
        btn_update=findViewById(R.id.btn_update);
        btn_select=findViewById(R.id.btn_select);
        editText=findViewById(R.id.edit_delete);
        textView=findViewById(R.id.tv);

        //创建数据 DBDataBase对象
        DBDataBase helper=new DBDataBase(SqliteActivity.this);
        //通过helper对象创建数据
        SQLiteDatabase db=helper.getWritableDatabase();
        dao=new UserDAO(SqliteActivity.this);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SqliteActivity.this,InsertDateActivity.class);
                startActivity(intent);
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID=editText.getText().toString().trim();
                int id=Integer.parseInt(ID);
                dao.deleteData(id);
            }
        });
        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.selectData(textView);
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SqliteActivity.this,UpdateDateActivity.class);
                startActivity(intent);
            }
        });
    }
}

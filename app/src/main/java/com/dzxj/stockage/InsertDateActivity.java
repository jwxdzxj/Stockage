package com.dzxj.stockage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dzxj.stockage.sqlite.UserDAO;

public class InsertDateActivity extends AppCompatActivity {

    private Button btn;
    private EditText eta;
    private EditText etb;
    private EditText etc;
    private EditText etd;
    private EditText ete;
    private EditText etf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_date);

        btn=findViewById(R.id.btn);
        eta=findViewById(R.id.eta);
        etb=findViewById(R.id.etb);
        etc=findViewById(R.id.etc);
        etd=findViewById(R.id.etd);
        ete=findViewById(R.id.ete);
        etf=findViewById(R.id.etf);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idString=eta.getText().toString().trim();
                int id=0;
                String name=etb.getText().toString().trim();
                String pwd1=etc.getText().toString().trim();
                String pwd2=etd.getText().toString().trim();
                String tel=ete.getText().toString().trim();
                String address=etf.getText().toString().trim();
                Intent intent=new Intent(InsertDateActivity.this,ReInsertActivity.class);
                if (idString.equals("")) {
                    Toast.makeText(InsertDateActivity.this,
                            "ID号不能为空",Toast.LENGTH_SHORT).show();
                }
                else{
                    id=Integer.parseInt(idString);
                }
                if (!TextUtils.isEmpty(pwd1)&&!TextUtils.isEmpty(pwd2)&&TextUtils.equals(pwd1,pwd2)){
                    UserDAO dao=new UserDAO(InsertDateActivity.this);
                    dao.insertData(id,name,pwd1,tel,address);
                    startActivity(intent);
                }else if (TextUtils.isEmpty(pwd1)){
                    Toast.makeText(InsertDateActivity.this,
                            "密码不能为空",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(InsertDateActivity.this,
                            "两次密码不相同",Toast.LENGTH_SHORT).show();
                }
                if(name.equals("")){
                    Toast.makeText(InsertDateActivity.this,
                            "用户名不能为空",Toast.LENGTH_SHORT).show();
                }
                if(name.equals("")){
                    Toast.makeText(InsertDateActivity.this,
                            "电话号码不能为空",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

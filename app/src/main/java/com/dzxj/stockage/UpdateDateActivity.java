package com.dzxj.stockage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dzxj.stockage.sqlite.UserDAO;

public class UpdateDateActivity extends AppCompatActivity {

    private EditText username;
    private EditText oldpwd;
    private EditText newpwd;
    private EditText again;
    private Button btn_qr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_date);
        username=findViewById(R.id.username);
        oldpwd=findViewById(R.id.oldpwd);
        newpwd=findViewById(R.id.newpwd);
        again=findViewById(R.id.again);
        btn_qr=findViewById(R.id.btn_qr);
        btn_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=username.getText().toString().trim();
                String oldpassword=oldpwd.getText().toString().trim();
                String newpassword=newpwd.getText().toString().trim();
                String again_password=again.getText().toString().trim();
                Intent intent=new Intent(UpdateDateActivity.this,SqliteActivity.class);
                if (TextUtils.isEmpty(oldpassword)){
                    Toast.makeText(UpdateDateActivity.this,
                            "旧密码不能为空",Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(newpassword)){
                    Toast.makeText(UpdateDateActivity.this,
                            "新密码不能为空",Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(again_password)){
                    Toast.makeText(UpdateDateActivity.this,
                            "请确认密码",Toast.LENGTH_SHORT).show();
                }else if (TextUtils.equals(oldpassword,newpassword)){
                    Toast.makeText(UpdateDateActivity.this,
                            "旧密码不能与新密码相同",Toast.LENGTH_SHORT).show();
                }else if (!TextUtils.equals(again_password,newpassword)){
                    Toast.makeText(UpdateDateActivity.this,
                            "密码不一致",Toast.LENGTH_SHORT).show();
                }else{
                    UserDAO dao=new UserDAO(UpdateDateActivity.this);
                    dao.updateData(newpassword,name);
                    startActivity(intent);
                }

            }
        });


    }
}

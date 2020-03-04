package com.dzxj.stockage.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.TextView;

/**
 * 在DAO类进行增删改查的操作
 */
public class UserDAO {
    DBDataBase helper;
    //构造函数
    public UserDAO(Context context){
        //创建DBDataBase对象
        helper=new DBDataBase(context);
    }

    //向tb_user添加数据
    public void insertData(int id,String name,String pwd,String tel,String address){
        SQLiteDatabase db=helper.getWritableDatabase();
        String sql="insert into tb_user(id,name,password,tel,address) values(?,?,?,?,?)";
        db.execSQL(sql,new Object[]{id,name,pwd,tel,address});
        //数据库属于系统资源，需要及时关闭数据库
        db.close();
    }
    //根据id删除数据
    public void deleteData(int id){
        SQLiteDatabase db=helper.getWritableDatabase();
        String sql="delete from tb_user where id=?";
        db.execSQL(sql,new Object[]{id});
        //数据库属于系统资源，需要及时关闭数据库
        db.close();
    }

    //根据name修改数据
    public void updateData(String pwd,String name){
        SQLiteDatabase db=helper.getWritableDatabase();
        String sql="update tb_user set password=? where name=?";
        db.execSQL(sql,new Object[]{pwd,name});
        //数据库属于系统资源，需要及时关闭数据库
        db.close();
    }

    //查询ta_user所有数据
    public void selectData(TextView textView) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "select * from tb_user";
        Cursor cursor=db.rawQuery(sql,null);

        //使用Cursor对象遍历每行数据
        String textview_data = "";
        while(cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String password = cursor.getString(2);
            String tel = cursor.getString(3);
            String address = cursor.getString(4);
            textview_data = textview_data + "\n" + id + ";" + name + ";" + password + ";" + tel + ";" + address;
        }
        textView.setText(textview_data);
        db.close();
    }
}

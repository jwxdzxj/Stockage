package com.dzxj.stockage.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBDataBase extends SQLiteOpenHelper {
    /* @param context 上下文对象
     * @param name 数据库名称
     * @param factory 游标对象
     * @param version 数据库的版本*/
    //调整构造函数
    public DBDataBase(@Nullable Context context) {
        super(context,Constant.DATABASE_NAME, null, Constant.VERSION_CODE);
    }

    //这个方法是创建数据库的回调方法
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("onCreate","onCreate被执行");

        //创建数据库的数据表
        String sql=
                "create table tb_user(id integer,name varchar(20),password varchar(20),tel varchar(20))";
        db.execSQL(sql);
    }

    //这个方法是用来升级数据库的
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("onUpgrade","onUpgrade被执行");
        String sql="alter table tb_user add address varchar(100)";
        //执行sql语句
        db.execSQL(sql);
    }
}

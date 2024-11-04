package com.example.demo_clo2_sqllite.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {

    public MyDbHelper(Context context) {
        super(context, "QLBH.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCategory = "CREATE TABLE tb_cat ( id INTEGER PRIMARY KEY UNIQUE NOT NULL, name_cat TEXT UNIQUE NOT NULL );";
        String sqlProduct = "CREATE TABLE tb_product ( id   INTEGER PRIMARY KEY UNIQUE, name_product  TEXT UNIQUE NOT NULL, id_cat REFERENCES tb_cat (id)  NOT NULL, price_product REAL UNIQUE NOT NULL )";
        db.execSQL(sqlCategory);
        db.execSQL(sqlProduct);
        //mỗi khi chỉnh sửa câu lệnh sQL ở trên thì tăng version ở hàm khởi tạo để cập nhật
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i < i1) { //i1 là phiên bản mới, i là phiên bản cũ
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_product");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_cat");
            onCreate(sqLiteDatabase);
        }
    }
}

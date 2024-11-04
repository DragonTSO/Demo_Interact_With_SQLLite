package com.example.demo_clo2_sqllite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.demo_clo2_sqllite.DTO.CatDTO;
import com.example.demo_clo2_sqllite.DbHelper.MyDbHelper;

import java.util.ArrayList;

public class CatDAO {
    MyDbHelper dbHelper;
    SQLiteDatabase db;
    public CatDAO(Context context){
        dbHelper = new MyDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    // Hàm thêm dữ liệu
    public int AddRow(CatDTO ogjcat){
        ContentValues values = new ContentValues();
        values.put("name_cat", ogjcat.getName());
        return (int) db.insert("tb_cat", null, values);
    }
    // Hàm sửa dữ liệu

    // hàm lấy danh sách
    public ArrayList<CatDTO> getList(){
        ArrayList<CatDTO> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT id, name_cat FROM tb_cat", null);
        // nên Query rõ ràng, ko nên select sao vì sẽ tốn tài nguyên
        if (c != null && c.getCount() > 0){
            c.moveToFirst();
            //duyệt vòng lặp
            // thứ tự cột: id là 0,name là 1
            int id = c.getInt(0);
            String name = c.getString(1);
            CatDTO ogjcat = new CatDTO();
            ogjcat.setId(id);
            ogjcat.setName(name);
            //add vào list
            list.add(ogjcat);

        }else{
            Log.d("AAAAA", "CatDao::getlist: Không lấy đc dữ liệu");
        }
        return list;
    }
}

package com.example.vnotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Database_creation extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Vnotes";
    public static final String TABLE_NAME = "subject_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "sub_code";
    public static final String COL_3 = "sub_name";

    public Database_creation(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

//    public Database_creation(Context context) {
//        super(context, DATABASE_NAME, null , 1);
//    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create = "CREATE TABLE if not exists subject_table (key_value TEXT,subcode TEXT,subname TEXT)";
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String drop = String.valueOf("DROP TABLE IF EXISTS");
        sqLiteDatabase.execSQL(drop, new String[]{"subject_table"});
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+"TABLE_NAME");
        onCreate(sqLiteDatabase);
    }

    public void add_subject(String s, subject sub){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("key_value",s);
        values.put("subcode",sub.getSub_code());
        values.put("subname",sub.getSub_name());
        long k = db.insert(TABLE_NAME,null,values);
        Log.d("mytag",Long.toString(k));
        db.close();
    }

    public Cursor get_subject_code(String key_value){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("subject_table",new String[]{"subcode","subname"},"key_value=?",new String[]{String.valueOf(key_value)},null,null,null);
        if(cursor != null && cursor.moveToFirst()){
            Log.d("mytag",cursor.getString(0));
            Log.d("mytag",cursor.getString(1));
//            Log.d("mytag",cursor.getString(2));
        }
        else{
            Log.d("mytag","Some error");
        }
        return cursor;
    }


}

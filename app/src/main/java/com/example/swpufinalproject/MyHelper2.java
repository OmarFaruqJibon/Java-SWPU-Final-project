package com.example.swpufinalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyHelper2 extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "commodity_database";
    //Database Table name
    private static final String TABLE_NAME = "Commodity";
    //Table columns
    public static final String ID = "id";
    public static final String NAME = "pName";
    public static final String PRICE = "pPrice";
    public static final String LOCATION="pLocation";
    private SQLiteDatabase sqLiteDatabase;


    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT NOT NULL,"+PRICE+" INTEGER NOT NULL,"+LOCATION+" TEXT NOT NULL);";
    //Constructor
    public MyHelper2 (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Add Employee Data
    public void addCommodity(CommodityHelper commodityHelper){
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyHelper2.NAME, commodityHelper.getName());
        contentValues.put(MyHelper2.PRICE, commodityHelper.getPrice());
        contentValues.put(MyHelper2.LOCATION,commodityHelper.getLocation());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(MyHelper2.TABLE_NAME, null,contentValues);
    }

    public List<CommodityHelper> getEmployeeList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<CommodityHelper> storeCommodity = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String price = cursor.getString(2);
                String location=cursor.getString(3);
                storeCommodity.add(new CommodityHelper(id,name,price,location));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeCommodity;
    }

    public void updateCommodity(CommodityHelper commodityHelper){
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyHelper2.NAME,commodityHelper.getName());
        contentValues.put(MyHelper2.PRICE,commodityHelper.getPrice());
        contentValues.put(MyHelper2.LOCATION,commodityHelper.getLocation());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(commodityHelper.getId())});
    }

    public void deleteCommodity(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(id)});
    }

}

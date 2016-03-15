package com.adm.reg;

import com.adm.reg.Table.TableInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 12/30/2015.
 */
public class DatabaseOperations extends SQLiteOpenHelper{

    public static final int database_version=1;
    public String CREATE_QUERY="CREATE TABLE " +TableInfo.TABLENAME+"("+TableInfo.FIRSTNAME+" TEXT,"+TableInfo.LASTNAME+" TEXT,"+TableInfo.EMAIL+" TEXT,"+TableInfo.PHONENUMBER+" TEXT, "+TableInfo.PASSWORD+" TEXT"+");";
    public DatabaseOperations(Context context) {
        super(context, TableInfo.DATABASENAME, null, database_version);
        Log.d("DATABASE OPERATION", "DATABASE CREATION SUCESSFULLY");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("DATABASE OPERATION", "TABLE CREATION SUCESSFULLY");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
    public void putinfo(DatabaseOperations dop,String firstname,String lastname,String emailid,String phoneno,String password )
    {
        SQLiteDatabase sq = dop.getWritableDatabase();//data into database
        ContentValues cv=new ContentValues();
        //content value object
        cv.put(TableInfo.FIRSTNAME,firstname);
        cv.put(TableInfo.LASTNAME,lastname);
        cv.put(TableInfo.EMAIL,emailid);
        cv.put(TableInfo.PHONENUMBER,phoneno);
        cv.put(TableInfo.PASSWORD,password);
        //insert
        sq.insert(TableInfo.TABLENAME, null, cv);
        Log.d("DATABASE OPERATION", "TABLE INSERTION SUCESSFULLY");
    }
}

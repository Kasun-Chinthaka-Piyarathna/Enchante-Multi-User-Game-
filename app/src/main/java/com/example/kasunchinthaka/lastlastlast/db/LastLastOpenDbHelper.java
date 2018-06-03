package com.example.kasunchinthaka.lastlastlast.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by Kasun Chinthaka on 11/21/2016.
 */

public class LastLastOpenDbHelper  extends SQLiteOpenHelper implements BaseColumns{
    private static final String DATABASE_NAME = "login.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG ="LastLastOpenDbHelper";

    public LastLastOpenDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String DATABASE_CREATE = "create table " + "LOGIN" + "( "
            +_ID+ " integer primary key autoincrement,"
            + "USERNAME  text,PASSWORD text); ";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
        Log.i(TAG,DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS 'LOGIN'; ");
        Log.i(TAG,"DROP TABLE IF EXISTS 'LOGIN'; ");
        onCreate(db);

    }
}

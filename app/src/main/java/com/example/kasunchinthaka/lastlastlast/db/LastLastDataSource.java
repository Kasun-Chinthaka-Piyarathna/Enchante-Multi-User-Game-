package com.example.kasunchinthaka.lastlastlast.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Kasun Chinthaka on 11/21/2016.
 */

public class LastLastDataSource {
    private static final String TAG = "LastLastDataSource";
    private SQLiteDatabase mDatabase;
    private SQLiteOpenHelper mDbOpenHelper;
    private Context mContext;

    public LastLastDataSource(Context context) {
        this.mContext = context;
        mDbOpenHelper = new LastLastOpenDbHelper(context);
    }

    public void open(){
        mDatabase = mDbOpenHelper.getWritableDatabase();
        Log.i(TAG,"Database opened.");
    }

    public void close(){
        mDbOpenHelper.close();
        Log.i(TAG,"Database closed.");
    }

    public void insertEntry(String userName, String password) {
        ContentValues newValues = new ContentValues();
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD", password);
        mDatabase.insertOrThrow("LOGIN", null, newValues);
    }

    public int deleteEntry(String UserName) {
        String where = "USERNAME=?";
        return mDatabase.delete("LOGIN", where,
                new String[]{UserName});
    }

    public String getSingleEntry(String userName) {
        Cursor cursor = mDatabase.query("LOGIN", null, " USERNAME=?",
                new String[]{userName}, null, null, null);

        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }

    public void updateEntry(String userName, String password) {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD", password);
        String where = "USERNAME = ?";
        mDatabase.update("LOGIN", updatedValues, where, new String[]{userName});
    }

}

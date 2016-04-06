package com.example.admin.profilemanager.utilities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.admin.profilemanager.models.TimeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 03-04-2016.
 */
public class DatabaseManager extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private Context mcontext;

    public static final String createTableTime = " CREATE TABLE " + Constants.TABLE_NAME_TIME +
            " ( " + Constants.COLUMN_ID_TIME + " INTEGER PRIMARY KEY AUTOINCREMENT , "
            + Constants.COLUMN_FROM_TIME + " TEXT , " + Constants.COLUMN_TO_TIME + " TEXT , "
            + Constants.COLUMN_MODE_OF_PHONE_TIME + " TEXT ) ";

    public static final String createTableMovement = " CREATE TABLE " +
            Constants.TABLE_NAME_MOVEMENT + " ( " + Constants.COLUMN_ID_MOVEMENT +
            " INTEGER PRIMARY KEY AUTOINCREMENT , " + Constants.COLUMN_MODE_OF_MOVEMENT +
            " TEXT , " + Constants.COLUMN_MODE_OF_PHONE_MOVEMENT + " TEXT ) ";

    public static final String createTableBattery = " CREATE TABLE " +
            Constants.TABLE_NAME_BATTERY + " ( " + Constants.COLUMN_ID_BATTERY +
            " INTEGER PRIMARY KEY AUTOINCREMENT , " + Constants.COLUMN_BATTERY_LEVEL + " TEXT , " +
            Constants.COLUMN_MODE_OF_PHONE_BATTERY + " TEXT , "
            + Constants.COLUMN_MODE_OF_NETWORK + " TEXT ) ";

    public static final String createTableLocation = " CREATE TABLE " +
            Constants.TABLE_NAME_LOCATION + " ( " + Constants.COLUMN_ID_LOCATION +
            " INTEGER PRIMARY KEY AUTOINCREMENT , " + Constants.COLUMN_LATITUDE + " DOUBLE , " +
            Constants.COLUMN_LONGITUDE + " DOUBLE , " + Constants.COLUMN_RADIUS + " INTEGER , " +
            Constants.COLUMN_ADDRESS + " TEXT ," +
            Constants.COLUMN_MODE_OF_PHONE_LOCATION + " TEXT ) ";

    public DatabaseManager(Context context) {
        super(context, Constants.DATABASE_NAME, null, DB_VERSION);
        mcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTableTime);
        db.execSQL(createTableMovement);
        db.execSQL(createTableBattery);
        db.execSQL(createTableLocation);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //method to add details to time table in database
    public void addDetailsToTimeTable(String fromTime, String toTime, String modeOfPhone) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.COLUMN_FROM_TIME, fromTime);
        values.put(Constants.COLUMN_TO_TIME, toTime);
        values.put(Constants.COLUMN_MODE_OF_PHONE_TIME, modeOfPhone);
        database.insert(Constants.TABLE_NAME_TIME, null, values);
        database.close();
    }

    //method to get all details from time table of the database
    public List<TimeModel> getDetailsFromTimeTable() {
        List<TimeModel> details = new ArrayList<TimeModel>();
        String getDetailsQuery = "SELECT * FROM " + Constants.TABLE_NAME_TIME;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(getDetailsQuery, null);
        try {
            if (cursor.moveToFirst()) do {
                TimeModel timeModel = new TimeModel();
                timeModel.setFromTime(cursor.getString(cursor.getColumnIndex(Constants.
                        COLUMN_FROM_TIME)));
                timeModel.setToTime(cursor.getString(cursor.getColumnIndex(Constants.
                        COLUMN_TO_TIME)));
                timeModel.setModeOfPhone(cursor.getString(cursor.getColumnIndex(Constants.
                        COLUMN_MODE_OF_PHONE_TIME)));
                details.add(timeModel);
            } while (cursor.moveToNext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return details;
    }
}

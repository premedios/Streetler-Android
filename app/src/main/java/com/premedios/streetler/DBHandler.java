package com.premedios.streetler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by premedios on 12/02/16.
 */
public class DBHandler extends SQLiteOpenHelper {

    // Database version
    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "Streetler";

    // Table names
    private static final String TABLE_EVENT = "Event";
    private static final String TABLE_USER = "User";
    private static final String TABLE_EVENTIMAGE = "EventImage";
    private static final String TABLE_EVENTLIKE = "EventLike";
    private static final String TABLE_EVENTNOTIFICATION = "EventNotification";
    private static final String TABLE_EVENTUSER = "EventUser";
    private static final String TABLE_EVENTVIDEO = "EventVideo";

    // Table Fields
    private static final String KEY_ID = "id";
    private static final String KEY_EVENT_TYPE = "type";
    private static final String KEY_EVENT_NAME = "name";
    private static final String KEY_EVENT_DESCRIPTION = "description";
    private static final String KEY_EVENT_IMAGE = "image";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createEventTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
        super.onConfigure(db);
    }

    private void createEventTable(SQLiteDatabase db) {
        String CREATE_EVENT_TABLE_SQL =
                "CREATE TABLE " + TABLE_EVENT +
                " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_EVENT_TYPE + " TEXT, "
                + KEY_EVENT_NAME + " TEXT, "
                + KEY_EVENT_DESCRIPTION + " TEXT, "
                + KEY_EVENT_IMAGE + " TEXT";
        db.execSQL(CREATE_EVENT_TABLE_SQL);
    }
}

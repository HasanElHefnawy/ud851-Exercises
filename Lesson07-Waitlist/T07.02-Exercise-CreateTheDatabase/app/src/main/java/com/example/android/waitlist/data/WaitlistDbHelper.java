package com.example.android.waitlist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.android.waitlist.data.WaitlistContract.WaitlistEntry;

// TODO (1) extend the SQLiteOpenHelper class
public class WaitlistDbHelper extends SQLiteOpenHelper {

    // TODO (2) Create a static final String called DATABASE_NAME and set it to "waitlist.db"
    public static final String DATABASE_NAME = "waitlist.db";

    // TODO (3) Create a static final int called DATABASE_VERSION and set it to 1
    public static final int DATABASE_VERSION = 1;

    // TODO (4) Create a Constructor that takes a context and calls the parent constructor
    public WaitlistDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // TODO (5) Override the onCreate method
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // TODO (6) Inside, create an String query called SQL_CREATE_WAITLIST_TABLE that will create the table
        String SQL_CREATE_WAITLIST_TABLE =
                "CREATE TABLE " + WaitlistEntry.TABLE_NAME + " (" +
                        WaitlistEntry._ID + " INTEGER PRIMARY KEY," +
                        WaitlistEntry.COLUMN_GUEST_NAME + " TEXT," +
                        WaitlistEntry.COLUMN_PARTY_SIZE + " INTEGER," +
                        WaitlistEntry.COLUMN_TIMESTAMP + " TEXT)";

        // TODO (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE
        sqLiteDatabase.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    // TODO (8) Override the onUpgrade method
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        // TODO (9) Inside, execute a drop table query, and then call onCreate to re-create it
        String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + WaitlistEntry.TABLE_NAME;
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

}
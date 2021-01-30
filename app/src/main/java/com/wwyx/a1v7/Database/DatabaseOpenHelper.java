package com.wwyx.a1v7.Database;

import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

class DatabaseOpenHelper extends SQLiteAssetHelper {
    // Database access
    private final static String DATABASE_NAME = "924b.db";
    private static final int DATABASE_VERSION = 1;

    DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}

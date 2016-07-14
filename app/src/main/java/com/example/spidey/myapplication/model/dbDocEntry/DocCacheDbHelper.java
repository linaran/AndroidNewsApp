package com.example.spidey.myapplication.model.dbDocEntry;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.spidey.myapplication.model.dbDocEntry.DocCacheContract.DocEntry;

public final class DocCacheDbHelper extends SQLiteOpenHelper {
    //region Basic Database information
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DocCache.db";
    //endregion

    //region SQL - Basic syntax
    public static final String CREATE_TABLE = " CREATE TABLE ";
    public static final String OPEN_BRACKETS = " ( ";
    public static final String CLOSE_BRACKETS = " ) ";
    public static final String INTEGER = " INTEGER ";
    public static final String PRIMARY_KEY = " PRIMARY KEY ";
    public static final String AUTOINCREMENT = " AUTOINCREMENT ";
    public static final String TEXT = " TEXT ";
    public static final String DROP_TABLE_IF_EXISTS = "DROP TABLE IF EXISTS ";
    public static final String SELECT_ALL_FROM = "SELECT * FROM ";
    public static final String ORDER_BY = " ORDER BY ";
    public static final String SEMICOLON = ";";
    public static final String WHERE = " WHERE ";
    public static final String EQUALS = " = ";
    public static final String DELETE_FROM = "DELETE FROM ";
    public static final String WHERE_ONE = " WHERE 1";
    public static final String UPDATE = "UPDATE ";
    public static final String SET = " SET ";
    public static final String COMMA = " , ";
    public static final String QUOTATION = "\"";
    public static final String DESCENDING = " DESC ";
    public static final String ASCENDING = " ASC ";
    //endregion

    //region SQL - DocEntry
    private final static String SQL_CREATE_DOC_ENTRY =
            CREATE_TABLE + DocEntry.TABLE_NAME +
                    OPEN_BRACKETS +
                    DocEntry.COLUMN_NAME_DOC_ID + INTEGER + PRIMARY_KEY + AUTOINCREMENT + COMMA +
                    DocEntry.COLUMN_NAME_MAIN_HEADLINE + TEXT + COMMA +
                    DocEntry.COLUMN_NAME_LEAD_PARAGRAPH + TEXT + COMMA +
                    DocEntry.COLUMN_NAME_IMAGE_RELATIVE_URL + TEXT +
                    CLOSE_BRACKETS + SEMICOLON;

    private final static String SQL_DELETE_ENTRIES =
            DROP_TABLE_IF_EXISTS + DocEntry.TABLE_NAME;
    //endregion

    public DocCacheDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_DOC_ENTRY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

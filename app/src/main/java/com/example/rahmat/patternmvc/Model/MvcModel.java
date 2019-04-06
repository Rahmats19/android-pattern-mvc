package com.example.rahmat.patternmvc.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.rahmat.patternmvc.View.MvcView;

public final class MvcModel {

    private static final String DB_NAME = "tasks_db";
    private static final String TABLE_NAME = "task";
    private static final int DB_VERSION = 1;
    private static final String DB_CREATE_QUERY = "CREATE TABLE " + MvcModel.TABLE_NAME +
            " (id integer primary key autoincrement, title text not null);";

    private final SQLiteDatabase database;

    private final SQLiteOpenHelper helper;

    public MvcModel(final Context ctx)
    {
        this.helper = new SQLiteOpenHelper(ctx, MvcModel.DB_NAME,
                null, MvcModel.DB_VERSION)
        {
            @Override
            public void onCreate(final SQLiteDatabase db)
            {
                db.execSQL(MvcModel.DB_CREATE_QUERY);
            }

            @Override
            public void onUpgrade(final SQLiteDatabase db,
                                  final int oldVersion, final int newVersion)
            {
                db.execSQL("DROP TABLE IF EXISTS " + MvcModel.TABLE_NAME);
                this.onCreate(db);
            }
        };

        this.database = this.helper.getWritableDatabase();
    }

    public void addTask(ContentValues data)
    {
        this.database.insert(MvcModel.TABLE_NAME, null, data);
    }

    public void deleteTask(final String field_params)
    {
        this.database.delete(MvcModel.TABLE_NAME, field_params, null);
    }

    public Cursor loadAllTasks()
    {

        Log.d(MvcView.APP_TAG, "loadAllTasks()");

        final Cursor c = this.database.query(MvcModel.TABLE_NAME,
                new String[] { "title" }, null, null, null, null, null);

        return c;
    }

}

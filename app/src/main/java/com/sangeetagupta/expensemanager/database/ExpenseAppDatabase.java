package com.sangeetagupta.expensemanager.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import com.sangeetagupta.expensemanager.data.ExpenseItem;


@Database(entities = {ExpenseItem.class}, version = 1, exportSchema = false)

public abstract class ExpenseAppDatabase extends RoomDatabase {

    private static final String LOG_TAG = ExpenseAppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "movie_db";
    private static ExpenseAppDatabase sInstance;

    public static ExpenseAppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "Creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        ExpenseAppDatabase.class, ExpenseAppDatabase.DATABASE_NAME)
                        .build();
            }
        }
        Log.d(LOG_TAG, "Getting the database instance");
        return sInstance;
    }

    public abstract ExpenseItemDao expenseItemDao();

}

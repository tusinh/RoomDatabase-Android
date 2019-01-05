package com.bimart.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.bimart.database.dao.BillChildDao;
import com.bimart.database.dao.BillDao;
import com.bimart.database.dao.ProductDao;
import com.bimart.database.model.BillChildLocal;
import com.bimart.database.model.BillLocal;
import com.bimart.database.model.ProductLocal;

import static com.bimart.database.AppDatabase.DATABASE_VERSION;

@Database(entities = {BillLocal.class, ProductLocal.class, BillChildLocal.class}, version = DATABASE_VERSION, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;

    public static final int DATABASE_VERSION = 5;
    public static final String DATABASE_NAME = "Room-database";

    public abstract BillDao billDao();

    public abstract BillChildDao billChildDao();

    public abstract ProductDao productDao();

    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }
    public static void destroyInstance() {
        appDatabase = null;
    }
}

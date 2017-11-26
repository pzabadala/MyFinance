package com.zabadala.finance.myfinance;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by pzaba on 2017-11-05.
 */
@Database(entities = {Transaction.class}, version = 1)
public abstract class FinanceDatabase extends RoomDatabase {
    public abstract TransactionDao transactionDao();

}

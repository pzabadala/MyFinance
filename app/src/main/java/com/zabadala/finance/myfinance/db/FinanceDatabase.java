package com.zabadala.finance.myfinance.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.zabadala.finance.myfinance.dao.*;

/**
 * Created by pzaba on 2017-11-05.
 */
@Database(entities = {Transaction.class}, version = 3)
public abstract class FinanceDatabase extends RoomDatabase {


    private static FinanceDatabase INSTANCE;

    public static FinanceDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context,
                    FinanceDatabase.class, "FinanceDB")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public abstract TransactionDao transactionDao();
}

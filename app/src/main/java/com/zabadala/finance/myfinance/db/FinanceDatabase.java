package com.zabadala.finance.myfinance.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.zabadala.finance.myfinance.dao.*;

/**
 * Created by pzaba on 2017-11-05.
 */
@Database(entities = {Transaction.class}, version = 2)
public abstract class FinanceDatabase extends RoomDatabase {
    public abstract TransactionDao transactionDao();
}

package com.zabadala.finance.myfinance;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by pzaba on 2017-11-05.
 */
@Dao
public interface TransactionDao {

        @Query("SELECT * FROM transactions")
        List<Transaction> getAll();

        @Query("SELECT * FROM transactions WHERE uid IN (:transactionIds)")
        List<Transaction> loadAllByIds(int[] transactionIds);
    
        @Insert
        void insertAll(Transaction... transactions);

        @Delete
        void delete(Transaction user);
}

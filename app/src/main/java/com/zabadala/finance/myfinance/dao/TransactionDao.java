package com.zabadala.finance.myfinance.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.zabadala.finance.myfinance.db.*;


import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by pzaba on 2017-11-05.
 */
@Dao
public interface TransactionDao {

        @Query("SELECT * FROM transactions")
        LiveData<List<Transaction>> getAll();

        @Query("SELECT  * FROM transactions LIMIT 10")
        LiveData<List<Transaction>> getTopTransaction();

        @Query("SELECT * FROM transactions WHERE uid IN (:transactionIds)")
        List<Transaction> loadAllByIds(int[] transactionIds);
    
        @Insert(onConflict = REPLACE)
        void insertAll(Transaction... transactions);

        @Delete
        void delete(Transaction transaction);

        @Query("SELECT COUNT(*) FROM TRANSACTIONS")
        Integer getCount();

        @Query("DELETE FROM TRANSACTIONS")
        void truncate();



}

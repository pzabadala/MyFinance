package com.zabadala.finance.myfinance.UI;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;
import android.util.Log;

import com.zabadala.finance.myfinance.db.FinanceDatabase;
import com.zabadala.finance.myfinance.db.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pzaba on 2017-12-27.
 */

public class TransactionViewModel extends AndroidViewModel {


    FinanceDatabase financeDatabase;
    private final LiveData<List<Transaction>> transactionsList;

    public TransactionViewModel(Application application){
        super(application);

        financeDatabase  = FinanceDatabase.getDatabase(application);
        transactionsList = financeDatabase.transactionDao().getAll();
       // int count = financeDatabase.transactionDao().getCount();
        //Transaction transaction = new Transaction();



        Log.d("ModelView", "get All transactions");
    }

    public LiveData<List<Transaction>> getTransactions() {

        if (transactionsList == null) {
            Log.d("ModelView", "transactionList is null");
        }
        Log.d("ModelView", "return transactionList");
        return transactionsList;
    }

    public void deleteItem(Transaction transaction) {
        //new deleteAsyncTask(appDatabase).execute(borrowModel);
    }

}

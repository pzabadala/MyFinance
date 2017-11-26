package com.zabadala.finance.myfinance.services;

import android.app.Service;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;

import com.zabadala.finance.myfinance.FinanceDatabase;
import com.zabadala.finance.myfinance.Transaction;

import java.sql.Date;

public class DbService extends Service {

    private static FinanceDatabase db = null;
    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;

    class ServiceHandler extends Handler {

        public ServiceHandler(Looper looper){
            super(looper);
        }

        @Override
        public void handleMessage(Message msg){

            addTransaction(msg);
            stopSelf(msg.arg1);
        }

    }

    public DbService() {

    }

    @Override
    public void onCreate(){
        if (db == null){
            db = Room.databaseBuilder(getApplicationContext(),
                    FinanceDatabase.class, "FinanceDB").build();
        }
        db.transationDao();
        HandlerThread thread = new HandlerThread("ServiceStartArguments",
                Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();
        mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    private int addTransaction(Message msg){
        Transaction trasaction = new Transaction();
        trasaction.setTransactionAuthor("Piotr");
        trasaction.setTransactionCurrency("pln");
        trasaction.setTransactionValue(5);
        trasaction.setTransactionUserDate(new Date(new java.util.Date().getTime()).toString());
        trasaction.setTransactionUserDate(new Date(new java.util.Date().getTime()).toString());
        return 0;
    }

}

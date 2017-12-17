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

import com.zabadala.finance.myfinance.db.*;


import java.sql.Date;
import java.util.List;

public class DbService extends Service {

    public static final int ADD_TRANSATION = 1;
    public static final int GET_TOP_TRANSACTIONS= 2;



    private static FinanceDatabase db = null;
    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;

    public DbService() {
    }

    class ServiceHandler extends Handler {

        public ServiceHandler(Looper looper){
            super(looper);
        }

        @Override
        public void handleMessage(Message msg){
            int what = msg.what;

            if(what == ADD_TRANSATION){
                addTransaction(msg);
            } else if (what == GET_TOP_TRANSACTIONS){
                List<Transaction> list = getTopTransaction(100);
            }
            stopSelf(msg.arg1);
        }

    }

    @Override
    public void onCreate(){
        System.out.println("on create");
        if (db == null){
            System.out.println("DB Null");
            db = Room.databaseBuilder(getApplicationContext(),
                    FinanceDatabase.class, "FinanceDB")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        HandlerThread thread = new HandlerThread("ServiceStartArguments",
                Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();
        mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;
        mServiceHandler.sendMessage(msg);

        // If we get killed, after returning from here, restart
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    private int addTransaction(Message msg){
        System.out.println("add Transaction");
        Transaction trasaction = new Transaction();
        trasaction.setTransactionAuthor("Piotr");
        trasaction.setTransactionCurrency("pln");
        trasaction.setTransactionValue(5);
        trasaction.setTransactionUserDate(new Date(new java.util.Date().getTime()).toString());
        trasaction.setTrasactionDate(new Date(new java.util.Date().getTime()).toString());
        db.transactionDao().insertAll(trasaction);
        return 0;
    }

    private List<Transaction> getTopTransaction(int count){
        return db.transactionDao().getTopTransaction();
    }

}

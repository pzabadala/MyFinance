package com.zabadala.finance.myfinance;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.zabadala.finance.myfinance.db.FinanceDatabase;
import com.zabadala.finance.myfinance.db.Transaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private int entitiesCount = 10;
    private FinanceDatabase db;
    private Transaction transaction;

    @Before
    public void createDBHandler(){
        Context context = InstrumentationRegistry.getTargetContext();
        db = FinanceDatabase.getDatabase(context);
    }

    @Test
    public void deleteTransactions(){
        db.transactionDao().truncate();
        int count = db.transactionDao().getCount();
        assertEquals(0, count);
    }

    @Test
    public void testcountEntities(){

        int count = 10 - db.transactionDao().getCount();
        Log.d(this.getClass().toString(), "transaction count: -  " + count);

        for (int i = 0; i < count; i++) {
            Transaction trasaction = new Transaction();
            trasaction.setTransactionAuthor("Piotr");
            trasaction.setTransactionCurrency("pln");
            trasaction.setTransactionValue(new Random(100).nextInt());

            trasaction.setTrasactionDate(new Date(new java.util.Date().getTime()).toString());
            Long randomTime = TimeUnit.DAYS.toMillis( new Random(10).nextInt());
            trasaction.setTransactionUserDate(new Date(new java.util.Date().getTime() - randomTime).toString());
            db.transactionDao().insertAll(trasaction);
        }

        assertEquals(entitiesCount, count);
    }

    @After
    public void closeDBHandler(){
        db.close();
    }


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.zabadala.finance.myfinance", appContext.getPackageName());
    }
}

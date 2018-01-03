package com.zabadala.finance.myfinance.UI;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.zabadala.finance.myfinance.R;
import com.zabadala.finance.myfinance.services.DbService;
import com.zabadala.finance.myfinance.db.Transaction;
import java.util.*;
import android.arch.lifecycle.Observer;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    private RecyclerView recyclerView;
    private TransactionAdapter transactionAdapter;
    private TransactionViewModel transactionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        transactionAdapter = new TransactionAdapter(new ArrayList<Transaction>());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(transactionAdapter);

        prepareTransactionData();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.addTransactionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startActivity(new Intent(MainActivity.this, AddActivity.class));
            }
        });

        transactionViewModel = ViewModelProviders.of(this).get(TransactionViewModel.class);
        transactionViewModel.getTransactions().observe(MainActivity.this, new Observer<List<Transaction>>() {
            @Override
            public void onChanged(@Nullable List<Transaction> transactions) {
                transactionAdapter.addItems(transactions);
            }
        });
    }


    private void prepareTransactionData(){

    }

    private void addTransaction(){
        Intent intent = new Intent(this, DbService.class);
        startService(intent);
    }

    @Override
    public boolean onLongClick(View v) {
        Transaction transaction = (Transaction) v.getTag();
        transactionViewModel.deleteItem(transaction);
        return true;
    }

}

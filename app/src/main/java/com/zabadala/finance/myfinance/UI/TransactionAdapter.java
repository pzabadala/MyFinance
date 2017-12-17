package com.zabadala.finance.myfinance.UI;

/**
 * Created by pzaba on 2017-12-17.
 */

import com.zabadala.finance.myfinance.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.zabadala.finance.myfinance.db.Transaction;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> {

    private List<Transaction> trasactionsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView transactionValue, transactionDate, transactionAuthor;

        public MyViewHolder(View view) {
            super(view);
            transactionValue = (TextView) view.findViewById(R.id.transactionValue);
            transactionDate = (TextView) view.findViewById(R.id.transactionDate);
            transactionAuthor = (TextView) view.findViewById(R.id.transactionAuthor);
        }
    }


    public TransactionAdapter(List<Transaction> trasactionsList) {
        this.trasactionsList = trasactionsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transaction_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Transaction transaction = trasactionsList.get(position);
        holder.transactionValue.setText(transaction.getTransactionValue());
        holder.transactionDate.setText(transaction.getTrasactionDate());
        holder.transactionAuthor.setText(transaction.getTransactionAuthor());
    }

    @Override
    public int getItemCount() {
        return trasactionsList.size();
    }
}

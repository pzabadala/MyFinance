package com.zabadala.finance.myfinance.UI;

/**
 * Created by pzaba on 2017-12-17.
 */

import com.zabadala.finance.myfinance.R;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.zabadala.finance.myfinance.db.Transaction;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {

    private List<Transaction> transactionsList;

    public class TransactionViewHolder extends RecyclerView.ViewHolder {
        public TextView transactionValue, transactionDate, transactionAuthor;

        public TransactionViewHolder(View view) {
            super(view);
            transactionValue = (TextView) view.findViewById(R.id.transactionValue);
            transactionDate = (TextView) view.findViewById(R.id.transactionDate);
            transactionAuthor = (TextView) view.findViewById(R.id.transactionAuthor);
        }
    }


    public TransactionAdapter(List<Transaction> trasactionsList) {
        this.transactionsList = trasactionsList;
    }

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transaction_list_row, parent, false);

        return new TransactionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {

        Transaction transaction = transactionsList.get(position);

        Integer transactionValue = transaction.getTransactionValue();
        Log.d("TransactionAdapter", "Position: " + position + "TransactionValue: " + transactionValue);
        holder.transactionValue.setText(Integer.toString(transactionValue));
        holder.transactionDate.setText(transaction.getTrasactionDate());
        holder.transactionAuthor.setText(transaction.getTransactionAuthor());
    }

    @Override
    public int getItemCount() {
        Log.d("TransactionAdapter", "transaction list size: "+ transactionsList.size());
        return transactionsList.size();
    }

    public void addItems(List<Transaction> transactionsList) {
        this.transactionsList = transactionsList;
        notifyDataSetChanged();
    }


}

package com.zabadala.finance.myfinance;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.sql.Date;


/**
 * Created by pzaba on 2017-11-05.
 */

@Entity(tableName="transactions")
public class Transaction {

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTrasactionDate() {
        return trasactionDate;
    }

    public void setTrasactionDate(String trasactionDate) {
        this.trasactionDate = trasactionDate;
    }

    public String getTransactionUserDate() {
        return transactionUserDate;
    }

    public void setTransactionUserDate(String transactionUserDate) {
        this.transactionUserDate = transactionUserDate;
    }

    public Integer getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(Integer transactionValue) {
        this.transactionValue = transactionValue;
    }

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public String getTransactionAuthor() {
        return transactionAuthor;
    }

    public void setTransactionAuthor(String transactionAuthor) {
        this.transactionAuthor = transactionAuthor;
    }

    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "transaction_date")
    private String trasactionDate;

    @ColumnInfo(name = "transaction_user_date")
    String transactionUserDate;

    @ColumnInfo(name = "transaction_value")
    Integer transactionValue;

    @ColumnInfo(name = "transaction_currency")
    String transactionCurrency;

    @ColumnInfo(name = "transaction_author")
    String transactionAuthor;

}

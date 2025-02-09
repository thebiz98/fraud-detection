package org.example.dao;

import org.example.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    public List<Transaction> getTransactionHistory(String userId) {
        return new ArrayList<>();
    }

    public void recordTransaction(Transaction transaction) {
    }
}

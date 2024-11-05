package com.example.E_commerce.ServiceInterface;

import com.example.E_commerce.Model.Transaction;
import com.example.E_commerce.Repository.TransactionRepository;

import java.util.List;

public interface TransactionServiceInterf{
    Transaction Addtransaction(int orderId);
    List<Transaction> GetUserTransaction(long userId);
    List<Transaction> GetAllTransaction();
}

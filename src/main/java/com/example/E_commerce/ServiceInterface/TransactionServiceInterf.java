package com.example.E_commerce.ServiceInterface;

import org.springframework.http.ResponseEntity;

public interface TransactionServiceInterf{
    ResponseEntity<?> addTransaction(int orderId);
    ResponseEntity<?> GetUserTransaction(long userId);
    ResponseEntity<?> GetAllTransaction();
}

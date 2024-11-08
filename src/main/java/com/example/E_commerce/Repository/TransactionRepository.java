package com.example.E_commerce.Repository;

import com.example.E_commerce.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    List<Transaction> findByUserId(long userId);


    Optional<Transaction> findByOrderId(int orderId);

}

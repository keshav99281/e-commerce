package com.example.E_commerce.Repository;

import com.example.E_commerce.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findByUserId(long userId);
    void deleteByUserId(long userId);

}

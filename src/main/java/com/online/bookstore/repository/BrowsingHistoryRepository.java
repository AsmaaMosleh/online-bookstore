package com.online.bookstore.repository;

import com.online.bookstore.model.BrowsingHistory;
import com.online.bookstore.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrowsingHistoryRepository extends JpaRepository<BrowsingHistory, Long> {

    List<BrowsingHistory> findByCustomer(Customer customer);
}

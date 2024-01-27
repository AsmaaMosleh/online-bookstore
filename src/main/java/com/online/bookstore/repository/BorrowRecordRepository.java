package com.online.bookstore.repository;

import com.online.bookstore.model.Book;
import com.online.bookstore.model.BorrowRecord;
import com.online.bookstore.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord , Long> {
  List<BorrowRecord> findByBookAndStatus(Book book, String status);

  BorrowRecord findByBookAndCustomer(Book book, Customer customer);

  List<BorrowRecord> findByCustomer(Customer customer);
}

package com.online.bookstore.service;

import com.online.bookstore.model.Book;
import com.online.bookstore.model.BorrowRecord;
import com.online.bookstore.model.Customer;

import java.util.List;

public interface BorrowRecordService {

    List<BorrowRecord> getAllBorrowRecords();

    BorrowRecord getBorrowRecordByBookAndCustomer(Book book, Customer customer);
    void deleteBorrowRecords();

}


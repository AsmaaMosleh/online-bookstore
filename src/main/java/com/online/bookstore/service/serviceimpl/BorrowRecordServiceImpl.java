package com.online.bookstore.service.serviceimpl;

import com.online.bookstore.model.Book;
import com.online.bookstore.model.BorrowRecord;
import com.online.bookstore.model.Customer;
import com.online.bookstore.repository.BorrowRecordRepository;
import com.online.bookstore.service.BorrowRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;

    @Autowired
    public BorrowRecordServiceImpl(BorrowRecordRepository borrowRecordRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
    }

    @Override
    public List<BorrowRecord> getAllBorrowRecords() {

        return borrowRecordRepository.findAll();
    }

    @Override
    public BorrowRecord getBorrowRecordByBookAndCustomer(Book book, Customer customer) {
        return borrowRecordRepository.findByBookAndCustomer(book, customer);
    }

    @Override
    public void deleteBorrowRecords() {
        borrowRecordRepository.deleteAll();
    }

}

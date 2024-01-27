package com.online.bookstore.dto;

import com.online.bookstore.model.Book;
import com.online.bookstore.model.Customer;

import java.util.Date;

public class BorrowRecordDTO {

    private Long borrowID;


    private Customer customer;

    private Book book;

    private Date requestDate;

    private Date borrowDate;

    private Date returnDate;

    private String status;


    public BorrowRecordDTO() {
    }

    public BorrowRecordDTO( Long borrowID,Customer customer, Book book, Date requestDate, Date borrowDate, Date returnDate, String status) {
        this.borrowID=borrowID;
        this.customer = customer;
        this.book = book;
        this.requestDate = requestDate;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Long getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(Long borrowID) {
        this.borrowID = borrowID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

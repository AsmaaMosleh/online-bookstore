package com.online.bookstore.service;

import com.online.bookstore.model.Book;
import com.online.bookstore.model.BorrowRecord;
import com.online.bookstore.model.Customer;
import java.util.Date;
import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(Long bookId);

    List<Book> getBooksByIds(List<Long> bookIds);
    List<Book> getBooksByGenre(String genre);

    Book addBook(Book book);

    List<Book> addBooks(List<Book> books);

    void deleteBook(Long bookId);
    void deleteBooks(List<Long> bookIds);
    void deleteBooks();

    Book updateBookDetails(Long bookId, Book updatedBook);

    BorrowRecord requestBookForBorrowing(Customer customer, Book book);

    BorrowRecord manageBorrowingDate(BorrowRecord borrowRecord, Date newBorrowDate);

    BorrowRecord manageReturnDate(BorrowRecord borrowRecord, Date newReturnDate);


    // New method to get BorrowRecord by ID
    BorrowRecord getBorrowRecordById(Long borrowRecordId);

    //  update inventory
    Book updateInventory(Book book, int quantityChange,boolean change);

    Book updateStock(Long bookId, int newStockLevel);

    Book setBookAvailability(Long bookId, boolean isAvailable);

}



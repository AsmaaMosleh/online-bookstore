package com.online.bookstore.service.serviceimpl;

import com.online.bookstore.util.AppConstant;
import com.online.bookstore.model.Book;
import com.online.bookstore.model.BorrowRecord;
import com.online.bookstore.model.Customer;
import com.online.bookstore.repository.BookRepository;
import com.online.bookstore.repository.BorrowRecordRepository;
import com.online.bookstore.repository.CustomerRepository;
import com.online.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BorrowRecordRepository borrowRecordRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BorrowRecordRepository borrowRecordRepository,CustomerRepository customerRepository) {
        this.bookRepository = bookRepository;
        this.borrowRecordRepository = borrowRecordRepository;
    }

    @Override
    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long bookId) {

        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public List<Book> getBooksByIds(List<Long> bookIds) {
        return bookRepository.findAllById(bookIds);
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {

        return bookRepository.findByGenreIgnoreCase(genre);
    }

    @Override
    public Book addBook(Book book) {
        // Implement logic for adding a new book
        return bookRepository.save(book);
    }

    @Override
    public List<Book> addBooks(List<Book> books) {
        // Implement logic for adding multiple books
        return bookRepository.saveAll(books);
    }

    @Override
    public void deleteBook(Long bookId) {

        bookRepository.deleteById(bookId);
    }


    @Override
    public void deleteBooks(List<Long> bookIds) {

        bookRepository.deleteAllById(bookIds);
    }

    @Override
    public void deleteBooks() {

        bookRepository.deleteAll();
    }

    @Override
    public Book updateBookDetails(Long bookId, Book updatedBook) {
        Optional<Book> existingBookOptional = bookRepository.findById(bookId);
        if (existingBookOptional.isPresent()) {
            Book existingBook = existingBookOptional.get();
            // Update book details with the values from updatedBook
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setGenre(updatedBook.getGenre());
            existingBook.setIsbn(updatedBook.getIsbn());
            existingBook.setQuantityAvailable(updatedBook.getQuantityAvailable());
            existingBook.setAvailable(updatedBook.isAvailable());
            existingBook.setBorrowRecords(updatedBook.getBorrowRecords());

            return bookRepository.save(existingBook);
        } else {
            return null;
        }
    }


    @Override
    public BorrowRecord getBorrowRecordById(Long borrowRecordId) {
        Optional<BorrowRecord> optionalBorrowRecord = borrowRecordRepository.findById(borrowRecordId);
        return optionalBorrowRecord.orElse(null);
    }
    @Override
    public BorrowRecord requestBookForBorrowing(Customer customer, Book book) {
        // Check if the book is available for borrowing
        if (book.getQuantityAvailable() > 0) {

            BorrowRecord borrowRecord = BorrowRecord.builder()
                    .customer(customer)
                    .book(book).requestDate(new Date()).status(AppConstant.STATUS_REQUESTED).build();

            // Update book availability and save changes
            return borrowRecordRepository.save(borrowRecord);
        } else {
            return null; // Book is not available for borrowing
        }
    }



    @Override
    public BorrowRecord manageBorrowingDate(BorrowRecord borrowRecord, Date newBorrowDate) {
        if (borrowRecord.getStatus().equals(AppConstant.STATUS_REQUESTED)) {
            borrowRecord.setStatus(AppConstant.STATUS_BORROWED);
            borrowRecord.setBorrowDate(newBorrowDate);

            bookRepository.save(updateInventory(borrowRecord.getBook(), -1,true));
        }

        return borrowRecordRepository.save(borrowRecord);
    }

    @Override
    public BorrowRecord manageReturnDate(BorrowRecord borrowRecord, Date newReturnDate) {

        if (borrowRecord.getStatus().equals(AppConstant.STATUS_BORROWED)) {
            // Update status to RETURNED when managing return Date
               borrowRecord.setStatus(AppConstant.STATUS_RETURNED);
               borrowRecord.setReturnDate(newReturnDate);

            // Update book availability and save changes
               bookRepository.save(updateInventory(borrowRecord.getBook(), 1,true));
        }

       return borrowRecordRepository.save(borrowRecord);

    }


    // Method to update inventory
    @Override
    public Book updateInventory(Book book, int quantity,boolean changed) {

        //If changed is true ,then the book's quantityAvailable will be added with new quantity(updated).
        //If changed is false, then the book's quantityAvailable will be reset with exact value of new quantity.
        int newQuantity=(changed ? (book.getQuantityAvailable() + quantity) : quantity);

        book.setQuantityAvailable(newQuantity);
        book.setAvailable( newQuantity>0);
        return book;
    }


    @Override
    public Book updateStock(Long bookId, int newStockLevel) {
        Book book = bookRepository.findById(bookId).orElse(null);

        if (book != null) {
            return bookRepository.save(updateInventory(book,newStockLevel,false));
        }else {
            return null;
        }
    }

    @Override
    public Book setBookAvailability(Long bookId, boolean isAvailable) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book != null) {
            book.setQuantityAvailable(isAvailable ? 1 : 0);
            book.setAvailable(isAvailable);
            return bookRepository.save(book);
        }else {
            return null;
        }
    }

}

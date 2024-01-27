package com.online.bookstore.controller;

import com.online.bookstore.mapper.Mapper;
import com.online.bookstore.model.Administrator;
import com.online.bookstore.model.Book;
import com.online.bookstore.model.BorrowRecord;
import com.online.bookstore.model.Customer;
import com.online.bookstore.service.*;
import com.online.bookstore.util.AppConstant;
import com.online.bookstore.dto.AdministratorDTO;
import com.online.bookstore.dto.BookDTO;
import com.online.bookstore.dto.BorrowRecordDTO;
import com.online.bookstore.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookStoreController {

    private final CustomerService customerService;
    private final BookService bookService;
    private final BorrowRecordService borrowRecordService;
    private final AdministratorService administratorService;
    private final RecommendationService recommendationService;
    private final BrowsingHistoryService browsingHistoryService;

    @Autowired
    public BookStoreController(CustomerService customerService, BookService bookService,
                               BorrowRecordService borrowRecordService, AdministratorService administratorService, RecommendationService recommendationService, BrowsingHistoryService browsingHistoryService) {
        this.customerService = customerService;
        this.bookService = bookService;
        this.borrowRecordService = borrowRecordService;
        this.administratorService = administratorService;
        this.recommendationService = recommendationService;
        this.browsingHistoryService = browsingHistoryService;
    }


    // Book Endpoints

    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
           return   ResponseEntity.ok(Mapper.mapBookListToDTOList(books));
    }


    // Administrator Endpoints

    @GetMapping("/admin")
    public ResponseEntity<List<AdministratorDTO>> getAllAdministrators() {
        List<Administrator> administrators = administratorService.getAllAdministrators();
         return ResponseEntity.ok(Mapper.mapAdministratorListToDTOList(administrators));
    }
     @PostMapping("/admin/books")
    public ResponseEntity<BookDTO> addBook(@RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        return new ResponseEntity<>(Mapper.mapBookToDTO(newBook), HttpStatus.CREATED);
    }

    // Add multiple books
    @PostMapping("/admin/books/batch")
    public ResponseEntity<List<BookDTO>> addBooks(@RequestBody List<Book> books) {
        List<Book> newBooks = bookService.addBooks(books);
        return new ResponseEntity<>(Mapper.mapBookListToDTOList(newBooks), HttpStatus.CREATED);
    }

    // Update book details
    @PutMapping("/admin/books/{bookId}")
    public ResponseEntity<BookDTO> updateBookDetails(@PathVariable Long bookId, @RequestBody Book updatedBook) {
        Book updatedBookDetails = bookService.updateBookDetails(bookId, updatedBook);
        if (updatedBookDetails != null) {
            return ResponseEntity.ok(Mapper.mapBookToDTO(updatedBookDetails));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a book by ID
    @DeleteMapping("/admin/deleteBook/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {

        Book book = bookService.getBookById(bookId);
        if (book != null) {
            bookService.deleteBook(bookId);
            return new ResponseEntity<>(AppConstant.SUCCESS_PROCESS_MSG,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(AppConstant.NOT_FOUND_MSG,HttpStatus.NOT_FOUND);
        }


    }

    // Delete multiple books by IDs
    @DeleteMapping("/admin/deleteBooks")
    public ResponseEntity<String> deleteBooks(@RequestParam List<Long> bookIds) {
        List<Book> books = bookService.getBooksByIds(bookIds);
        if (!books.isEmpty()) {
            bookService.deleteBooks(bookIds);
            return new ResponseEntity<>(AppConstant.SUCCESS_PROCESS_MSG,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(AppConstant.NOT_FOUND_MSG,HttpStatus.NOT_FOUND);
        }

    }


    // Update stock levels using RequestParam
    @PutMapping("/admin/inventory/{bookId}")
    public ResponseEntity<BookDTO> updateStockLevels(@PathVariable Long bookId, @RequestParam int newStockLevel ) {
        Book updatedBook = bookService.updateStock(bookId, newStockLevel);
        if (updatedBook != null) {
            return ResponseEntity.ok(Mapper.mapBookToDTO(updatedBook));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

   // Update stock levels using PathVariable
    @PutMapping("/admin/{bookId}/inventory/{newStockLevel}")
    public ResponseEntity<BookDTO> updateStockLevelPath(@PathVariable Long bookId, @PathVariable int newStockLevel) {
        Book updatedBook = bookService.updateStock(bookId, newStockLevel);
        if (updatedBook != null) {
            return ResponseEntity.ok(Mapper.mapBookToDTO(updatedBook));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Set book availability using RequestParam
    @PutMapping("/admin/inventory/availability/{bookId}")
    public ResponseEntity<BookDTO> setBookAvailability(@PathVariable Long bookId,@RequestParam boolean isAvailable) {
        Book updatedBook = bookService.setBookAvailability(bookId, isAvailable);
        if (updatedBook != null) {
            return ResponseEntity.ok(Mapper.mapBookToDTO(updatedBook));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Set book availability using PathVariable
    @PutMapping("/admin/inventory/{bookId}/availability/{isAvailable}")
    public ResponseEntity<BookDTO> setBookAvailabilityPath(@PathVariable Long bookId, @PathVariable boolean isAvailable) {
        Book updatedBook = bookService.setBookAvailability(bookId, isAvailable);
        if (updatedBook != null) {
            return ResponseEntity.ok(Mapper.mapBookToDTO(updatedBook));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Customer Endpoints

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(Mapper.mapCustomerListToDTOList(customers),HttpStatus.OK);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer != null) {
            return ResponseEntity.ok( Mapper.mapCustomerToDTO(customer));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(Mapper.mapCustomerToDTO(newCustomer), HttpStatus.CREATED);

    }


    // Get books by genre
    @GetMapping("/customers/books/categories")
    public ResponseEntity<List<BookDTO>> getBooksByGenre(@RequestParam String genre,@RequestParam Long customerId) {
        List<Book> books = bookService.getBooksByGenre(genre);
        Customer customer = customerService.getCustomerById(customerId);
        browsingHistoryService.addBrowsingHistory(customer,genre);
        return ResponseEntity.ok(Mapper.mapBookListToDTOList(books));
    }


    @GetMapping("/customers/books/{bookId}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long bookId,@RequestParam Long customerId) {
        Book book = bookService.getBookById(bookId);
        Customer customer = customerService.getCustomerById(customerId);
        browsingHistoryService.addBrowsingHistory(customer, book.getGenre());
        if (book != null) {
            return ResponseEntity.ok(Mapper.mapBookToDTO(book));
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    // Request to borrow a book
    @PostMapping("/customers/books/borrow")
    public ResponseEntity<BorrowRecordDTO> requestBookForBorrowing(@RequestParam Long customerId, @RequestParam Long bookId) {

        Customer customer = customerService.getCustomerById(customerId);
        Book book = bookService.getBookById(bookId);

        // Customer or book not found
        if (customer == null || book == null) {
            return ResponseEntity.notFound().build();
        }

        BorrowRecord existingBorrowRecord = borrowRecordService.getBorrowRecordByBookAndCustomer(book, customer);

        // Customer has already requested or borrowed this book and not returned it yet.
        if (existingBorrowRecord != null && !isReturned(existingBorrowRecord)) {
            return new ResponseEntity<>(Mapper.mapBorrowRecordToDTO(existingBorrowRecord),HttpStatus.FOUND);
        }

        BorrowRecord newBorrowRecord = bookService.requestBookForBorrowing(customer, book);

            if (newBorrowRecord != null) {
                BorrowRecordDTO borrowRecordDTO = Mapper.mapBorrowRecordToDTO(newBorrowRecord);
                return ResponseEntity.ok(borrowRecordDTO);

            } else {
                // Book is not available for borrowing
                return ResponseEntity.notFound().build();
            }
    }

    private boolean isReturned(BorrowRecord borrowRecord) {
        String status = borrowRecord.getStatus();
        return AppConstant.STATUS_RETURNED.equals(status);
    }


    // Manage borrowing date
      @PutMapping("/customers/books/borrow/{borrowRecordId}")
    public ResponseEntity<BorrowRecordDTO> manageBorrowing(@PathVariable Long borrowRecordId,@RequestParam String newBorrowDateString) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date newBorrowDate = format.parse(newBorrowDateString);

        BorrowRecord borrowRecord = bookService.getBorrowRecordById(borrowRecordId);
        if (borrowRecord != null) {
            BorrowRecordDTO borrowRecordDTO=Mapper.mapBorrowRecordToDTO(bookService.manageBorrowingDate(borrowRecord, newBorrowDate));
            return ResponseEntity.ok(borrowRecordDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Manage return date
    @PutMapping("/customers/books/return/{borrowRecordId}")
    public ResponseEntity<BorrowRecordDTO> manageReturning(@PathVariable Long borrowRecordId, @RequestParam String newReturnDateString) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date newReturnDate = format.parse(newReturnDateString);

        BorrowRecord borrowRecord = bookService.getBorrowRecordById(borrowRecordId);
        if (borrowRecord != null) {
            BorrowRecordDTO boBorrowRecordDTO=Mapper.mapBorrowRecordToDTO(bookService.manageReturnDate(borrowRecord, newReturnDate));
            return ResponseEntity.ok(boBorrowRecordDTO);
        } else {
            return ResponseEntity.notFound().build();// BorrowRecord not found
        }
    }


    // Borrow Record Endpoints
    @GetMapping("/customers/books/borrow-records")
    public ResponseEntity<List<BorrowRecordDTO>> getAllBorrowRecords() {
        List<BorrowRecord> borrowRecords = borrowRecordService.getAllBorrowRecords();
        return ResponseEntity.ok(Mapper.mapBorrowRecordListToDTOList(borrowRecords));
    }


    @GetMapping("/customers/books/recommendedBooks")
    public ResponseEntity<List<BookDTO>> getRecommendedBooks(@RequestParam Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);

        if (customer != null) {
            List<Book> recommendedBooks = recommendationService.getRecommendedBooks(customer);
            return ResponseEntity.ok(Mapper.mapBookListToDTOList(recommendedBooks));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}

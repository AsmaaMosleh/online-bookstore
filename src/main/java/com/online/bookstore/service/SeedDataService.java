package com.online.bookstore.service;

import com.online.bookstore.model.Administrator;
import com.online.bookstore.model.Book;
import com.online.bookstore.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SeedDataService {

    private final BookService bookService;
    private final CustomerService customerService;

    private final AdministratorService administratorService;
    private final BorrowRecordService borrowRecordService;

    private final BrowsingHistoryService browsingHistoryService;

    @Autowired
    public SeedDataService(BookService bookService, CustomerService customerService, AdministratorService administratorService, BorrowRecordService borrowRecordService, BrowsingHistoryService browsingHistoryService) {
        this.bookService = bookService;
        this.customerService = customerService;
        this.administratorService = administratorService;
        this.borrowRecordService = borrowRecordService;
        this.browsingHistoryService = browsingHistoryService;
    }

    public void clearAll()
    {
        browsingHistoryService.deleteBrowsingHistory();
        borrowRecordService.deleteBorrowRecords();
        bookService.deleteBooks();
        customerService.deleteCustomers();
        administratorService.deleteAdministrators();
    }
    public void seedData() {

        //Clear All Data
        clearAll();

        // Adding sample books
        Book book1 = new Book("Title 1", "Author 1", "Science Fiction", "ISBN 1", 10, true);
        Book book2 = new Book("Title 2", "Author 2", "Historical", "ISBN 2", 15, true);
        Book book3 = new Book("Title 3", "Author 3", "Thrill", "ISBN 3", 8, true);
        Book book4 = new Book("Title 4", "Author 4", "Horror", "ISBN 4", 10, true);
        Book book5 = new Book("Title 5", "Author 5", "Historical", "ISBN 5", 15, true);
        Book book6 = new Book("Title 6", "Author 6", "Science Fiction", "ISBN 6", 8, true);
        Book book7 = new Book("Title 7", "Author 7", "Historical", "ISBN 7", 12, true);
        Book book8 = new Book("Title 8", "Author 8", "Thrill", "ISBN 8", 15, true);
        Book book9 = new Book("Title 9", "Author 9", "Horror", "ISBN 9", 6, true);

        bookService.addBooks(Arrays.asList(book1, book2, book3,book4,book5,book6,book7,book8,book9));

        Customer customer1=new Customer("asmaa_mosleh", "1234","asmaa.mosleh2014@gmail.com", "Asmaa",  "Mosleh");
        Customer customer2=new Customer("ahmed_144", "1234","ahmed.mohammed@gmail.com", "Ahmed",  "Ali");
        Customer customer3=new Customer("moh_2024", "1234","ali.mohammed@gmail.com", "Mohammed",  "Mohammed");
        Customer customer4=new Customer("noura_2024", "1234","noura@gmail.com", "Noura",  "Mohammed");


        customerService.addCustomers(Arrays.asList(customer1,customer2,customer3,customer4));

        Administrator admin1=new Administrator("admin1", "1234", "admin1@gmail.com", "firstName1","lastName1");
        Administrator admin2=new Administrator("admin2", "1234", "admin2@gmail.com", "firstName2","lastName2");
        Administrator admin3=new Administrator("admin3", "1234", "admin3@gmail.com", "firstName3","lastName3");

        administratorService.addAdministrators(Arrays.asList(admin1,admin2,admin3));
    }
}

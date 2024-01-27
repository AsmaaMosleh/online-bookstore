package com.online.bookstore.mapper;

import com.online.bookstore.model.Administrator;
import com.online.bookstore.model.Book;
import com.online.bookstore.model.BorrowRecord;
import com.online.bookstore.model.Customer;
import com.online.bookstore.dto.AdministratorDTO;
import com.online.bookstore.dto.BookDTO;
import com.online.bookstore.dto.BorrowRecordDTO;
import com.online.bookstore.dto.CustomerDTO;

import java.util.List;

public class Mapper {

    private Mapper() {
    }

    public static AdministratorDTO mapAdministratorToDTO(Administrator admin)
    {
        AdministratorDTO administratorDTO=new AdministratorDTO();
        administratorDTO.setAdminID(admin.getAdminID());
        administratorDTO.setEmail(admin.getEmail());
        administratorDTO.setPassword(admin.getPassword());
        administratorDTO.setLastName(admin.getLastName());
        administratorDTO.setFirstName(admin.getFirstName());
        administratorDTO.setAdminName(admin.getAdminName());

        return administratorDTO;
    }

    public static List<AdministratorDTO> mapAdministratorListToDTOList(List<Administrator> administrators) {
        return administrators.stream()
                .map(Mapper::mapAdministratorToDTO)
                .toList();
    }

    public static BookDTO mapBookToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookId(book.getBookID());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setGenre(book.getGenre());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setQuantityAvailable(book.getQuantityAvailable());
        // Set the isAvailable property based on your business logic
        bookDTO.setAvailable(book.isAvailable()); // Example: Book is available if quantity is greater than 0
        return bookDTO;
    }

    public static List<BookDTO> mapBookListToDTOList(List<Book> books) {
        return books.stream()
                .map(Mapper::mapBookToDTO)
                .toList();
    }

    public static BorrowRecordDTO mapBorrowRecordToDTO(BorrowRecord borrowRecord) {
        BorrowRecordDTO borrowRecordDTO = new BorrowRecordDTO();
        borrowRecordDTO.setBorrowID(borrowRecord.getBorrowID());
        borrowRecordDTO.setBook(borrowRecord.getBook());
        borrowRecordDTO.setCustomer(borrowRecord.getCustomer());
        borrowRecordDTO.setBorrowDate(borrowRecord.getBorrowDate());
        borrowRecordDTO.setReturnDate(borrowRecord.getReturnDate());
        borrowRecordDTO.setRequestDate(borrowRecord.getRequestDate());
        borrowRecordDTO.setStatus(borrowRecord.getStatus());
        return borrowRecordDTO;
    }

    public static List<BorrowRecordDTO> mapBorrowRecordListToDTOList(List<BorrowRecord> borrowRecords) {
        return borrowRecords.stream()
                .map(Mapper::mapBorrowRecordToDTO)
                .toList();
    }

    public static CustomerDTO mapCustomerToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerID(customer.getCustomerID());
        customerDTO.setCustomerName(customer.getCustomerName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        return customerDTO;
    }

    public static List<CustomerDTO> mapCustomerListToDTOList(List<Customer> customers) {
        return customers.stream()
                .map(Mapper::mapCustomerToDTO)
                .toList();
    }
    // Add getter and setter methods for each DTO

    public static BookDTO getBookDTO() {
        return new BookDTO();
    }

    public static BorrowRecordDTO getBorrowRecordDTO() {
        return new BorrowRecordDTO();
    }

    public static CustomerDTO getCustomerDTO() {
        return new CustomerDTO();
    }

    public static AdministratorDTO getAdministratorDTO() {
        return new AdministratorDTO();
    }

}

package com.online.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BorrowID")
    private Long borrowID;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "BookID")
    private Book book;

    @Column(name = "RequestDate")
    private Date requestDate;

    @Column(name = "BorrowDate")
    private Date borrowDate;

    @Column(name = "ReturnDate")
    private Date returnDate;

    @Column(name = "Status") //  "BORROWED", "RETURNED"
    private String status;

    public BorrowRecord(Customer customer, Book book,Date requestDate, Date borrowDate, Date returnDate, String status) {
        this.customer = customer;
        this.book = book;
        this.requestDate=requestDate;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }
}

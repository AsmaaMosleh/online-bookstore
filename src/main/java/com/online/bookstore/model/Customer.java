package com.online.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private Long customerID;

    @Column(name = "CustomerName", unique = true)
    private String customerName;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<BorrowRecord> borrowRecords;

    public Customer(String customerName, String password, String email, String firstName, String lastName) {
        this.customerName = customerName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String customerName, String password, String email, String firstName, String lastName, List<BorrowRecord> borrowRecords) {
        this.customerName = customerName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.borrowRecords = borrowRecords;
    }
}



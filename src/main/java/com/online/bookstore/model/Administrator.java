package com.online.bookstore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AdminID")
    private Long adminID;

    @Column(name = "AdminName", unique = true)
    private String adminName;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    public Administrator(String adminName, String password, String email, String firstName, String lastName) {
        this.adminName = adminName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

package com.online.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookID")
    private Long bookID;

    @Column(name = "Title")
    private String title;

    @Column(name = "Author")
    private String author;

    @Column(name = "Genre")
    private String genre;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "QuantityAvailable")
    private int quantityAvailable;

    @Column(name = "IsAvailable")
    private boolean isAvailable;

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    private List<BorrowRecord> borrowRecords;


    public Book(String title, String author, String genre, String isbn,int quantityAvailable, boolean isAvailable) {
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.isbn=isbn;
        this.quantityAvailable=quantityAvailable;
        this.isAvailable=isAvailable;

    }
}

package com.online.bookstore.dto;

public class BookDTO {

    private Long bookId;
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private int quantityAvailable;
    private boolean isAvailable;

    // Constructors, getters, and setters...

    public BookDTO() {
    }

    public BookDTO(Long bookId, String title, String author, String genre, String isbn, int quantityAvailable, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.quantityAvailable = quantityAvailable;
        this.isAvailable = isAvailable;
    }

    // Getters and setters...

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}


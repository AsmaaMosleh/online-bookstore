package com.online.bookstore.service;

import com.online.bookstore.model.Book;
import com.online.bookstore.model.Customer;

import java.util.List;

public interface RecommendationService {

    List<Book> getRecommendedBooks(Customer customer);

}

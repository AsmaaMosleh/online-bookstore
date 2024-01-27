package com.online.bookstore.repository;

import com.online.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByGenreIgnoreCase(String genre);

    List<Book> findByGenreInIgnoreCase(List<String> genres);
}

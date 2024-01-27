package com.online.bookstore.service.serviceimpl;

import com.online.bookstore.model.Book;
import com.online.bookstore.model.BorrowRecord;
import com.online.bookstore.model.BrowsingHistory;
import com.online.bookstore.model.Customer;
import com.online.bookstore.repository.BookRepository;
import com.online.bookstore.repository.BorrowRecordRepository;
import com.online.bookstore.repository.BrowsingHistoryRepository;
import com.online.bookstore.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final BrowsingHistoryRepository browsingHistoryRepository;
    private final BorrowRecordRepository borrowRecordRepository;
    private final BookRepository bookRepository;

    @Autowired
    public RecommendationServiceImpl(BrowsingHistoryRepository browsingHistoryRepository, BorrowRecordRepository borrowRecordRepository, BookRepository bookRepository) {
        this.browsingHistoryRepository = browsingHistoryRepository;
        this.borrowRecordRepository = borrowRecordRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> getRecommendedBooks(Customer customer) {
        //Get the browsing and borrowing history for specific customer.
        List<String> genresFromBorrowingHistory  = getGenresFromBorrowingHistory(customer);
        List<String> genresFromBrowsingHistory = getGenresFromBrowsingHistory(customer);


        // Combine and deduplicate genres from both histories
        List<String> allGenres = Stream.concat(genresFromBrowsingHistory.stream(), genresFromBorrowingHistory.stream())
                .distinct()
                .toList();


        // Fetch books from the BookRepository based on recommended genres
        List<Book> test=bookRepository.findByGenreInIgnoreCase(allGenres);
        return bookRepository.findByGenreInIgnoreCase(allGenres);

    }

    private List<String> getGenresFromBorrowingHistory(Customer customer) {
        //Get the borrowing history for specific customer.
        List<BorrowRecord> borrowingHistory  = borrowRecordRepository.findByCustomer(customer);

        // Extract genres of books from the customer's borrowing history
        return borrowingHistory.stream()
                .map(borrowRecord -> borrowRecord.getBook().getGenre())
                .distinct()
                .toList();
    }

    private List<String> getGenresFromBrowsingHistory(Customer customer) {
        //Get the browsing history for specific customer.
        List<BrowsingHistory> browsingHistory = browsingHistoryRepository.findByCustomer(customer);

        // Extract genres of books from the customer's browsing history
        return browsingHistory.stream()
                .map(BrowsingHistory::getGenre)
                .distinct()
                .toList();
    }

}

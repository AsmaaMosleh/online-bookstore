package com.online.bookstore.service.serviceimpl;

import com.online.bookstore.model.BrowsingHistory;
import com.online.bookstore.model.Customer;
import com.online.bookstore.repository.BrowsingHistoryRepository;
import com.online.bookstore.service.BrowsingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BrowsingHistoryServiceImp implements BrowsingHistoryService {

    private final BrowsingHistoryRepository browsingHistoryRepository;

    @Autowired
    public BrowsingHistoryServiceImp(BrowsingHistoryRepository browsingHistoryRepository) {
        this.browsingHistoryRepository = browsingHistoryRepository;
    }

    @Override
    public void addBrowsingHistory(Customer customer, String genre) {

        BrowsingHistory browsingHistory=new BrowsingHistory(customer,genre);

        browsingHistoryRepository.save(browsingHistory);
    }

    @Override
    public void deleteBrowsingHistory() {
        browsingHistoryRepository.deleteAll();
    }
}

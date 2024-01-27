package com.online.bookstore.service;

import com.online.bookstore.model.Customer;


public interface BrowsingHistoryService {
    void addBrowsingHistory(Customer customer,String genre);
    void deleteBrowsingHistory();

}

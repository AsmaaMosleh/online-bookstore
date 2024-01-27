package com.online.bookstore.service;

import com.online.bookstore.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long customerId);

    Customer addCustomer(Customer customer);

    List<Customer> addCustomers(List<Customer> customer);

    void deleteCustomers();


}

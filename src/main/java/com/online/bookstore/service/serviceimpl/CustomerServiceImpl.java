package com.online.bookstore.service.serviceimpl;

import com.online.bookstore.model.Customer;
import com.online.bookstore.repository.BorrowRecordRepository;
import com.online.bookstore.repository.CustomerRepository;
import com.online.bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, BorrowRecordRepository borrowRecordRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        // Implement logic for adding a new customer
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> addCustomers(List<Customer> customers) {

        return customerRepository.saveAll(customers);
    }

    @Override
    public void deleteCustomers() {
        customerRepository.deleteAll();
    }

}


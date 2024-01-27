package com.online.bookstore.service;

import com.online.bookstore.model.Administrator;

import java.util.List;

public interface AdministratorService {

    List<Administrator> getAllAdministrators();

    Administrator addAdministrator(Administrator administrator);

    List<Administrator> addAdministrators(List<Administrator> administrator);

    void deleteAdministrators();

}

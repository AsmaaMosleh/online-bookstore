package com.online.bookstore.service.serviceimpl;

import com.online.bookstore.model.Administrator;
import com.online.bookstore.repository.AdministratorRepository;
import com.online.bookstore.service.AdministratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorServiceImpl(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public List<Administrator> getAllAdministrators() {
        return administratorRepository.findAll();
    }

    @Override
    public Administrator addAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    @Override
    public List<Administrator> addAdministrators(List<Administrator> administrators) {
        return administratorRepository.saveAll(administrators);
    }

    @Override
    public void deleteAdministrators() {
        administratorRepository.deleteAll();
    }

}

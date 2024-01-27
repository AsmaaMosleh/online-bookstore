package com.online.bookstore.dto;

public class AdministratorDTO {
    private Long adminID;

    private String adminName;

    private String password;

    private String email;


    private String firstName;

    private String lastName;

    public AdministratorDTO(){

    }
    public AdministratorDTO(Long adminID,String adminName, String password, String email, String firstName, String lastName) {
        this.adminID=adminID;
        this.adminName = adminName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getAdminID() {
        return adminID;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

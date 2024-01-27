# Online Bookstore Management System

This project is an Online Book Store BORROW Management System that enables customers to browse, request, borrow, and return books. It also provides administrators with the ability to manage the book inventory.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Setup](#setup)
- [API Endpoints](#api-endpoints)
- [Usage](#usage)
- [Contributors](#contributors)
- [License](#license)

## Features

- Browse through available books.
- Request books for borrowing.
- Borrow and return books.
- Administer the inventory (add or delete books).
- Suggest related books based on a customer's browsing and borrowing history.


## Technologies Used

- Java Development Kit (JDK) 17
- Spring Boot 2.6.0 or later
- Hibernate (JPA)
- Maven or Gradle build tool
- MySQL database


## Project Structure

The project is organized as follows:

- **src/main/java/com.online.bookstore**: Contains the main application code.
  - **controller**: Spring MVC controllers.
  - **service**: Service interfaces and implementations.
  - **repository**: JPA repositories.
  - **model**: Entity classes.
  - **dto**: Data Transfer Object classes.
  - **mapper**: Mapping Entity classes to DTOs.
  - **util**: Contains application Constants.

- **src/main/resources**: Contains application properties.

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/AsmaaMosleh/online-bookstore.git
   ```

2. Configure the database connection in src/main/resources/application.properties.

3. Open the project in your preferred IDE (IntelliJ IDEA, Eclipse, etc.).

4. Build the project using Maven or Gradle.

5. Run the application:
   ```bash
      ./mvnw spring-boot:run
   ```

   or
  
   ```bash
      mvn spring-boot:run
   ```

6. The application will start, and you can access the REST APIs using Swagger at

   ```bash
      http://localhost:8080/swagger-ui/index.html
   ```


## API Endpoints
**Note: The date format for borrowing and returning dates is "yyyy-MM-dd HH:mm"**

- **/api/books**: Get all books.

- **/api/customers/books/{bookId}**: View book Details.
  
- **/api/customers/books/borrow**: Request a book for borrowing.

- **/api/customers/books/borrow/{borrowRecordId}**: Borrow a requested book and its reflection on inventory.
                                                 
- **/api/customers/books/return/{borrowRecordId}**: Return a borrowed book and its reflection on inventory.
                                              
- **/api/admin/inventory/{bookId}**: Update Stock Levels for a specific book.

-  **/api/admin/inventory/availability/{bookId}**: Set book availability for a specific book.

- **/api/customers/books/recommendedBooks** : Get recommended books based on browsing history. 

- **Access API EndPoints through Swagger URL**

    ```bash
       http://localhost:8080/swagger-ui/index.html
    ```

## Usage

**1-** Browse through the available books.

**2-** Request a book for borrowing.

**3-** Borrow the requested book, in addition to its reflection in inventory and the book's availability.

**4-** Return the borrowed book, in addition to its reflection in inventory and the book's availability.

**5-** Administrators can manage the inventory (e.g., update stock levels,and set book availability).

**6-** Administrators can add new books.

**7-** Administrators can update book details.

**8-** Customers can browse books by categories.

**9-** Customers can view book details.

**10-** A recommendation system that suggests related books based on a customer's browsing and borrowing history.


## Contributors
**-** Asmaa Mohammed Mosleh

   ```bash
      asmaa.mosleh2014@gmail.com
   ``` 

## License
This project is licensed under the **Banque Misr - Digital Factory** License.

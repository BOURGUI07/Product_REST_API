# Product Inventory Management API

This project is a REST API for managing products in an inventory system. It supports CRUD (Create, Read, Update, Delete) operations on a "Product" entity and is built using Spring Boot, Spring Web, Spring Data JPA, Spring Security, and Spring Data REST. Maven is used for dependency management, and Postman is used for testing the API endpoints.

## Technologies Used

- **Spring Boot**: For application configuration and setup.
- **Spring Web**: To define REST endpoints.
- **Spring Data JPA**: For database interactions.
- **Spring Security**: To handle authentication and authorization.
- **Spring Data REST**: For easy integration with RESTful services.
- **Maven**: For managing project dependencies.
- **Postman**: For testing the API endpoints.

## Access Roles

- **Employer**: Can view product details and list products.
- **Manager**: Can create, update, and view product details and list products.
- **Admin**: Can perform all CRUD operations (create, read, update, delete) on products.

## User Requirement Story for a REST API Performing CRUD Operations on a "Product" Entity

### Introduction
As a boss overseeing a project that requires a REST API for managing products in an inventory system, I need a detailed user requirement story that outlines the necessary CRUD (Create, Read, Update, Delete) operations for a "Product" entity.

### Functional Requirements

1. **Create Product**
   - **Endpoint**: `POST /products`
   - **Description**: Allows users to create a new product in the inventory.
   - **Request Body**:
     ```json
     {
       "name": "string",
       "description": "string",
       "price": "number",
       "quantity": "integer"
     }
     ```
   - **Response**:
     - `201 Created`: Product successfully created.
     - `400 Bad Request`: Invalid input data.
   - **Permissions**: Only Managers and Admins can create products.
   - **Implementation**: 
     - **Spring Boot**, **Spring Web**, **Spring Data JPA**, **Spring Security**, **Spring Data REST**, **Maven**, **Postman**.

2. **Read Product**
   - **Endpoint**: `GET /products/{id}`
   - **Description**: Retrieves details of a specific product by its ID.
   - **Response**:
     ```json
     {
       "id": "integer",
       "name": "string",
       "description": "string",
       "price": "number",
       "quantity": "integer"
     }
     ```
     - `200 OK`: Product details retrieved successfully.
     - `404 Not Found`: Product with the specified ID does not exist.
   - **Permissions**: All roles (Employer, Manager, Admin) can view product details.
   - **Implementation**: 
     - **Spring Boot**, **Spring Web**, **Spring Data JPA**, **Spring Security**, **Spring Data REST**, **Maven**, **Postman**.

3. **Update Product**
   - **Endpoint**: `PUT /products/{id}`
   - **Description**: Updates details of an existing product.
   - **Request Body**:
     ```json
     {
       "name": "string",
       "description": "string",
       "price": "number",
       "quantity": "integer"
     }
     ```
   - **Response**:
     - `200 OK`: Product successfully updated.
     - `400 Bad Request`: Invalid input data.
     - `404 Not Found`: Product with the specified ID does not exist.
   - **Permissions**: Only Managers and Admins can update products.
   - **Implementation**: 
     - **Spring Boot**, **Spring Web**, **Spring Data JPA**, **Spring Security**, **Spring Data REST**, **Maven**, **Postman**.

4. **Delete Product**
   - **Endpoint**: `DELETE /products/{id}`
   - **Description**: Deletes a specific product from the inventory by its ID.
   - **Response**:
     - `200 OK`: Product successfully deleted.
     - `404 Not Found`: Product with the specified ID does not exist.
   - **Permissions**: Only Admins can delete products.
   - **Implementation**: 
     - **Spring Boot**, **Spring Web**, **Spring Data JPA**, **Spring Security**, **Spring Data REST**, **Maven**, **Postman**.

5. **List Products**
   - **Endpoint**: `GET /products`
   - **Description**: Retrieves a list of all products, optionally filtered by category.
   - **Query Parameters**:
     - `category` (optional): Filter products by category.
   - **Response**:
     ```json
     [
       {
         "id": "integer",
         "name": "string",
         "description": "string",
         "price": "number",
         "quantity": "integer"
       },
       ...
     ]
     ```
     - `200 OK`: List of products retrieved successfully.
   - **Permissions**: All roles (Employer, Manager, Admin) can view the product list.
   - **Implementation**: 
     - **Spring Boot**, **Spring Web**, **Spring Data JPA**, **Spring Security**, **Spring Data REST**, **Maven**, **Postman**.

### Example Scenarios

1. **Scenario 2: Viewing a Product**
   - Sales Representative sends a `GET /products/5` request.
   - The system retrieves the product details and returns them in a `200 OK` response.

2. **Scenario 3: Updating a Product**
   - Inventory Manager sends a `PUT /products/3` request with updated details.
   - The system validates the input, updates the product, and returns a `200 OK` response.

3. **Scenario 4: Deleting a Product**
   - Admin sends a `DELETE /products/7` request.
   - The system deletes the product and returns a `200 OK` response.

4. **Scenario 5: Listing Products**
   - User sends a `GET /products` request with an optional `category=electronics` query parameter.
   - The system returns a list of all products, filtered by category if specified, in a `200 OK` response.

### Conclusion
This user requirement story outlines the essential functionalities and considerations for a REST API managing a "Product" entity. The API supports all necessary CRUD operations, enforces appropriate security measures, and provides robust performance and scalability to meet the needs of different user roles. The technology stack includes Spring Boot, Spring Web, Spring Data JPA, Spring Security, Spring Data REST, Maven, and Postman for testing.

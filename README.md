# 🌟 Charm Management System

A comprehensive backend application built with **Spring Boot** that demonstrates enterprise-level architecture patterns and best practices. This project showcases a complete charm collection system where users can create and organize magical charms into categories.

## 🎯 What You'll Gain

This project demonstrates mastery of:

### 🏗️ **N-Tier Architecture**
- **Presentation Layer**: RESTful controllers with clean API design
- **Business Logic Layer**: Service classes with transaction management
- **Data Access Layer**: Repository pattern with JPA/Hibernate
- **Database Layer**: Relational database with proper normalization

### 🗺️ **Advanced Mapping & Relationships**
- **One-to-Many**: User → Charms, Category → Charms
- **Many-to-One**: Charm → User, Charm → Category
- **Bidirectional Relationships**: Proper entity mapping with cascade operations
- **JPA Annotations**: `@OneToMany`, `@ManyToOne`, `@JoinColumn`

### 💾 **Sophisticated Database Operations**
- **CRUD Operations**: Complete Create, Read, Update, Delete functionality
- **Transaction Management**: `@Transactional` for data consistency
- **Relationship Management**: Adding/removing entities from collections
- **Query Optimization**: Efficient database queries with proper joins

### 🚀 **Strong Backend Institution**
- **Spring Boot Framework**: Industry-standard enterprise framework
- **Dependency Injection**: Loose coupling with `@Autowired`
- **Exception Handling**: Proper error management and validation
- **RESTful Design**: Following REST principles and HTTP standards
- **Service Layer Pattern**: Separation of concerns and business logic encapsulation

## 🎮 Features

### ✨ **Core Entities**

#### 👤 **User Management**
- Create users with unique profiles
- Manage user information and preferences
- View user's charm collection

#### 🔮 **Charm System**
- Create magical charms with custom properties
- Assign charms to users
- Organize charms by categories
- Full lifecycle management (create, update, delete)

#### 📁 **Category Organization**
- Create themed categories for charms
- Organize charms systematically
- Maintain category hierarchies
- Bulk operations on categorized charms

### 🔄 **Relationship Operations**
- **Add Charm to User**: `POST /users/{userId}/charms/{charmId}`
- **Remove Charm from User**: `DELETE /users/{userId}/charms/{charmId}`
- **Add Charm to Category**: `POST /categories/{categoryId}/charms/{charmId}`
- **Remove Charm from Category**: `DELETE /categories/{categoryId}/charms/{charmId}`

## 🏛️ **Architecture Overview**

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Controllers   │────│    Services     │────│  Repositories   │
│  (REST Layer)   │    │ (Business Logic)│    │ (Data Access)   │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                       │                       │
         └───────────────────────┼───────────────────────┘
                                 │
                    ┌─────────────────┐
                    │    Database     │
                    │   (Persistence) │
                    └─────────────────┘
```

## 🛠️ **Technology Stack**

- **Framework**: Spring Boot 3.x
- **Language**: Java 17+
- **Database**: H2/MySQL/PostgreSQL
- **ORM**: JPA/Hibernate
- **Build Tool**: Maven/Gradle
- **Testing**: JUnit 5, Mockito
- **Documentation**: Swagger/OpenAPI

## 📊 **Database Schema**

```sql
Users                  Charms                Categories
┌─────────────┐       ┌─────────────┐       ┌─────────────┐
│ id (PK)     │   ┌───│ id (PK)     │       │ id (PK)     │
│ name        │   │   │ name        │   ┌───│ name        │
│ email       │   │   │ description │   │   │ description │
│ created_at  │   │   │ user_id (FK)│───┘   │ created_at  │
└─────────────┘   │   │category_id  │───────│             │
                  │   │ created_at  │       └─────────────┘
                  └───│             │
                      └─────────────┘
```

## 🚀 **Getting Started**

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Database (H2 for development)

### Quick Start
```bash
# Clone the repository
git clone <your-repo-url>

# Navigate to project directory
cd charm-management-system

# Install dependencies
mvn clean install

# Run the application
mvn spring-boot:run
```

### API Endpoints
```bash
# User Operations
GET    /users              # Get all users
POST   /users              # Create user
GET    /users/{id}         # Get user by ID
PUT    /users/{id}         # Update user
DELETE /users/{id}         # Delete user

# Charm Operations  
GET    /charms             # Get all charms
POST   /charms             # Create charm
GET    /charms/{id}        # Get charm by ID
PUT    /charms/{id}        # Update charm
DELETE /charms/{id}        # Delete charm

# Category Operations
GET    /categories         # Get all categories
POST   /categories         # Create category
GET    /categories/{id}    # Get category by ID
PUT    /categories/{id}    # Update category
DELETE /categories/{id}    # Delete category

# Relationship Operations
POST   /users/{userId}/charms/{charmId}        # Add charm to user
DELETE /users/{userId}/charms/{charmId}        # Remove charm from user
POST   /categories/{categoryId}/charms/{charmId}   # Add charm to category  
DELETE /categories/{categoryId}/charms/{charmId}   # Remove charm from category
```

## 🎉 **Why This Project Rocks**

### 📚 **Learning Outcomes**
- **Enterprise Patterns**: Real-world software architecture
- **Spring Mastery**: Deep understanding of Spring ecosystem
- **Database Design**: Proper relational modeling
- **API Design**: RESTful services with best practices
- **Code Quality**: Clean, maintainable, and testable code

### 💼 **Professional Skills**
- **Scalable Architecture**: N-tier design for enterprise applications
- **Transaction Management**: Data consistency and integrity
- **Error Handling**: Robust exception management
- **Documentation**: Clear API documentation and code comments

## 🎈 **I Hope You Enjoy**

This project is designed to be both educational and enjoyable! You'll experience the satisfaction of building a complete backend system while learning industry-standard practices. Whether you're a beginner looking to understand enterprise architecture or an experienced developer wanting to see clean implementation patterns, this charm management system has something magical for everyone! ✨

---

**Happy Coding! 🚀**

*May your code be bug-free and your charms be powerful!* 🔮

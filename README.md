# Understanding Java Spring Initial Concepts

In this exercise, we'll explore a simple example: a cart with items. We have two entities, the `Cart` and `Item`. A cart can contain multiple items.

## Approach Without Spring Data JPA and Spring Data REST

Without Spring Boot, we would typically need to create the model for both entities and annotate them to establish a database connection.

Next, we'd create a DAO (Data Access Object) interface with basic CRUD methods like `findAll`, `findById`, `save` (including updates), and `delete`. These methods would be implemented in a DAO implementation class using an EntityManager to write queries.

A service layer would be created as an interface to manage the DAO and potential future DAOs, defining its own methods. To use these methods, we'd instantiate a new DAO object within the service layer.

A separate class, typically in a different package, called the Controller, would use the service layer methods to connect with endpoints using REST annotations.

The data flow would look something like this: **database > model > DAO > service layer > controller > browser requests**.

## Approach With Spring Data JPA and Spring Data REST

Now, here's the magic and the elegant part.

With Spring Data JPA, we can skip the DAO and service layer. Instead, we create a repository interface that extends `JpaRepository` and declares the entity class and its ID type, like this: `JpaRepository<EntityClass, Integer>`.

Simply add the `spring-boot-starter-data-rest` dependency to your POM file, and the REST controller layer is no longer needed!

With this approach, you only need:
- The entity class model.
- A repository interface that extends Spring Data JPA.

Spring Data JPA provides all the CRUD methods you need, and Spring Data REST automatically generates RESTful endpoints for your entities. You don't even need to declare them (unless you want something custom).

This approach significantly reduces code lines, simplifies package organization, and eliminates the need for interface and class relationships. It also makes it easier to extend the application by adding new entities and relationships.

> Note: This exercise is intended to reinforce recent learning. There may be some simplifications, and any feedback or corrections are welcome!

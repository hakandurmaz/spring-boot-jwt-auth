
![Java CI with Maven](https://github.com/hakandurmaz/spring-boot-jwt-auth/workflows/Java%20CI%20with%20Maven/badge.svg?branch=master)  
  
A detailed medium article will be ready soon.  
  
**Requirements**:  
  
- A running mongodb instance for repository.  
- JDK 8 or later  
  
**Running**:  
  
Run a mongodb instance

    docker run -d -p 27017:27017 --name mongodb mongo

  
  Run the application:

    mvn spring-boot:run

Test with Swagger2

> [http://localhost:8081/swagger-ui.html#/](http://localhost:8081/swagger-ui.html#/)

Create a new user with /signup and /login with your credentials, and it will returns the jwt token for you.
Test that jwt token with /hello endpoint by sending it in "Authorization" header.
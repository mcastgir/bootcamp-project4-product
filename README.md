# Project Product
> Microservice **Product** Bootcamp NTT Data

This project include:
- Spring Boot Web
- Spring Boot Data MongoDB
- RxJava Reactive
- Spring Cloud Config
- Spring Cloud Eureka Client
- Spring Cloud Bootstrap
- Spring Boot Actuator
- MockMvc Test
- JUnit
- Mockito
- SonarQube
- Lombok
- Github Actions
- Docker

### Docker

1. Create Image Config Server in Docker
```  
docker build -t product .
```

2. Create Container

```
docker run -p 8087:8087 --name product-instance --link config-server-instance:latest -d product:latest
```

### SonarQube

```
mvn clean verify sonar:sonar -Dsonar.projectKey=product -Dsonar.host.url=http://localhost:9093 -Dsonar.login=sqp_194dbb7e79d22946627cc2f72fb7049d97a1b786
```
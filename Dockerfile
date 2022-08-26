FROM openjdk:12-jdk
COPY "./target/product-0.0.1-SNAPSHOT.jar" "product.jar"
ENTRYPOINT ["java","-jar","product.jar"]
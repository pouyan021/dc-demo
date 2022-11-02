# dc-demo

```bash
git clone https://github.com/pouyan021/dc-demo.git
```

## Installation

You should have docker installed on your machine already in order to make project work.
once you make sure to have docker installed. run the following in project root folder:

```bash
cd docker
docker-compose up -d 
```

This will make a postgres sql instance with a database called ```book_store```
## execution
```
./mvnw clean package -DskipTests
```
The above command will make an executable jar and you can run it as follows:
```
java -jar target/double-coconut-demo-0.0.1-SNAPSHOT.jar
```
once you run the application all the tables will be generated by liquibase.
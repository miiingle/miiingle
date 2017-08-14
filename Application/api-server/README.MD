# API Server
The Brain of the Mingle System. 

## Responsibilities:
- Perform Queries against Neo4J, GCP DataStore, and MongoDB 
- Syncs Data to and from Firebase
- Closed system, should only be accessed via Firebase

## Configuration
- [AppEngine Flexible: Java Only](https://cloud.google.com/appengine/docs/flexible/java/dev-java-only)

### Development Setup
- Install Maven
- Install GCloud
- Install Neo4j
- Install MongoDB
- Setup IntelliJ IDEA

### Running Locally
```
mvn spring-boot:run
```

### Deploying
```
mvn clean appengine:deploy \
    -Dapp.deploy.version="v1-0" \
    -Dapp.deploy.promote=false
```
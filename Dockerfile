FROM openjdk:slim
ADD ./build/libs/desafioDocker-0.0.1-SNAPSHOT.jar desafioDocker
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo-coderhouse:27017/coderhouse", "-Djava.security.egd=file:/dev/./urandom","-jar","desafioDocker"]

FROM openjdk:8-jdk-alpine

RUN mkdir /jwtsamplekt

COPY build/libs/jwtsample-kt-0.0.1-SNAPSHOT.jar /jwtsamplekt/app.jar

WORKDIR /jwtsamplekt

CMD ["sh", "-c", "java -Dspring.profiles.active=$JAVA_ENV -Djava.security.egd=file:/dev/./urandom -Xms128m -Xmx512m -jar app.jar"]
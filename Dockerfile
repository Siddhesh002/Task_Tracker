#
# Build Stage
#

FROM maven:3.8.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
ENV SPRING_PROFILES_ACTIVE=dockerembbed,oauth-security
RUN mvn -f /home/app/pom.xml clean package
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/app/target/tracker.jar"]
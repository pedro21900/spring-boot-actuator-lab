FROM adoptopenjdk/openjdk11:alpine-jre

RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring

COPY target/*.jar spring-boot-actuator-lab-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "spring-boot-actuator-lab-0.0.1-SNAPSHOT.jar"]

HEALTHCHECK --interval=25s --timeout=3s --retries=2 CMD wget --spider http://localhost:8080/actuator/health/readiness || exit 1

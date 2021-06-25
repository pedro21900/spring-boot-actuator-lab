FROM reg.tre-pa.jus.br/library/maven:3.6-jdk-8 AS builder

RUN mkdir -p ./home/spring-boot-actuator-lab

#WORKDIR /home/.m2

#COPY .m2 .

WORKDIR /home/spring-boot-actuator-lab

COPY / .
#-s ~/.m2/settings@trepa.xml
RUN mvn clean package

FROM adoptopenjdk/openjdk11:alpine-jre

RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring

COPY --from=builder /home/spring-boot-actuator-lab/target/*.jar spring-boot-actuator-lab-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "spring-boot-actuator-lab-0.0.1-SNAPSHOT.jar"]

HEALTHCHECK --interval=25s --timeout=3s --retries=2 CMD wget --spider http://localhost:8080/actuator/health/readiness || exit 1

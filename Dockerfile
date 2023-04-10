# Docker Build Stage

FROM maven as build


# Build Stage
WORKDIR /opt/app

COPY ./ /opt/app
RUN mvn install 



# Docker Build Stage
FROM openjdk:11.0

COPY --from=build /opt/app/target/*.jar app.jar

ENV PORT 8081
EXPOSE $PORT

ENTRYPOINT ["java","-jar","-Xmx1024M","-Dserver.port=${PORT}","app.jar"]


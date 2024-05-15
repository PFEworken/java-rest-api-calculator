FROM adoptopenjdk/openjdk11
  
EXPOSE 8080
 
ENV APP_HOME /usr/src/java-rest-api-calculator

COPY target/*.jar $APP_HOME/java-rest-api-calculator.jar

WORKDIR $APP_HOME

CMD ["java", "-jar", "java-rest-api-calculator.jar"]

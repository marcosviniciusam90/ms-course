FROM azul/zulu-openjdk-alpine:11
VOLUME /tmp
ADD ./target/*.jar hr-user.jar
ENTRYPOINT ["java","-jar","/hr-user.jar"]
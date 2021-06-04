FROM azul/zulu-openjdk-alpine:11
VOLUME /tmp
ADD ./target/*.jar hr-oauth.jar
ENTRYPOINT ["java","-jar","/hr-oauth.jar"]
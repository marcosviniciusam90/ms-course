FROM azul/zulu-openjdk-alpine:11
VOLUME /tmp
EXPOSE 8765
ADD ./target/*.jar hr-api-gateway-zuul.jar
ENTRYPOINT ["java","-jar","/hr-api-gateway-zuul.jar"]
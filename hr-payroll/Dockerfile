FROM azul/zulu-openjdk-alpine:11
VOLUME /tmp
ADD ./target/*.jar hr-payroll.jar
ENTRYPOINT ["java","-jar","/hr-payroll.jar"]
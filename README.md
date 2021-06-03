# Criando e testando containers Docker

## Comandos Docker
#### Criar uma rede Docker
```
docker network create <nome-da-rede>
```
#### Baixar imagem do Dockerhub
```
docker pull <nome-da-imagem:tag>
```
#### Construir imagem
```
docker build -f <Dockerfile> -t <nome-da-imagem:tag> .
```
Obs: não precisa passar o parâmetro **-f** se o arquivo usado for o *Dockerfile* 
#### Ver imagens
```
docker images
```
#### Rodar um container de uma imagem
```
docker run -p <porta-externa>:<porta-interna> --name <nome-do-container> --network <nome-da-rede> -e <var-1>=<valor-1> -e <var-2>=<valor-2> <nome-da-imagem:tag> 
```
- porta externa: porta mapeada para acessarmos o container externamente (da máquina local, browser, etc)
- porta interna: porta interna no container, esta será mapeada para uma porta externa, permitindo acesso externo
#### Listar containers
```
docker ps
docker ps -a
```
#### Acompanhar logs do container em execução
```
docker logs -f <container-id>
```
------------------------------------------------

## Passo a passo para dockerizar sistema HR
#### Criar rede docker para sistema hr
> Necessário para que os microsserviços possam se comunicar, para isso eles precisam estar na mesma rede.
```
docker network create hr-net
```

#### Rodando containers com banco de dados PostgreSQL para os microsserviços hr-worker e hr-user
```
docker pull postgres:12-alpine
docker run -p 5432:5432 --name hr-worker-pg12 --network hr-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_hr_worker postgres:12-alpine
docker run -p 5432:5432 --name hr-user-pg12 --network hr-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_hr_user postgres:12-alpine
```


#### Construindo imagem e rodando container para o microsserviço hr-config-server
*Dockerfile*
```
FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
ADD ./target/hr-config-server-0.0.1-SNAPSHOT.jar hr-config-server.jar
ENTRYPOINT ["java","-jar","/hr-config-server.jar"]
``` 
```
mvnw clean package
docker build -t hr-config-server:v1 .
docker run hr-config-server:v1 -p 8888:8888 --name hr-config-server --network hr-net -e GITHUB_USER=acenelio -e GITHUB_PASS=
```

#### Construindo imagem e rodando container para o microsserviço hr-eureka-server
*Dockerfile*
```
FROM openjdk:11
VOLUME /tmp
EXPOSE 8761
ADD ./target/hr-eureka-server-0.0.1-SNAPSHOT.jar hr-eureka-server.jar
ENTRYPOINT ["java","-jar","/hr-eureka-server.jar"]
``` 
```
mvnw clean package
docker build -t hr-eureka-server:v1 .
docker run hr-eureka-server:v1 -p 8761:8761 --name hr-eureka-server --network hr-net
```

#### Construindo imagem e rodando container para o microsserviço hr-worker
*Dockerfile*
```
FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-worker-0.0.1-SNAPSHOT.jar hr-worker.jar
ENTRYPOINT ["java","-jar","/hr-worker.jar"]
``` 
```
mvnw clean package -DskipTests
docker build -t hr-worker:v1 .
docker run hr-worker:v1 -P --network hr-net
```
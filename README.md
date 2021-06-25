<center><h1>SPRING-BOOT-ACTUATOR-LAB</h1></center> 

<center>Visão geral do sistema : </center>
<center>a funcionalidade do spring-boot, se propõem a expor endpoit para obter "metrics" sobre a saúde do sistema.</center>

----
**Pré-Requisitos**

1. #### Softwere

 1.1. Java 8 "1.8.0_282"

1.2 Apache Maven 3.6.3 

----
2. #### Dependências

- Exeto o "Actuator", o resto das depêndencias , não são necessárias, mas devido aos teste que este projeto proporciona , foram colocadas na lista

2.1. Actuator (OBRIGATÓRIO)

2.2. Web 

2.3. Starter-data-jpa

2.4. H2

2.5. Starter-webflux

2.6. Lombok

2.7. Json-path 

2.8. Micrometer-registry-prometheus

2.9. Junit-vintage-engine

2.10. Starter-test

----
3. #### Gerando Build da Aplicação

Na raiz do projeto digitar:
`mvn clean install`

----
4. #### Criando executável da aplicação

Na raiz do projeto digitar:
`mvn clean package`

----

5. #### Executando Aplicação 

É possível rodar a aplicação de 4 formas

##### 5.1 Em mvn (Localmente)

no terminal execute o comando `mvn spring-boot:run`

##### 5.2 Em Java (Localmente)7

no terminal execute o comando `java -jar target/spring-boot-actuator-lab-0.0.1-SNAPSHOT.jar`

##### 5.3 Em Docker (Localmente)

##### No terminal execute os comandos:

##### 5.3.1`sudo docker build . -t  spring-boot-actuator-lab`

##### 5.3.2 `sudo docker run -p 8080:8080 spring-boot-actuator-lab`

----
Vá em um navegador de sua escolhe e acesse localhost:8080/actuador para vizualizar as metricas login:foo e senha:foo

## Troubleshoot

- Problemas com apt Get ou "Connect to repo.maven.apache.org:443 [repo.maven.apache.org/151.101.204.215] failed: Connection refused (Connection refused)"

`-s ~/.m2/settings@trepa.xml`

-  Problemas com SDKMAN => "INTERNET NOT REACHABLE!"

 - Use os comandos a seguir para configurar as variaveis de ambiente para usar o sdkman

`- export http_proxy=http://USER:PASSWORD@10.13.0.125:3128/`
`- export httpS_proxy=http://USER:PASSWORD@10.13.0.125:3128/`

Spring Boot

- Foi usado o  https://start.spring.io/ para criar o projeto em spring boot com as dependências :

- Spring web

- Spring Actuator
  para baixar as depêndencias usar o comando "mvn install package"

para baixar as depêndencias usar o comando "mvn dependency:tree"

para desabilitar ou habilitar endpoints

- Seleciona a porta em que o actuator vai atuar

management.server.port=1979

- Mostra detalhes do health endpoint

 management.endpoint.health.show-details=always

- Use "*" para selecionar todos os endpoints.
  -include para incluir novos endpoints e exclude para ocultar.
-  ex. management.endpoints.web.exposure.include=nome

#### para usar no JMX
management.endpoints.jmx.exposure.include=*
management.endpoints.jmx.exposure.exclude=

#### para habilitar na Web as metricas

management.endpoints.web.exposure.include=health,info,prometheus

#### Ativa o endpoint Liveness e Readiness.

management.health.probes.enabled=true

Segurança há certos endpoints que precisam de mais uma instrução para ser habilitada






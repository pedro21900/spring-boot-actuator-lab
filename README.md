<center><h1>SPRING-BOOT-ACTUATOR-LAB</h1></center> 

<h5>Visão geral do sistema : Atuação da depêndencia "Actuator" do "Spring-Boot", se propõem a expor endpoit para obter "metrics" sobre a saúde do sistema.</h5>


----
**Pré-Requisitos**

1. #### Softwere

 1.1. Java 8 "1.8.0_282"

1.2 Apache Maven 3.6.3 

----
2. #### Dependências

- Exeto o "Actuator", o resto das depêndencias , não são necessárias, mas devido aos teste que este projeto proporciona , foram colocadas na lista

2.1. Actuator (OBRIGATÓRIO)

2.2. Web (para exibir endpoints)

2.3. Starter-data-jpa (para blibliotecas de manipulções de banco)

2.4. H2 (Para teste em banco de dados)

2.5. Starter-webflux (Para agilizar as requiciçoes ao sistema)

2.6. Lombok (Facilitador de código)

2.7. Json-path (Anotação para declarar explicitamente uma expressão JSON Path em uma interface de projeção)

2.8. Micrometer-registry-prometheus (para acionar a metrica do "Prometheus)

2.9. Junit-vintage-engine (é usado para executar testes)

2.10. Starter-test (Para executar testes no serviço)

----
3. #### Gerando Build da Aplicação 

Na raiz do projeto digitar:
`mvn clean install`
a ação acime gera o executável da aplicação

----

4. #### Executando Aplicação 

É possível rodar a aplicação de 4 formas

##### 4.1 Em mvn (Localmente)

no terminal execute o comando `mvn spring-boot:run`

##### 4.2 Em Java (Localmente)

no terminal execute o comando `java -jar target/spring-boot-actuator-lab-0.0.1-SNAPSHOT.jar`

##### 4.3 Em Docker (Localmente)

##### No terminal execute os comandos:

##### 4.3.1`sudo docker build . -t  spring-boot-actuator-lab`

##### 4.3.2 `sudo docker run -p 8080:8080 spring-boot-actuator-lab`

----
5. #### Verificando as Metricas , que teram como base a SDS

Vá em um navegador de sua escolhe e acesse localhost:8080/actuador para vizualizar as metricas

5.1. INFO (Informção inseridas pelo desenvolvedor)

5.2. HEALTH (colhe metricas do sistema )
 - Database (Comando Ex.: Select... , testados no banco de dados para colher a métrica , pode ser encontrado na classe "DatabaseHealthCOntribuitor"  dentro do package "core".
 
 - urlShortener (Testes para verificar se a aplicação está de fato conectado a rede de internet , pode ser encontrado na classe "UrlShortenerServicesHealthindicator "  dentro do package "core").
 
 - db (Directiva automática do próprio actuado após ser acionado como dependência)
 
 - diskSpace (Directiva automática do próprio actuado após ser acionado como dependência)
 
 - endpointHealthCheck (Teste para verificar um endpoint dentro do sistema , pode ser encontrado na classe "EndpointHealthContributor"  dentro do package "core").

5.3. PROMETHEUS (ainda em desnvolvimento)

5.4 AUDITEVENTS (Faz auditoria na autenticação)

  5.4.1. Para testar esse end point é nescessário entrar no browser usando localhost:8080 que fará você ser redirecionado para uma aba de login e senha , 
  digite qualquer senha e login , e poderá verificar na directiva de "AUDITEVENTS" que a conecxão foi recusada , a senha de acesso é foo o login também.
  
  
  Com tudo isso implementamos momentos como banco de dados , internet , disco , auditoria , intranet que colherão as metricas do nosso sistema nos avissando de erros que podem ser dinamizados melhorando a produção.
  
  Todos os erros foram gerados para que o actuator gere uma directiva "DOWN" nas classes ,"DatabaseHealthContributor linha 28","EndpointHealthCheck linha 32" package "core".
 



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






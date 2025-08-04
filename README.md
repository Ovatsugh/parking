# Projeto Spring Boot - API REST

Este é um projeto de exemplo utilizando **Spring Boot** com **Maven** para gerenciamento de dependências. A aplicação expõe uma API RESTful e utiliza o **Swagger** para documentação interativa.

## Requisitos

- Java 17+ (ou a versão suportada pelo seu projeto)
- Maven 3.8+
- IDE de sua preferência (IntelliJ, VSCode, Eclipse, etc)

## Como rodar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

2. Navegue até o diretório do projeto:

```bash
cd seu-repositorio
```

3. Compile e execute o projeto com Maven:

```bash
./mvnw spring-boot:run
```

Ou, caso tenha o Maven instalado globalmente:

```bash
mvn spring-boot:run
```

4. A aplicação estará disponível em:

```
http://localhost:8081
```

## Documentação da API

A documentação Swagger pode ser acessada em:

👉 [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

Por meio dessa interface, é possível visualizar e testar os endpoints da API.

## Estrutura do Projeto

```
src/
 └── main/
     ├── java/
     │   └── com.seuprojeto/  # Pacotes com controllers, services, models etc.
     └── resources/
         ├── application.properties
         └── ...
```

## Construção

Para empacotar a aplicação como um `.jar`:

```bash
mvn clean package
```

O artefato final estará disponível em `target/`.

## Licença

Este projeto é licenciado sob a [MIT License](LICENSE).
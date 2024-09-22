<a href="./LICENSE.md">
<img src="./images/public-domain.svg" alt="Public Domain"
align="right" width="20%" height="auto"/>
</a>

# Kotlin Spring Boot HATEOAS Database

[![build](https://github.com/binkley/kotlin-spring-boot-hateoas-database/actions/workflows/ci.yml/badge.svg)](https://github.com/binkley/kotlin-spring-boot-hateoas-database/actions)
[![issues](https://img.shields.io/github/issues/binkley/kotlin-spring-boot-hateoas-database.svg)](https://github.com/binkley/kotlin-spring-boot-hateoas-database/issues/)
[![pull requests](https://img.shields.io/github/issues-pr/binkley/kotlin-spring-boot-hateoas-database.svg)](https://github.com/binkley/kotlin-spring-boot-hateoas-database/pulls)
[![vulnerabilities](https://snyk.io/test/github/binkley/kotlin-spring-boot-hateoas-database/badge.svg)](https://snyk.io/test/github/binkley/kotlin-spring-boot-hateoas-database)
[![license](https://img.shields.io/badge/license-Public%20Domain-blue.svg)](http://unlicense.org/)

Kick the tires on Spring Boot HATEOAS with a database.
(Do not fret, this project uses an in-memory database that vanishes when you
stop the program.)

## Caveat emptor

This is a scratch, experimental repository.
It might force push.
It might be renamed without warning.
It might vanish without warning.

## How to use

First, ensure your clone builds cleanly:

```
$ ./mvnw clean verify
```

If satisfied, try running the program. In a first terminal, execute:

```
$ ./mvnw spring-boot:run
# Or with Docker
$ ./batect run
```

Once the program is ready (look for the "Started HateoasApplicationKt"
message), in another terminal (if you don't use
[curlie](https://curlie.io/) or [httpie](https://httpie.io/cli), try `curl` or
`telnet` though it will not be as nice to look at):

```
# Output: list of data endpoints
$ http localhost:8080/data
# Output: description of the AUTHORS database table
$ http localhost:8080/data/authors
# Output: first record in AUTHORS (Joanne Rowling is moby, is she not?)
$ http localhost:8080/data/authors/author-1
# Output: the first author in the database
$ http localhost:8080/rest/authors/author-1
# Output: the first author as GraphQL
$ http :8080/graphql query='{
  bookById(id: "book-1") {
    id
    title
    pageCount
    moby
    author {
      id
      firstName
      lastName
    }
  }
}'
# Output: all available endpoints
$ http localhost:8080/rest
# Output: list of admin endpoints
$ http localhost:8080/admin
# Output: everything should be in the UP state
$ http localhost:8080/admin/health
```

Before interrupting the first terminal process, try [the data
link](http://localhost:8080/data) again.
Play around with the web page features.
You cannot break anything (the database is in-memory).
Sadly, there is no nice page for [the admin
links](http://localhost:8080/admin).

Before you change to another task, please interrupt the first terminal, and
shutdown the demonstration.

## Features

You can create a new project with most features using Spring Initializer to
bootstrap:

```shell
$ spring init --name kotlin-spring-boot-hateoas-database --group-id hm.binkley.labs --description 'Kick the tires on Spring Boot HATEOAS with a database' --build maven --boot-version 3.3.4 --java-version 21 --language kotlin --dependencies actuator,data-jdbc,configuration-processor,data-rest,data-rest-explorer,devtools,graphql,h2,hateoas
```

### Pretty, autoconfigured/auto-generated UI explorers

* Open API (Swagger) UI
    - Try http://localhost:8080/rest in a browser
* HATEOAS UI
    - Try http://localhost:8080/data in a browser
* GraphQL UI, schema, and APIs
    - Try http://localhost:8080/graphiql in a browser
    - Try http://localhost:8080/graphql/schema
* Generated OpenAPI specification
    - After `./mvnw verify` see `target/openapi.json`

### In-memory persistence for demo

* H2 in-memory database with dummy data preloaded ("Joanne Rowling")
    - Try http://localhost:8080/rest/authors/author-1
    - Try http://localhost:8080/data/authors/author-1
* H2 console enabled
    - Try http://localhost:8080/h2
    - The JDBC connect string is `jdbc:h2:mem:demo`
    - The user and password are "sa" and "password"

### Additional Spring Boot features

* Maximal actuator configuration
    - Try http://localhost:8080/admin
* Prometheus metrics
    - Try http://localhost:8080/admin/prometheus
* Auto-refresh of server on code changes for developers

### Tracing/debugging from IDE

Run the program configured with JVM debugging.
This configured in [`batect.yml`](./batect.yml) for the standard port of 5005,
and run as:
```shell
$ ./batect debug
```
Attach the remote debugging facility of your IDE to this port.

## TODO

* Sorting for REST
* Paging and sorting for other endpoints
* Test containers test (see binkley/modern-java-practices#278)

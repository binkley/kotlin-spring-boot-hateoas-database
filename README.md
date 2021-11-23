<a href="LICENSE.md">
<img src="https://unlicense.org/pd-icon.png" alt="Public Domain" align="right"/>
</a>

# Kotlin Spring Boot HATEOAS Database

[![build](https://github.com/binkley/kotlin-spring-boot-hateoas-database/workflows/build/badge.svg)](https://github.com/binkley/kotlin-spring-boot-hateoas-database/actions)
[![issues](https://img.shields.io/github/issues/binkley/kotlin-spring-boot-hateoas-database.svg)](https://github.com/binkley/kotlin-spring-boot-hateoas-database/issues/)
[![vulnerabilities](https://snyk.io/test/github/binkley/kotlin-spring-boot-hateoas-database/badge.svg)](https://snyk.io/test/github/binkley/kotlin-spring-boot-hateoas-database)
[![license](https://img.shields.io/badge/license-Public%20Domain-blue.svg)](http://unlicense.org/)

Kick the tires on Spring Boot HATEOAS with a database.  (Do not fret, this
project uses an in-memory database that vanishes when you stop the program.)

## Caveat emptor

This is a scratch, experimental repository. It might force push. It might
vanish without warning.

## How to use

First, ensure your clone builds cleanly:

```
$ ./mvnw clean verify
```

If satisfied, try running the program. In a first terminal, execute:

```
$ ./mvnw spring-boot:run
```

Once the program is ready (look for the "Started HateoasApplicationKt"
message), in another terminal (if you don't
use [httpie](https://httpie.io/cli), try `curl` though it will not be as nice
to look at):

```
$ http localhost:8080/data
# Output: list of data endpoints
$ http localhost:8080/data/thingies
# Output: description of the THINGIES database table
$ http localhost:8080/data/thingies/1
# Output: first record in THINGIES (Frodo is moby, is he not?)
$ http localhost:8080/admin
# Output: list of admin endpoints
$ http localhost:8080/admin/health
# Output: everything should be in the UP state
```

Before interrupting the first terminal process, in a browser try
[the data link](http://localhost:8080/data) again. Play around with the web
page features. You cannot break anything (the database is in-memory). Sadly,
there is no nice page for [the admin links](http://localhost:8080/admin).

Before you change to another task, please interrupt the first terminal, and
shutdown the demonstration.

## Features

* HATEOAS REST endpoint for database (the point of this scratch project)
    - Try `localhost:8080/data`
* H2 in memory database with dummy data preloaded
* H2 console enabled
    - Try `localhost:8080/h2`
* Maximal actuator configuration
    - Try `localhost:8080/admin`
* Auto-refresh of server on code changes

## Unfeatures

* Swagger3 breaks Spring Boot 2.6 ☹

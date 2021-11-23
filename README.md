<a href="LICENSE.md">
<img src="https://unlicense.org/pd-icon.png" alt="Public Domain" align="right"/>
</a>

# Kotlin Spring Boot HATEOAS Database

[![build](https://github.com/binkley/kotlin-spring-boot-hateoas-database/workflows/build/badge.svg)](https://github.com/binkley/kotlin-spring-boot-hateoas-database/actions)
[![issues](https://img.shields.io/github/issues/binkley/kotlin-spring-boot-hateoas-database.svg)](https://github.com/binkley/kotlin-spring-boot-hateoas-database/issues/)
[![vulnerabilities](https://snyk.io/test/github/binkley/kotlin-spring-boot-hateoas-database/badge.svg)](https://snyk.io/test/github/binkley/kotlin-spring-boot-hateoas-database)
[![license](https://img.shields.io/badge/license-Public%20Domain-blue.svg)](http://unlicense.org/)

Kick the tires on Spring Boot HATEOAS with a database

## Caveat emptor

This is an scratch, experimental repository.  It might use force push.

## Features

* HATEOAS REST endpoint for database (the point of this scratch project)
  - Try `localhost:8080/data`
* H2 in memory database with dummy data preloaded
* H2 console enabled
    - Try `localhost:8080/h2`
* Maximal actuator configuration
  - Try `localhost:8080/admin`

## Unfeatures

* Swagger3 breaks Spring Boot 2.6 ☹

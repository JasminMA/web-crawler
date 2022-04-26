# web-crawler

## Introduction
Given a URL, it would crawl all pages within the same url domain , but not follow external links.

## Language, Framework and libraries
- Java 8.
- Spring Boot, Spring Date, Spring Web.
- Lombok.


## Instructions 
* To create PostgreSQL using docker, run this command
  * docker run -d --name postgres -p 127.0.0.1:5432:5432 -e POSTGRES_PASSWORD=postgres postgres
* To build Docker image
  * docker build -t crawl-page:latest .
* To run Docker image
  * docker run -d -p8080:8080 --name crawl-page crawl-page:latest

## Documentation
* swagger URL : http://{ip}:8080/swagger-ui/index.html

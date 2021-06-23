# **TechStartTest**

TechStart/InsideTrack Test

**PREREQUISITES**:

[Java 8](https://java.com/en/download/help/download_options.html)

[Maven 3.6.3](https://maven.apache.org/index.html)

[MongoDB (community edition)](https://docs.mongodb.com/manual/installation/)

[Angular 9.1.15](https://angular.io/guide/setup-local)

[Bootstrap v5.0.0-beta3](https://getbootstrap.com/)

**INSTRUCTIONS TO RUN PROJECT LOCALLY:**

clone repo into directory:

    git clone https://github.com/croudebush15/TechStartTest.git

enter directory TechStartTest/tech-start-test-api to run the backend server first.

    cd TechStartTest/tech-start-test-api

from here run Spring Boot project GithubApiDemoApplication with this command (opens at port 8080):

    ./mvnw spring-boot:run

open a seperate command prompt in TechStartTest/tech-start-test-angular and install angular packages

    npm install

open angular server at port 4200:

    ng serve --open

Page hosted at localhost:4200.
All services are hosted at localhost:8080.

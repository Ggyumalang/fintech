plugins {
    kotlin("plugin.jpa")
}

version = "0.0.1"

allprojects{
    dependencies {
        implementation("org.mariadb.jdbc:mariadb-java-client:3.1.2")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-data-redis")
    }
}


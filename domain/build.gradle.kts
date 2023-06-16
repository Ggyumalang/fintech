plugins {
    kotlin("plugin.jpa")
}

version = "0.0.1"

allprojects{
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("com.mysql:mysql-connector-j")
        implementation("org.springframework.boot:spring-boot-starter-data-redis")
    }
}


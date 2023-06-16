plugins {}

version = "0.0.1"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("io.springfox:springfox-boot-starter:3.0.0")

    implementation(project(":domain"))
    implementation(project(":kafka"))

    //mapper관련 dependency
    //기본생성자 때문
    //test 관련 dependency
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.2")
    testImplementation("io.mockk:mockk:1.13.4")
    runtimeOnly("com.h2database:h2")

    // AOP
    implementation("org.springframework.boot:spring-boot-starter-aop")

    // Logging
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.5")
}

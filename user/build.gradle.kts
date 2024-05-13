repositories {
    mavenCentral()

    maven { url = uri("https://repo.spring.io/milestone") }
}

tasks.bootJar{
    enabled = false
}

tasks.jar{
    enabled = true
}
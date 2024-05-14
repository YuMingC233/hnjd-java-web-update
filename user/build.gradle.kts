repositories {
    mavenCentral()

    maven {
        isAllowInsecureProtocol = true
        url = uri("https://repo.spring.io/milestone")
    }
}

tasks.bootJar{
    enabled = false
}

tasks.jar{
    enabled = true
}
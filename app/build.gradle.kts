repositories {
    mavenCentral()

    maven {
        isAllowInsecureProtocol = true
        url = uri("https://repo.spring.io/milestone")
    }
}

dependencies {
    implementation(project(":user"))
}
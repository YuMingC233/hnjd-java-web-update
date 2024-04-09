repositories {
    mavenCentral()

    maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
    implementation(project(":service"))
}
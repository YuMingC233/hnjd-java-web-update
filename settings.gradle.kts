plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "review"
include("app")
include("service")
include("dao")
include("user")

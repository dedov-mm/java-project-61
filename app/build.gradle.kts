plugins {
    application
    checkstyle
}

group = "hexlet.code"
version = "0.1.0"
application { mainClass.set("hexlet.code.App") }

repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.apache.commons:commons-lang3:3.12.0")
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

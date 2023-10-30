buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        val jacksonVersion = "2.15.2"
        classpath("org.slf4j:slf4j-simple:2.0.7")
        classpath("commons-io:commons-io:2.13.0")
        classpath("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
        classpath("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonVersion")
        classpath("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
        classpath("org.tukaani:xz:1.9")
    }
}

repositories {
    mavenCentral()
}
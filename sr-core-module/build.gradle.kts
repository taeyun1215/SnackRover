tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation(project(":sr-common-module"))
    implementation(project(":sr-support-module:monitoring"))
    implementation(project(":sr-support-module:logging"))
    implementation(project(":sr-storage-module"))

    implementation("org.springframework.boot:spring-boot-starter-web")
}

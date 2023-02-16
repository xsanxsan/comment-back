plugins {
	java
	id("org.springframework.boot") version "3.0.2"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework:spring-web:6.0.3")
	implementation("org.springframework:spring-webmvc:6.0.3")
	implementation("org.springframework.boot:spring-boot-starter-web:3.0.2")
	implementation("org.projectlombok:lombok:1.18.22")
	implementation("org.springframework.boot:spring-boot-starter-validation:3.0.2")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.2")
	implementation("org.hibernate.validator:hibernate-validator:8.0.0.Final")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.h2database:h2")
	compileOnly("org.projectlombok:lombok:1.18.22")
	annotationProcessor("org.projectlombok:lombok:1.18.22")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

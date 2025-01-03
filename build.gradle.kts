plugins {
	id("java")
	id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.7"
	id("com.github.bjornvester.wsdl2java") version "2.0.2"
}

group = "com.crawler"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web-services")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	implementation("org.apache.cxf:cxf-rt-frontend-jaxws:3.5.6")
	implementation("org.apache.cxf:cxf-rt-transports-http:3.5.6")
	implementation("javax.xml.bind:jaxb-api:2.3.1")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

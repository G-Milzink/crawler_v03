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
		languageVersion.set(JavaLanguageVersion.of(21))
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
	implementation("jakarta.xml.bind:jakarta.xml.bind-api:3.0.1")
	implementation("org.glassfish.jaxb:jaxb-runtime:3.0.2")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

// Configure the wsdl2java task
tasks.named<com.github.bjornvester.wsdl2java.Wsdl2JavaTask>("wsdl2java") {
	wsdl.set(file("src/main/resources/wsdl/SearchMeteringPoints_3p0/SearchMeteringPoints_3.wsdl"))
	packageName.set("cmf.edsn.service.searchmeteringpoints._3.standard")
	options.addAll("-XobjectFactory")
}

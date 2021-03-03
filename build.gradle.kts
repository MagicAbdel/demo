//
// Copyright 2021 the original author or authors.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
plugins {
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("io.micronaut.library") version "1.3.2"
}

version = "0.1"
group = "com.example"

repositories {
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}


dependencies {
    implementation("io.micronaut.gcp:micronaut-gcp-function")
    implementation("io.micronaut:micronaut-validation")
    implementation("io.micronaut:micronaut-runtime")
    implementation("javax.annotation:javax.annotation-api")
    implementation("com.google.cloud:google-cloud-firestore:2.2.4")
    implementation("io.micronaut.gcp:micronaut-gcp-common:3.4.0")
    implementation("io.micronaut.gcp:micronaut-gcp-logging:3.4.0")
    compileOnly("com.google.cloud.functions:functions-framework-api")
    runtimeOnly("ch.qos.logback:logback-classic")
}


java {
    sourceCompatibility = JavaVersion.toVersion("11")
    targetCompatibility = JavaVersion.toVersion("11")
}




#!/bin/sh

MAVEN_OPTS="-javaagent:springloaded-1.2.1.RELEASE.jar -noverify" mvn spring-boot:run

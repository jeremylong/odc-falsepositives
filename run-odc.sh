#!/usr/bin/env sh

if [ -f "./pom.xml" ]; then
  mvn org.owasp:dependency-check-maven:6.5.3:aggregate
elif [ -f "./build.gradle" ]; then
  if [ -f "./gradlew" ]; then
    ./gradlew --init-script run-odc.gradle dependencyCheckAggregate
  else
    gradle --init-script run-odc.gradle dependencyCheckAggregate
  fi
elif [ -f "./build.gradle.kts" ]; then
  if [ -f "./gradlew" ]; then
    ./gradlew --init-script run-odc.gradle.kts dependencyCheckAggregate
  else
    gradle --init-script run-odc.gradle.kts dependencyCheckAggregate
  fi
else
  ## run the cli or dockerized dependency-check
  dependency-check.sh -s . -o .
fi

#!/bin/bash
set -e

mvn clean install -DskipTests
mvn dockerfile:build
docker-compose up
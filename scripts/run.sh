#!/usr/bin/env bash

echo "Build..."
./gradlew -x test build
echo "Run..."
docker-compose up --build
#!/usr/bin/env bash

echo "Assuming BuildTools is located in ./BuildTools/, please move if otherwise, or edit this file."

cd BuildTools
java -jar BuildTools.jar --rev 1.13.2
java -jar BuildTools.jar --rev 1.12.2
java -jar BuildTools.jar --rev 1.8.8
cd -

./gradlew clean build
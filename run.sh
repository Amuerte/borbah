#!/bin/bash

JAVA_DEBUG_OPTS="-Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n"
JAVA_OPTS="${JAVA_DEBUG_OPTS}"


export AWS_ACCESS_KEY_ID="keyId"
export AWS_SECRET_ACCESS_KEY="secret"

java "${JAVA_OPTS}" -jar build/libs/borbah-all.jar server build/resources/main/configuration.yml
@ECHO OFF
SET JAVA_DEBUG_OPTS="-Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n"
SET JAVA_OPTS="%JAVA_DEBUG_OPTS%"

REM gradle.bat clean build shadowJar

SET AWS_ACCESS_KEY_ID="keyId"
SET AWS_SECRET_ACCESS_KEY="secret"

java %JAVA_OPTS% -jar build\libs\borbah-all.jar server build\resources\main\configuration.yml
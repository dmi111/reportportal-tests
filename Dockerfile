FROM maven:3.6.0-jdk-8

COPY ui/src home/ReportPortalTests/ui/src

COPY pom.xml home/ReportPortalTests/pom.xml

COPY ui/pom.xml home/ReportPortalTests/ui/pom.xml

RUN mvn -f home/ReportPortalTests/pom.xml clean test -DskipTests=true
FROM payara/micro
WORKDIR /opt
EXPOSE 8080
ADD domain.xml conf/domain.xml
ADD mysql-connector-java-5.1.44.jar jdbc/mysql-connector-java-5.1.44.jar
ADD target/apptest-0.0.1-SNAPSHOT.war app/apptest-0.0.1-SNAPSHOT.war
ENTRYPOINT java -jar -cp "/opt/jdbc/mysql-connector-java-5.1.44.jar:/opt/payara/micro.jar" /opt/payara/payara-micro.jar --deploy /opt/app/apptest-0.0.1-SNAPSHOT.war --domainConfig conf/domain.xml
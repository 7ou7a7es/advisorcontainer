FROM mdelapenya/tomcat-mysql:7.0.77

COPY target/containerbank.war /opt/apache-tomcat-7.0.77/webapps/containerbank.war 

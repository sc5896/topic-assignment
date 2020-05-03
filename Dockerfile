FROM tomcat:9.0.34-jdk8-openjdk
ADD **/*.war /usr/local/tomcat/webapps
EXPOSE 8082
CMD ["catalina.sh", "run"]
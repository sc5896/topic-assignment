FROM tomcat:9.0.34-jdk8-openjdk
ADD **/*.war /usr/local/tomcat/webapps
EXPOSE 8080
CMD ["catalina.sh", "run"]
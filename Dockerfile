FROM tomcat:8.5.54-jdk8-openjdk
ADD **/*.war /usr/local/tomcat/webapps
EXPOSE 8080
CMD ["catalina.sh", "run"]
FROM tomcat:8.5.46-jdk8-openjdk

RUN rm -Rf /usr/local/tomcat/webapps/sptekshopping ## tomcat root 경로 삭제
RUN rm -Rf /usr/local/tomcat/webapps/sptekshopping.war ## tomcat root 경로 삭제
COPY ./shopping-1.0.0-BUILD-SNAPSHOT.war /usr/local/tomcat/webapps/sptekshopping.war

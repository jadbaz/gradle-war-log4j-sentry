FROM jboss/wildfly
ADD build/libs/gradle-war.war /opt/jboss/wildfly/standalone/deployments

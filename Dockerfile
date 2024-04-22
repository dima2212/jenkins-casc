FROM jenkins/jenkins

USER root
RUN mkdir -p /opt/maven3 && chown jenkins:jenkins /opt/maven3 && \
    mkdir -p /opt/nodejs && chown jenkins:jenkins /opt/nodejs

USER jenkins
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
ENV CASC_JENKINS_CONFIG /var/jenkins/configuration/jenkins.yaml

COPY configuration/ /var/jenkins/configuration
COPY scripts/ /var/jenkins/scripts

COPY resources/plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt
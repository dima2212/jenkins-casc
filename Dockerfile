FROM jenkins/jenkins

USER 0
RUN mkdir -p /opt/maven3 && chown jenkins:jenkins /opt/maven3

USER 1000
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
ENV CASC_JENKINS_CONFIG /var/jenkins/configuration/jenkins.yaml

COPY configuration/ /var/jenkins/configuration
COPY scripts/ /var/jenkins/scripts

COPY resources/plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt
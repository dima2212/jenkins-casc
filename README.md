# Jenkins Configuration as Code demo

This configuration as code repo provides a quick start with JCASC and JobDSL jenkins plugins.

Jenkins provisioning takes place when the docker container is created. All the settings are defined in jenkins.yaml. 

### Building the docker image
```bash
docker build -t jenkins .
```

### Running the docker image
```bash
docker run -d -v /var/jenkins_home:/var:jenkins_home -p 8080:8080 jenkins
```
Once the jenkins container is up and running you can use any user defined in jenkins.yaml to login.
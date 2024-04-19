# Jenkins Configuration as Code demo

This configuration as code repo provides a quick start with JCASC and JobDSL jenkins plugins.

Jenkins provisioning takes place when the docker container is created. All the settings are defined in jenkins.yaml. 

### Building the docker image
```bash
docker build -t jenkins .
```

### Running the docker image
```bash
docker run -d -p 8080:8080 jenkins
```
For persistent storage volume mounts can be used. In this case you need to use the same uid as parent image (1000) for the volume. 
```bash
sudo mkdir /var/jenkins_home
sudo chown -R 1000:1000 /var/jenkins_home
docker run -d -v /var/jenkins_home:/var/jenkins_home -p 8080:8080 jenkins
```
Once the jenkins container is up and running you can use any user defined in jenkins.yaml to login.
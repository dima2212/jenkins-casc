pipeline {
    agent any
    tools {
        nodejs "nodejs-21.7.3"
    }
    stages {
        stage('Checkout') {
            steps {
                git branch:"master", url: "https://github.com/jenkins-docs/building-a-multibranch-pipeline-project.git"
            }
        }   
        stage('Build') {
            steps {
                sh 'npm install'
            }
        }
        stage('Test') {
            steps {
                sh 'npm test'
            }
        }
        stage('Deliver') {
            steps {
                sh './jenkins/scripts/deliver-for-development.sh'
                input message: 'Finished using the web site? (Click "Proceed" to continue)'
                sh './jenkins/scripts/kill.sh'
            }
        }
    }
}
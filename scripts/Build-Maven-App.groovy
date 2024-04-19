pipeline {
    agent any 
    tools{
        maven 'maven3'
    }
    stages{
        stage("Git Checkout"){
            steps{
                git branch: 'master', changelog: false, poll: false, url: 'https://github.com/jenkins-docs/simple-java-maven-app.git'
            }
        }
        stage("Build"){
            steps{
                sh "mvn -B -DskipTests clean package"
            }
        }
        stage("Test"){
            steps{
                sh "mvn test"
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deliver') {
            steps {
                sh './jenkins/scripts/deliver.sh'
            }
        }
    }
}
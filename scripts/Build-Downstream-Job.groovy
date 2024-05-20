pipeline {
    agent any
    stages {
        stage("Select Job to Build") {
            steps {
                script {
                    job = input message: 'Select job to build', ok: 'Build', parameters: [choice(choices: ['Maven', 'React'], name: 'job')]
                }
            }
        }
    }
    post {
        success {
            build job: "Build-$job-App"
        }
    }
}
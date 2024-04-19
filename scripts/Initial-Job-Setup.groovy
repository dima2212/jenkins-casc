// Empty freestyle jobs
job('Api-Tests-Service-1')
job('Api-Tests-Service-2')
job('Build-Service-1')
job('Build-Service-2')
job('Deploy-Service-1')
job('Deploy-Service-2')

// Pipeline job based on existing file in scripts folder
pipeline = new File('/var/jenkins/scripts/Build-Maven-App.groovy').getText("UTF-8")
pipelineJob('Build-Maven-App') {
    definition {
        cps {
            script(pipeline)
            sandbox()
        }
    }
}
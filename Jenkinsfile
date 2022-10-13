node {
    def WORKSPACE = "/var/lib/jenkins/workspace/demo-docker"
    def dockerImageTag = "demo-docker${env.BUILD_NUMBER}"

    try{
        stage('Clone repo'){
            git url: 'https://github.com/simouridi/demo-docker.git',
                credentialsId: 'springdocker-user',
                branch: 'dev'
        }

        stage('Build docker'){
            // build maven
            // sh "sudo mvn clean install"
            // sh "sudo mvn run build"
            dockerImage = docker.build("demo-docker:${env.BUILD_NUMBER}")
        }

        stage('Deploy docker'){
            echo "Docker Image Tag Name: ${dockerImageTag}"
            sh "docker stop demo-docker || true && docker rm demo-docker || true"
            sh "docker run --name demo-docker -d -p 8080:8080 demo-docker:${env.BUILD_NUMBER}"
        }
    }catch(e){
        throw e
    }
}
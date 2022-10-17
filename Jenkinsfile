pipeline {
    agent any
    environment {
        DATE = new Date().format('dd-MM-yyyy')
        TAG = "${DATE}.${BUILD_NUMBER}"
        registry = "simouridi/demo-docker"
        registryCredential = 'docker-credentials'
        dockerImage = ''
    }

    stages {
        stage('Clone repo') {
            steps {
                git branch: 'main', credentialsId: 'github-token', url: 'https://github.com/simouridi/demo-docker.git'
                sh "git checkout main"
            }
        }

        stage('Maven Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Unit Test') {
            steps {
                sh 'mvn clean package'
                junit '**/target/surefire-reports/TEST-*.xml'
            }

        }

        stage('Docker Build image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }

        stage('pushing docker image to dockerhub') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}
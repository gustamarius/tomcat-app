pipeline {
    environment {
        registry = "mgustadocker/maven-app-grads"
        registryCredential = 'plsworkDocker'
    }
    agent any

    stages {
        stage('Clone') {
            steps {
                // Get code from Github
                git url: 'https://github.com/gustamarius/tomcat-app.git'

            }
        }
        stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn package -Dmaven.test.skip=true"
            }
            
        }
        stage('Test') {
            steps {
                //If Maven build was ok -> 
                sh "mvn test"
                junit 'target/surefire-reports/*.xml'
                archiveArtifacts 'target/*.war'
            }
        }
        stage('Create docker image') {
            steps { 
                script { 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
                }
            } 
        }
        stage('Deploy our image') { 
            steps { 
                script { 
                    docker.withRegistry( '', registryCredential) { 
                        dockerImage.push() 
                    }
                } 
            }
        } 
    }
}


pipeline {
    agent any
    stages {
        stage('Build Application') {
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo "Now Archiving the Artifacts...."
                    archiveArtifacts artifacts: '**/*.jar'
                }
            }
        }
        stage('Create Topic Tomcat Docker Image'){
            steps{
                sh "docker build . -t topicspringbootimage:${env.BUILD_NUMBER}"
            }
        }
    }
}
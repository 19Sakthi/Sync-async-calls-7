pipeline {
    agent any
    environment {
        clone = 'https://github.com/19Sakthi/Sync-async-calls-7.git'
    }
    stages {
        stage('clone') {
            steps {
                git(url: "${clone}", branch: 'main', changelog: true, poll: true)
            }
        }
        stage('test') {
            steps {
                script {
                    echo 'Running tests...'
                }
            }
        }
        stage('package') {
            steps {
                script {
                    echo 'Packaging application...'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    echo 'Deploying application...'
                    
                }
            }
        }
    }
}

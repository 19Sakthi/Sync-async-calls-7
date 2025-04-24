pipeline {
  agent any
  stages {
    stage('Clone') {
      steps {
        git(
          url:'https://github.com/19Sakthi/Sync-async-calls-7.git',
          branch: 'main',
          changelog: true,
          poll: true
        )
      }
    }
 
    stage('Build') {
      steps {
        echo 'Building the project...'
        sh 'mvn clean compile'
      }
    }
 
    stage('Test') {
      steps {
        echo 'Running unit tests...'
        sh 'mvn test'
      }
    }
 
    stage('Package') {
      steps {
        echo 'Packaging the application...'
        sh 'mvn package'
      }
    }
 
    stage('Deploy') {
      steps {
        echo 'Deploying application...'
      }
    }
  }
}



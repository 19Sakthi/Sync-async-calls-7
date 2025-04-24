pipeline {
  agent any
  stages {
    stage('clone') {
      steps {
        git(url: 'https://github.com/19Sakthi/Sync-async-calls-7.git', branch: 'main', changelog: true, poll: true)
      }
    }

  }
  environment {
    clone = 'https://github.com/19Sakthi/Sync-async-calls-7.git'
  }
}
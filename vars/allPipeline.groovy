def call(body) {
  def pipelineParams= [:]
  body.resolveStrategy = Closure.DELEGATE_FIRST
  body.delegate = pipelineParams
  body()

  pipeline {
    agent any

    stages {
      stage('Checkout') {
        steps {
          //checkout scm
          echo "checkout"
        }
      }
      stage('Get Dockerfile') {
        steps {
          script {
            def tmpFile = libraryResource 'Dockerfile'
            writeFile file: 'Dockerfile', text: tmpFile
          }
        }
      }
      stage('Build') {
        steps {
          script {
            sh '''
              echo "version"
              echo "build -t ealebed/hellonode:latest ."
              echo "image ls"
            '''
          }
        }
      }
    }
  }
}
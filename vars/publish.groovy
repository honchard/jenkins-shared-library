def call() {
    stage("publish") {
        steps {
            script {
                sh """
                    echo "publish"
                """
            }
        }
    }
}
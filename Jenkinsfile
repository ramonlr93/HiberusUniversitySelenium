pipeline {
    agent any
    stages {
        stage('Run Test') {
            steps {
                sh '.mvnw clean test'
            }
        }
    }
}
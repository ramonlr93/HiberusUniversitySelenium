pipeline {
    agent any
    stages {
        stage('Run Test') {
            steps {
                sh './mvn clean test'
            }
        }
    }
}
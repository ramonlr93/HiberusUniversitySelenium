pipeline {

    agent any

    environment {
            currentDate = sh(returnStdout: true, script: 'date +%Y-%m-%d').trim()
        }

    stages {
        stage ('Directory') {
            steps {
               sh "ls -la"
            }
        }
//         stage ('stage 0') {
//             steps {
//                 cucumber jsonReportDirectory: 'alayans-server/build',
//                          reportTitle: 'Alayans report',
//                          fileIncludePattern: "**/cucumber-report.json",
//                          sortingMethod: 'ALPHABETICAL'
//             }
//         }
        stage ('Running All Test') {
            steps{
                sh "mvn clean test"
            }
        }
    }

    post {
        always {
            cucumber buildStatus: 'UNSTABLE',
                    reportTitle: 'My report',
                    fileIncludePattern: '**/cucumber.json',
                    sortingMethod: 'ALPHABETICAL',
                    trendsLimit: 100
        }
    }
}
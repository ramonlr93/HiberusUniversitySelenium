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
        stage ('Running All tests') {
            steps{
                sh "mvn clean test -Dcucumber.filter.tags=\"@pr-01\""
            }
        }
    }

//     post {
//         always {}
//     }
}
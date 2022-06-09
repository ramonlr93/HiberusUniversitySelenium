pipeline {

    agent any

    environment {
            currentDate = sh(returnStdout: true, script: 'date +%Y-%m-%d').trim()
        }

    stages {
        stage ('Running Tests') {
            steps {
               bat 'dir'
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
//         stage ('stage 1') {
//             steps{   }
//         }
    }

//     post {
//         always {}
//     }
}
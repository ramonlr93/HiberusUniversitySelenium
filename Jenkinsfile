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
//                          fileIncludePattern: "**/cucumber.json",
//                          sortingMethod: 'ALPHABETICAL'
//             }
//         }
        stage ('Running Test smoke') {
            steps{
                sh "mvn clean test -Dcucumber.filter.tags=\"@smoke\""
            }
        }

        stage ('Cucumber Report') {
            steps {
                cucumber buildStatus: 'UNSTABLE',
                            fileIncludePattern: "**/cucumber.json",
                            jsonReportDirectory: 'target'
            }
        }
    }
}
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
        stage ('Running Test smoke') {
            steps{
                sh "mvn clean test -Dcucumber.filter.tags=\"@smoke\""
            }
        }
    }

    post {
        always {
            cucumber buildStatus: 'UNSTABLE',
                    failedFeaturesNumber: 100,
                    failedScenariosNumber: 100,
                    skippedStepsNumber: 100,
                    failedStepsNumber: 100,
                    reportTitle: 'My report',
                    fileIncludePattern: '**/cucumber.json',
                    sortingMethod: 'ALPHABETICAL',
                    trendsLimit: 100
        }
    }
}
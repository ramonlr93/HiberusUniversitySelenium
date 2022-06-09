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
        failure {
            mail bcc: '',
                body: "<b>Example</b><br>Project: Open Cart <br>Build Number: ${env.BUILD_NUMBER} <br> URL de build: ${env.BUILD_URL}",
                cc: '',
                charset: 'UTF-8',
                from: '',
                mimeType: 'text/html',
                replyTo: '',
                subject: "ERROR CI: Project name -> Open Cart",
                to: "arielmarinfalcon@gmail.com"
        }
    }
}
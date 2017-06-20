pipeline {
    agent any
    stages {
        node {
           def mvnHome
           stage('Preparation') { // for display purposes
              steps {
                // Get some code from a GitHub repository
                              git 'https://github.com/silvionetto/projeto_maven.git'
                              // Get the Maven tool.
                              // ** NOTE: This 'M3' Maven tool must be configured
                              // **       in the global configuration.
                              mvnHome = tool 'Maven3.3.9'
              }
           }
           stage('Build') {
             steps {

              // Run the maven build
              if (isUnix()) {
                 sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
              } else {
                 bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
              }

             }
           }
           stage('Unit Test') {
              steps {
               // Run the maven build
              if (isUnix()) {
                 sh "'${mvnHome}/bin/mvn' test"
              } else {
                 bat(/"${mvnHome}\bin\mvn" test/)
              }
              }
           }
           stage('Integration Test') {
               steps {
               // Run the maven build
              if (isUnix()) {
                 sh "'${mvnHome}/bin/mvn' verify"
              } else {
                 bat(/"${mvnHome}\bin\mvn" verify/)
              }
              }
           }
           stage('Results') {
              steps {
                junit '**/target/surefire-reports/*.xml'
                archive 'target/*.jar'
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/specs/com/cpqi/fixture', reportFiles: 'App.html', reportName: 'HTML Report', reportTitles: ''])
              }
           }
           stage('Notify') {
               steps {
                   echo 'Notify'
               }
               post {
                    always {
                                echo 'Finish Build ${BUILD_NUMBER}!'
                            }
                    success {
                        mail bcc: '', body: 'Build sucesseful!', cc: '', from: '', replyTo: '', subject: 'Jenkins-${JOB_NAME}-${BUILD_NUMBER}', to: 'silvio.netto@gmail.com'
                    }
                    failure {
                        mail bcc: '', body: 'Please go to ${BUILD_URL} and verify the build', cc: '', from: '', replyTo: '', subject: 'Jenkins-${JOB_NAME}-${BUILD_NUMBER}', to: 'silvio.netto@gmail.com'
                    }
                }
           }
        }
    }
}
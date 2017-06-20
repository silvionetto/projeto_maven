node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/silvionetto/projeto_maven.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.
      mvnHome = tool 'Maven3.3.9'
   }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
   stage('Unit Test') {
       // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' test"
      } else {
         bat(/"${mvnHome}\bin\mvn" test/)
      }
   }
   stage('Integration Test') {
       // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' verify"
      } else {
         bat(/"${mvnHome}\bin\mvn" verify/)
      }
   }
   stage('Results') {
      junit '**/target/surefire-reports/*.xml'
      archive 'target/*.jar'
      publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/specs/com/cpqi/fixture', reportFiles: 'App.html', reportName: 'HTML Report', reportTitles: ''])
      step([$class: 'CoberturaPublisher', autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: '**/target/site/cobertura/coverage.xml', failUnhealthy: false, failUnstable: false, maxNumberOfBuilds: 0, onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false])
   }
}
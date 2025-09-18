pipeline {
    agent any

    tools {
        maven 'Maven3'   // Make sure 'Maven3' is configured in Jenkins tools
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests with coverage...'
                // Run tests and generate JaCoCo report
                bat 'mvn test jacoco:report'

                // Optional: list all files in target to debug
                bat 'dir target /s'
            }
        }
    }

    post {
        always {
            // Publish JUnit test results
            junit '**/target/surefire-reports/*.xml'

            // Publish JaCoCo HTML report
            publishHTML([
                reportDir: 'target/site/jacoco',
                reportFiles: 'index.html',
                reportName: 'JaCoCo Coverage Report',
                alwaysLinkToLastBuild: true,
                keepAll: true,
                allowMissing: true
            ])

            echo 'Pipeline completed with tests and coverage.'
        }
    }
}

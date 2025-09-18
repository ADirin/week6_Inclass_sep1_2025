pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                // Run tests with JaCoCo agent
                bat 'mvn test jacoco:report'
                // List target directory to verify reports
                bat 'dir target /s'
            }
        }
    }

    post {
        always {
            // Archive JUnit test results
            junit '**/target/surefire-reports/*.xml'

            // Optional: archive JaCoCo HTML report
            publishHTML([
                reportDir: 'target/site/jacoco',
                reportFiles: 'index.html',
                reportName: 'JaCoCo Coverage Report',
                keepAll: true,
                allowMissing: true
            ])

            echo 'Pipeline completed with tests and coverage'
        }
    }
}

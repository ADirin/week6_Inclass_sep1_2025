pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Code checkout completed'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'  // Run tests
                // List all files in target directory to see what's generated
                bat 'dir target /s'
            }
        }
    }

    post {
        always {
            // Try different patterns for test reports
            junit '**/target/surefire-reports/*.xml'
            junit '**/target/test-reports/*.xml'
            junit '**/target/*.xml'
            echo 'Pipeline completed'
        }
    }
}

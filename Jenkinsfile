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
                bat 'mvn test'
                bat 'dir target /s'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            echo 'Pipeline completed'
        }
    }
}

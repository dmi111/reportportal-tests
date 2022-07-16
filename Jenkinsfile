pipeline {
    agent any

    tools {
            maven 'TestMaven'
        }

    stages {
        stage ('Scanning') {
            steps {
                withSonarQubeEnv('My SonarQube Server') {
                    bat 'mvn clean package sonar:sonar'
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 1, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage ('Compile') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage ('Testing') {
            steps {
                bat 'mvn test'
            }
        }
    }
}

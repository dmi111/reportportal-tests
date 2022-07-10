pipeline {
    agent any

    tools {
            maven 'TestMaven'
        }

    stages {
        stage ('Install') {
            steps {
                bat '''docker run -d --network="host" --name="rp-test-framework" 6ae05c2eb934'''
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

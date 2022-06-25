pipeline {
    agent any

    tools {
            maven 'TestMaven'
        }

    stages {
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

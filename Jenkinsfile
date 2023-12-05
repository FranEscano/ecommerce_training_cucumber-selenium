pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                //Checkout the source code from your version control system (e.g., Git)
                checkout scm
            }
        }
        stage('Build') {
            steps {
               // Use Maven to build the project
               script {
                   bat "mvn clean install"
               }
            }
        }
    }

    post {
        success {
            // Actions to be performed after a successful build
            echo 'Build successful! Perform additional tasks here.'
        }
        failure {
            // Actions to be performed after a failed build
            echo 'Build failed! Perform additional tasks here.'
        }
    }
}

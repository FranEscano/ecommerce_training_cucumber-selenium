pipeline {
    agent any

    // environment {
    //     // Define Maven home if not automatically detected
    //     MAVEN_HOME = tool 'Maven'
    // }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from your version control system (e.g., Git)
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

       // // stage('Test') {
        //     steps {
        //         // Run tests using Maven
        //         script {
        //             bat "${MAVEN_HOME}/bin/mvn test"
        //         }
        //     }
        // }

        // stage('Deploy') {
        //     steps {
        //         // Perform deployment steps if needed
        //         script {
        //             // Example: Deploy the built artifacts to a repository or server
        //             // bat "${MAVEN_HOME}/bin/mvn deploy"
        //         }
        //     }
        // }
    }

    post {
        success {
            // Actions to be performed after a successful build
            echo 'Build successful! Perform additional tasks here. Please, work'
        }

        failure {
            // Actions to be performed after a failed build
            echo 'Build failed! Perform additional tasks here.'
        }
    }
}

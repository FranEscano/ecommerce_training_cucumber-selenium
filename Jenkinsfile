pipeline {
    agent any

    // 	 environment {
	//  		POSTMAN_API_KEY = credentials('POSTMAN_API_KEY')
	//  }

    stages {
        // stage('Checkout') {
        //     steps {
        //         // Checkout the source code from your version control system (e.g., Git)
        //         checkout scm
        //     }
        // }

        // stage('Build') {
        //     steps {
        //         // Use Maven to build the project
        //         script {
        //             bat "mvn clean install"
        //         }
        //     }
        // }


    stage('Install Postman CLI') {
      steps {
        bat 'powershell.exe -NoProfile -InputFormat None -ExecutionPolicy AllSigned -Command "[System.Net.ServicePointManager]::SecurityProtocol = 3072; iex ((New-Object System.Net.WebClient).DownloadString(\'https://dl-cli.pstmn.io/install/win64.ps1\'))"'
      }
    }

    stage('Postman CLI Login') {
      steps {
        bat 'postman login --with-api-key $POSTMAN_API_KEY'
        }
    }

    stage('Running collection') {
      steps {
        bat 'postman collection run "C:/Users/FranciscoEscano/Documents/Training/Products.postman_collection.json" -e "30536390-4d9a33a7-94fc-42f8-8be6-a4ff295bc753"'
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

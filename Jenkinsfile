import groovy.json.JsonSlurperClassic

def jsonParse(def json){
    new groovy.json.JsonSlurperClassic().parseText(json)
}
pipeline{
    agent {
        label 'master'
    }
    environment {
        appName = "variable"
    }
    stages{
        stage("step 1"){
            steps{
                script{
                    sh "echo 'hello world'"
                }
            }
        }
    }
    post{
        always{
            deleteDir()
                sh "echo 'stage always'"
        }
        success{
            sh "echo 'stage success'"
        }
        failure{
            sh "echo 'stage failure'"
        }
    }
}
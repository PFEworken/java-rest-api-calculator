pipeline {
    agent any
    tools {
        maven 'maven3'
        jdk 'jdk11'
    }
    stages {
        stage('Git Checkout') {
            steps {
                git changelog: false, poll: false, url: 'https://github.com/PFEworken/java-rest-api-calculator.git'
            }
        }
        stage('Compile & Test'){
            steps{
                sh "mvn clean compile"
                sh "mvn test"
            }
        }
    }
}

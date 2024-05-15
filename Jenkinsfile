pipeline {
    agent any
    tools {
        maven 'maven3'
        jdk 'jdk11'
    }
    environment {
        // Set SCANNER_HOME to point to SonarScanner tool
        SCANNER_HOME = tool 'sonar-scanner'
    }
    stages {
        stage('Git Checkout') {
            steps {
                git changelog: false, poll: false, url: 'https://github.com/PFEworken/java-rest-api-calculator.git'
            }
        }}}
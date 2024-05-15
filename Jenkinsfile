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
        }
        stage('Compile & Test'){
            steps{
                sh "mvn clean compile"
                sh "mvn test"
            }
        }
        stage('Sonarqube Analysis') {
            steps {
                // Add sonar.java.binaries property to specify compiled classes directory
                sh "$SCANNER_HOME/bin/sonar-scanner -X -Dsonar.url='http://20.51.234.67:9000/' -Dsonar.login=squ_c423ee1a190b9fb2721ce9398064e1314bd449bb -Dsonar.projectName=calcul -Dsonar.projectKey=calcul -Dsonar.java.binaries=target/classes"
            }
        }
        stage('Build'){
            steps{
                sh "mvn clean install"
            }
        }
        stage('OWASP') {
            steps {
                dependencyCheck additionalArguments: '--scan . --format HTML', odcInstallation: 'DP'
            }
        }
        stage('Build & Push Docker Image') {
            steps {
                withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPwd')]) {
                    sh "docker login -u pfeework -p ${dockerHubPwd}"
                }
                sh "docker build -t pfeework/calcul -f Dockerfile ."
                sh "docker push pfeework/calcul"
            }
        }
    }
}

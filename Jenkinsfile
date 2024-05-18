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
                sh "$SCANNER_HOME/bin/sonar-scanner -X -Dsonar.url='http://20.51.234.67:9000/' -Dsonar.login=squ_46bd61a5453a57e491e75c68187897c74bf14baa -Dsonar.projectName=calcul -Dsonar.projectKey=calcul -Dsonar.java.binaries=target/classes"
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
        stage('Docker Deploy ') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPwd')]) {
                        sh "docker login -u pfeework -p ${dockerHubPwd}"

                        // Define your container name
                        def CONTAINER_NAME = "calcul"

                        // Check if the container exists
                        def containerExists = sh(script: "docker ps -a --format '{{.Names}}' | grep -w ${CONTAINER_NAME}", returnStatus: true)

                        // If container exists, stop and remove it
                        if (containerExists == 0) {
                            sh "docker stop ${CONTAINER_NAME}"
                            sh "docker rm ${CONTAINER_NAME}"
                        }

                        // Now run the new container
                        sh "docker run -d --name ${CONTAINER_NAME} -p 8070:8070 pfeework/calcul"
                    }
                }
            }
    }
}}

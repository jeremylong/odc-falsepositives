pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh 'df';
                sh 'mvn -Dmaven.test.failure.ignore=true verify' 
            }
            post {
                success {
                    junit 'target/dependency-check-junit.xml' 
                }
            }
        }
    }
}

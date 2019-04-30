pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args  '-v /tmp:/tmp'
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
                sh 'touch target/dependency-check-junit.xml' 
            }
            post {
                success {
                    junit 'target/dependency-check-junit.xml' 
                }
            }
        }
    }
}

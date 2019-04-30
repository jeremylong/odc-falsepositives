pipeline {
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
                echo "building..."
            }
            post {
                success {
                    junit 'target/dependency-check-junit.xml' 
                }
            }
        }
    }
}

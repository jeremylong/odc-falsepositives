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
                sh 'rm -f /root/.m2/repository/org/owasp/dependency-check-utils/5.0.0-M3-SNAPSHOT/../../dependency-check-data/4.0/odc.update.lock';
                sh 'mvn -Dmaven.test.failure.ignore=true org.owasp:dependency-check-maven:5.0.0-m3-snapshot:purge verify' 
            }
            post {
                success {
                    junit 'target/dependency-check-junit.xml' 
                }
            }
        }
    }
}

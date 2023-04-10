pipeline {
    agent any
    tools { 
        maven 'maven-3.8.6' 
    }
    stages {
        stage('Checkout git') {
            steps {
               git branch: 'master', url: 'https://github.com/ahmedsch7/spring-test.git'
            }
        }
        stage('UNIT testing'){
            
            steps{
                
                script{
                    
                    sh 'mvn test'
                }
            }
        } 
        stage('Integration testing'){
            
            steps{
                
                script{
                    
                    sh 'mvn verify -DskipUnitTests'
                }
            }
        }
        stage('Maven build'){
            
            steps{
                
                script{
                    
                    sh 'mvn clean install'
                }
            }
        }
        stage('Docker Image Build'){
            
            steps{
                
                script{
                    
                    sh 'docker image build -t $JOB_NAME:v1.$BUILD_ID .'
                    sh 'docker image build $JOB_NAME:v1.$BUILD_ID ahmedschheider/$JOB_NAME:v1.$BUILD_ID'
                    sh 'docker image build $JOB_NAME:v1.$BUILD_ID ahmedschheider/$JOB_NAME:latest'
                }
            }
        } 
        stage('push image to the dockerhub'){
            
             steps{
                
                script{
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'DOCKERHUBPWD')]) {
                                            sh 'docker login -u ahmedschheider -p ${DOCKERHUBPWD}'
                                            sh 'docker image push ahmedschheider/$JOB_NAME:v1.$BUILD_ID'
                                            sh 'docker image push ahmedschheider/$JOB_NAME:latest'
                                            }
                }
            }
        } 
        stage('Deloy'){
            
            steps{
                
                script{
                    sh'''
                    docker run -d -p 9090:8080 ahmedschheider/$JOB_NAME:latest '''
                }
            }
        } 
    }
}

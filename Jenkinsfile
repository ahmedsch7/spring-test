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
//         stage('Static code analysis'){
            
//             steps{
                
//                 script{
                    
//                     withSonarQubeEnv(credentialsId: 'sonar-api') {
                        
//                         sh 'mvn clean package sonar:sonar'
//                     }
//                    }
                    
//                 }
//         }
        stage('Docker Image Build'){
            
            steps{
                
                script{
                    
                    sh 'docker image build -t ahmedschheider/devops:v1.18 .'
                   
                }
            }
        } 
        stage('push image to the dockerhub'){
            
             steps{
                
                script{
                    withCredentials([string(credentialsId: 'dockerhub-PWD', variable: 'DOCKERHUBPWD')]) {
                                            sh 'docker login -u ahmedschheider -p ${DOCKERHUBPWD}'
                                            sh 'docker image push ahmedschheider/devops:v1.18 '
                                        
                                            }
                }
            }
        } 
        stage('Deloy'){
            
            steps{
                
                script{
                    sh'''
                    docker run -d -p 5001:8081 ahmedschheider/devops:v1.18 '''
                }
            }
        } 
    }
}  

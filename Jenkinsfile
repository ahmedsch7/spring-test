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
        // stage('UNIT testing'){
            
        //     steps{
                
        //         script{
                    
        //             sh 'mvn test'
        //         }
        //     }
        // } 
        // stage('Integration testing'){
            
        //     steps{
                
        //         script{
                    
        //             sh 'mvn verify -DskipUnitTests'
        //         }
        //     }
        // }
        // stage('Maven build'){
            
        //     steps{
                
        //         script{
                    
        //             sh 'mvn clean install'
        //         }
        //     }
        // }
//         stage('Static code analysis'){
            
//             steps{
                
//                 script{
                    
//                     withSonarQubeEnv(credentialsId: 'sonar-api') {
                        
//                         sh 'mvn clean package sonar:sonar'
//                     }
//                    }
                    
//                 }
//         }
        // stage('Docker Image Build'){
            
        //     steps{
                
        //         script{
                    
        //             sh 'docker image build -t ahmedschheider/devops:v1.18 .'
                   
        //         }
        //     }
        // } 
        // stage('push image to the dockerhub'){
            
        //      steps{
                
        //         script{
        //             withCredentials([string(credentialsId: 'dockerhub-PWD', variable: 'DOCKERHUBPWD')]) {
        //                                     sh 'docker login -u ahmedschheider -p ${DOCKERHUBPWD}'
        //                                     sh 'docker image push ahmedschheider/devops:v1.18 '
                                        
        //                                     }
        //         }
        //     }
        // } 
        //stage('Deloy'){
            
            //steps{
                
                //script{
                    //sh'''
                    //docker run -d -p 5001:8081 ahmedschheider/devops:v1.18 '''
                //}
            //}
        //} 
 
       stage('deploy to production') {
            steps {
                script {
                     // connecting to production VM
                    sshagent(['ssh-key']) {
                        sh 'ssh root@167.99.153.105 "uname -a"'

                    }
                    //sh 'ssh user@vm-address "docker stop my-container && docker rm my-container"'
                     // Pull the new container from DockerHub
                    //docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                    //docker.pull('my-docker-image:latest')
                    //}

                     // Run the new container on the VM
                    //sshagent(['my-ssh-key']) {
                     //sh 'ssh user@vm-address "docker run -d --name my-container -p 8080:80 my-docker-image:latest"'
                    //}
                }
            }
        }
    }
}  

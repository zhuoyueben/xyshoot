pipeline {
    agent any

    stages {
        stage('pull code') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '6cbba934-a630-4ef2-ab81-4c0b56959f5a', url: 'git@192.168.153.135:xyshoot_group/xyshoot_demo.git']]])
            }
        }
        stage('build project') {
            steps {
                sh label: '', script: 'mvn clean package'
            }
        }
        stage('pulish project') {
            steps {
                deploy adapters: [tomcat8(credentialsId: 'fcc6248e-7424-4be9-85ce-b2c5291b4e99', path: '', url: 'http://192.168.153.133:8080/')], contextPath: null, war: 'target/*.war'
            }
        }
    }
}

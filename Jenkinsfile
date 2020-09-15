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
     post {
            success {
                emailext (
                    subject: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                    body: """<p>SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
                        <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>"</p>""",
                    to: "2487186110@qq.com",
                    from: "xutea123456@sina.com"
                )
            }
            failure {
                emailext (
                    subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                    body: """<p>FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
                        <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>"</p>""",
                    to: "2487186110@qq.com",
                    from: "xutea123456@sina.com"
                )
            }
      }
}

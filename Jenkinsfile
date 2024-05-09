pipeline {
    agent any

    tools {
        maven 'maven'
    }

    stages {
         /*  stage('Build') {
            steps {
                git 'https://github.com/jglick/simple-maven-project-with-tests.git'
                bat 'mvn -Dmaven.test.failure.ignore=true clean package'
            }
            post {
                success {
                    junit '**//*  *//*  *//*  *//* target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target *//*  *//*  *//*  *//*.jar'
                }
            }
        } */

        stage('Deploy to QA') {
            steps {
                echo ('Deploying to QA done')
            }
        }

        stage('Regression API Automation Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/hiteshdarji162021/RestAssuredAPIAutomationFramework.git'
                    bat "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_regression.xml"
                }
            }
        }

        stage('Publish Allure Reports') {
            steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'allure-results']]
                    ])
                }
            }
        }

        stage('Publish Extent Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'reports',
                    reportFiles: 'TestExecutionReport.html',
                    reportName: 'API HTML Regression Extent Report',
                    reportTitles: ''
                ])
            }
        }

        stage('Deploy to Stage') {
            steps {
                echo ("Deploying to Stage...")
            }
        }

        stage('Sanity Automation Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/hiteshdarji162021/RestAssuredAPIAutomationFramework.git'
                    bat "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_sanity.xml"
                }
            }
        }

        stage('Publish Sanity Extent Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'reports',
                    reportFiles: 'TestExecutionReport.html',
                    reportName: 'HTML Sanity Extent Report',
                    reportTitles: ''
                ])
            }
        }
    }
}
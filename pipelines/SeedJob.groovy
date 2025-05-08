pipeline {
    agent any

    stages {
        stage('Get DSL files') {
            steps {
                git(
                    url: 'https://github.com/MAtWich/jenkins-dsl-scripts.git',
                    branch: 'main'
                )
            }
        }
        stage('Run DSL') {
            steps {
                jobDsl(targets: params.DSL_SCRIPT, removedJobAction: "IGNORE", removedViewAction: "IGNORE")
            }
        }
    }
}
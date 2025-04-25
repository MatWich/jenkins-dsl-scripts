pipelineJob("my-first-job") {
    description("MY FIRST JOB FROM DSL!")

    parameters {
        choiceParam('FIGHTER', ["Andrzejek", "Macius", "Rysiu", "Janusz"], "Choose your fighter")
    }

    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url("https://github.com/MatWich/jenkins-dsl-scripts.git")
                    }
                    branch("main")
                }
            }
            scriptPath("pipelines/MyFirstJob.groovy")
            lightweight(false)
        }
    }
}
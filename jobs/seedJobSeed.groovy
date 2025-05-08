pipelineJob('seed-job-from-repo') {
    description('Woow seed job')
    logRotator {
        daysToKeep(60)
        numToKeep(100)
    }

    parameters {
        gitParameterDefinition {
            name('BRANCH')
            description("My awesom param")
            type('BRANCH')
            defaultValue('main')
            useRepository("https://github.com/MatWich/jenkins-dsl-scripts.git")
            listSize("0")

            branch('')
            branchFilter('origin/(.*)')
            tagFilter('*')
            sortMode('DESCENDING_SMART')
            selectedValue('DEFAULT')
            quickFilterEnabled(true)
        }
        stringParam('DSL_SCRIPT', 'jobs/*.groovy', "Wild card for all")
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
            scriptPath("pipelines/SeedJob.groovy")
            lightweight(true)
        }
    }
}
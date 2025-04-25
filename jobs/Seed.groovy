freeStyleJob("seed") {
    logRotator(1, 10)
    scm {
        git {
            remote {
                url('https://github.com/MatWich/jenkins-dsl-scripts.git')
            }
            branch('main')
        }
    }

    steps {
        dsl {
            fromFilesystem('jobs/MyFirstJobSeed.groovy', 'jobs/Seed.groovy')
            ignoreMissingFiles(false)

        }
    }
}
freeStyleJob("seed-test") {
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
            seedFrom('jobs/*.groovy')
            ignoreMissingFiles(false)

        }
    }
}
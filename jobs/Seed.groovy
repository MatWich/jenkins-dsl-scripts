job("seed-test") {
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
            setScriptText('''def dslScripts = findFiles(glob: 'jobs/**/*.groovy')
            for (File dslScriptFile in dslScripts) {
                def dslScriptText = readFile(dslScriptFile.path)
                jobDsl(dslScriptText)
            }
            ignoreMissingFiles(false)
            ''')
        }
    }
}
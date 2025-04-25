import com.agroniks.utils.Descriptions
import com.agroniks.utils.Constants
import com.agroniks.utils.Parameters

pipelineJob("my-first-job") {
    description(Descriptions.FIRST_JOB)

    parameters {
        choiceParam('FIGHTER', Constants.FIGHTERS, Description.FIGHTERS)
    }

    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url(Constants.JENKINS_DSL_REPO_URL_HTTPS)
                    }
                    branch("main")
                }
            }
            scriptPath("pipelines/MyFirstJob.groovy")
            lightweight(false)
        }
    }
}
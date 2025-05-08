
pipeline {
    agent any

    environment {
        AWESOME_NAME = "Lunk"
    }

    stages  {
        stage("My first stage") {
            steps {
                echo "Found awesome name ${FIGHTER}"
            }
        }

        stage("Second stage") {
            steps {
                echo "So first stage is not alone :)"
            }
        }
    }
}
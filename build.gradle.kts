import org.sourcegrade.jagr.gradle.task.grader.GraderRunTask

plugins {
    alias(libs.plugins.algomate)
}

exercise {
    assignmentId.set("h05")
}

submission {
    // ACHTUNG!
    // Setzen Sie im folgenden Bereich Ihre TU-ID (NICHT Ihre Matrikelnummer!), Ihren Nachnamen und Ihren Vornamen
    // in Anführungszeichen (z.B. "ab12cdef" für Ihre TU-ID) ein!
    // BEISPIEL:
    // studentId = "ab12cdef"
    // firstName = "sol_first"
    // lastName = "sol_last"
    studentId = "cs52mina"
    firstName = "CalinGeorge"
    lastName = "Sobaru"

    // Optionally require own tests for mainBuildSubmission task. Default is false
    requireTests = false
}

tasks {
    withType<GraderRunTask> {
        doFirst {
            throw GradleException("No public tests are provided for this exercise! For more information go to https://moodle.informatik.tu-darmstadt.de/mod/page/view.php?id=68766")
        }
    }
}

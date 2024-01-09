plugins {
    id("org.ajoberstar.grgit") version ("5.2.1")
}

//TODO :  task jbakeGhPagesTests
tasks.register("jbakeGhPagesTests") {
    group = "JbakeGhPages"
    description = "Tests JbakeGhPages."
    doLast { println(":jbakeGhPagesTests") }
}

//TODO :  task jbakeGhPagesInit
tasks.register("jbakeGhPagesInit") {
    group = "JbakeGhPages"
    description = "Initialize a bake in a empty folder."
    dependsOn("jbakeGhPagesTests")
    doLast { println(":jbakeGhPagesInit") }
}

//TODO :  task jbakeGhPagesServe
tasks.register("jbakeGhPagesServe") {
    group = "JbakeGhPages"
    description = "Run server to preview bake on localhost."
    doLast { println(":jbakeGhPagesServe") }
}

//TODO :  task jbakeGhPagesPublish
tasks.register("jbakeGhPagesPublish") {
    group = "JbakeGhPages"
    description = "Publish bake to github-pages."
    dependsOn("jbakeGhPagesTests")
    doLast { println(":jbakeGhPagesPublish") }
}

//TODO :  task jbakeGhPagesCommitAndPush
tasks.register("jbakeGhPagesCommitAndPush") {
    group = "JbakeGhPages"
    description = "Commit and push sources to github repository."
    doLast {
        println(":jbakeGhPagesCommitAndPush")
//        grgit.add(pattern = "**/*")
//        grgit.commit(message = "Votre message de commit")
//        grgit.push()
    }
}


//TODO :  task talariaFrontendTests
tasks.register("talariaFrontendTests") {
    group = "Talaria"
    description = "Test frontend."
    doLast { println(":talariaFrontendTests") }
}

//TODO :  task talariaFrontendPublish
tasks.register("talariaFrontendPublish") {
    group = "Talaria"
    description = "Publish Talaria frontend to github-pages."
    dependsOn("talariaFrontendTests")
    doLast { println(":talariaFrontendPublish") }
}


//TODO :  task talariaBackofficeTests
tasks.register("talariaBackofficeTests") {
    group = "Talaria"
    description = "Test backoffice."
    doLast { println(":talariaBackofficeTests") }
}

//TODO :  task talariaBackofficePush
tasks.register("talariaBackofficePush") {
    group = "Talaria"
    description = "Push backoffice script to google workspace."
    dependsOn("talariaBackofficeTests")
    doLast { println(":talariaBackofficePush") }
}
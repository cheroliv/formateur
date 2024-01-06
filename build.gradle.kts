plugins {
    id("org.ajoberstar.grgit") version ("5.2.1")
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
//TODO :  task jbakeGhPagesServer
tasks.register("jbakeGhPagesServer") {
    group = "JbakeGhPages"
    description = "Run server to preview bake on localhost."
    doLast { println(":jbakeGhPagesServer") }
}
//TODO :  task jbakeGhPagesInit
tasks.register("jbakeGhPagesInit") {
    group = "JbakeGhPages"
    description = "Initialize a bake in a empty folder."
    doLast { println(":jbakeGhPagesInit") }
}
//TODO :  task jbakeGhPagesPublish
tasks.register("jbakeGhPagesPublish") {
    group = "JbakeGhPages"
    description = "Publish bake to github-pages."
    doLast { println(":jbakeGhPagesPublish") }
}

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.registerKotlinModule


plugins {
    //https://github.com/avast/gradle-docker-compose-plugin
    id("com.avast.gradle.docker-compose") version ("0.17.5")
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }

    dependencies {
        val jacksonVersion = "2.15.2"
        classpath("org.slf4j:slf4j-simple:2.0.7")
        classpath("commons-io:commons-io:2.13.0")
        classpath("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
        classpath("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonVersion")
        classpath("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
        classpath("org.tukaani:xz:1.9")
        classpath("com.avast.gradle:gradle-docker-compose-plugin:0.17.5")
    }
}

repositories { mavenCentral() }
/*=================================================================================*/

private val mapper: ObjectMapper by lazy {
    ObjectMapper(YAMLFactory()).apply {
        disable(WRITE_DATES_AS_TIMESTAMPS)
        registerKotlinModule()
    }
}
/*=================================================================================*/

data class Formation(
    val nom: String,
    val spg: SPG
)

/**
 * SPG: Scénario Pédagogique Global
 */
data class SPG(
    val theme: String = "",
    val titre: String = "",
    val presentation: String = "",
    val mindmap: String = "",
    val publicProspect: String = "",
    val prerequiz: String = "",
    val objs: String = "",
    val competences: String = "",
    val timing: String = "",
    val means: String = "",
    val prgm: String = "",
    val eval: String = "",
    val certif: String = "",
    val place: String = "",
    val price: String = "",
    val infra: String = "",
    val pursuit: String = "",
    val accessTime: String = "",
    val mobility: String = "",
    val testimony: String = "",
    val testimonyCustomer: String = "",
    val spd: SPD = SPD(),
    val content: List<Triple<*, String, String>>? = listOf(
        Triple(theme, "theme", "Thème"),
        Triple(titre, "title", "Titre"),
        Triple(presentation, "prez", "Présentation et description"),
        Triple(mindmap, "mindmap", "Carte thématique"),
        Triple(publicProspect, "public", "Public"),
        Triple(prerequiz, "prerequiz", "Pré-requis et conditions d’accès à la formation (Qualiopi)"),
        Triple(objs, "objs", "Objectifs pédagogiques (Qualiopi)"),
        Triple(competences, "competences", "Compétences visées (Qualiopi)"),
        Triple(timing, "timing", "Durée (Temporisation)] (Qualiopi)"),
        Triple(means, "means", "Moyen d’accompagnement et Suivi pédagogique (Qualiopi)"),
        Triple(
            prgm,
            "prgm",
            "Programme pédagogique (Modalités pédagogiques)] (Qualiopi) : du contenu et du séquencement"
        ),
        Triple(eval, "eval", "Modalités d’évaluations] (Qualiopi)"),
        Triple(certif, "certif", "Modalités de certification et Certification visé] (Qualiopi)"),
        Triple(place, "place", "Lieux] (Qualiopi)"),
        Triple(price, "price", "Tarifs"),
        Triple(infra, "infra", "Moyens logistiques et matériels] (Qualiopi)"),
        Triple(pursuit, "pursuit", "Poursuite en formation] (Qualiopi)"),
        Triple(accessTime, "access_time", "Délais d’accès] (Réglementaire)"),
        Triple(mobility, "mobility", "Accessibilité et Handicap] (Qualiopi)"),
        Triple(testimony, "testimony", "Témoignage Evaluation de la formation] (Qualiopi)"),
        Triple(testimonyCustomer, "testimony_customer", "Témoignage apprenant/commanditaire")
    )
)

/**
 * SPD: Scénario Pédagogique Détaillé
 */
data class SPD(
    val titre: String="",
    val objectif: String=""
)
/*=================================================================================*/

tasks.register("spg") {
    group = "FPA"
    description = "Show SPG."
    doFirst {
        SPG().run {
            println(mapper.writeValueAsString(this))
            println(mapper.writeValueAsString(spd))
        }
    }
}


/*=================================================================================*/

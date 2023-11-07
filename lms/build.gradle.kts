import com.fasterxml.jackson.core.JsonFactory
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

data class Formation(
    val nom: String,
    val spg: SPG
)

/**
 * SPG: Scénario Pédagogique Global
 */
data class SPG(
    val spd: SPD = SPD(),
    val content: List<Triple<String, String, String>>? = listOf(
        Triple("theme", "Thème", "theme"),
        Triple("title", "Titre", "titre"),
        Triple("prez", "Présentation et description", "presentation"),
        Triple("mindmap", "Carte thématique", "mindmap"),
        Triple("public", "Public", "publicProspect"),
        Triple("prerequiz", "Pré-requis et conditions d’accès à la formation (Qualiopi)", "prerequiz"),
        Triple("objs", "Objectifs pédagogiques (Qualiopi)", "objs"),
        Triple("competences", "Compétences visées (Qualiopi)", "competences"),
        Triple("timing", "Durée (Temporisation)] (Qualiopi)", "timing"),
        Triple("means", "Moyen d’accompagnement et Suivi pédagogique (Qualiopi)", "means"),
        Triple(
            "prgm",
            "Programme pédagogique (Modalités pédagogiques)] (Qualiopi) : du contenu et du séquencement", "prgm"
        ),
        Triple("eval", "Modalités d’évaluations] (Qualiopi)", "eval"),
        Triple("certif", "Modalités de certification et Certification visé] (Qualiopi)", "certif"),
        Triple("place", "Lieux] (Qualiopi)", "place"),
        Triple("price", "Tarifs", "price"),
        Triple("infra", "Moyens logistiques et matériels] (Qualiopi)", "infra"),
        Triple("pursuit", "Poursuite en formation] (Qualiopi)", "pursuit"),
        Triple("access_time", "Délais d’accès] (Réglementaire)", "accessTime"),
        Triple("mobility", "Accessibilité et Handicap] (Qualiopi)", "mobility"),
        Triple("testimony", "Témoignage Evaluation de la formation] (Qualiopi)", "testimony"),
        Triple("testimony_customer", "Témoignage apprenant/commanditaire", "testimonyCustomer")
    )
)

/**
 * SPD: Scénario Pédagogique Détaillé
 */
data class SPD(
    val titre: String = "",
    val objectif: String = ""
)

/*=================================================================================*/

private val yaml: ObjectMapper by lazy {
    ObjectMapper(YAMLFactory()).apply {
        disable(WRITE_DATES_AS_TIMESTAMPS)
        registerKotlinModule()
    }
}

private val json: ObjectMapper by lazy {
    ObjectMapper(JsonFactory()).apply {
        disable(WRITE_DATES_AS_TIMESTAMPS)
        registerKotlinModule()
    }
}

/*=================================================================================*/

tasks.register("spg") {
    group = "FPA"
    description = "Show SPG."
    doFirst {
        SPG().run {
            println(yaml.writeValueAsString(this))
//            println(yaml.writeValueAsString(spd))
//            println(json.writeValueAsString(this))
//            println(json.writeValueAsString(spd))
        }
    }
}

/*=================================================================================*/

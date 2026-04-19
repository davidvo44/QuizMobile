package com.example.quizzjeux

object QuestionList {

    val questions = listOf(
        QuestionAnswer(
            "Que trouve-t-on dans les allées du labyrinthe du jeu vidéo Pac-Man ?",
            listOf("Des plantes Carnivores", "Des aliens", "Des fantômes", "Des squelettes"),
            2,
            R.drawable.question_1
        ),
        QuestionAnswer(
            "À quel(s) personnage(s) de jeux vidéo, les Lapins Crétins sont-ils associés ?",
            listOf("Mario", "Crash Bandicoot", "Sonic", "Rayman"),
            3,
            R.drawable.question_2
        ),
        QuestionAnswer(
                "De quelle saga de jeux vidéo sont originaires des personnages comme Sephiroth, Cloud ou bien Yuna ?",
        listOf("Soulcalibur", "Castlevania", "Final Fantasy", "Devil May Cray"),
        2,
        R.drawable.question_3
    )
    )

    val questionsGeo = listOf(
        QuestionAnswer(
            "Quel est la capitale du Brésil",
            listOf("Rio de Janeiro", "Sao Paulo", "Brasilia", "Bueno Aires"),
            2,
            R.drawable.question_1geo
        ),
        QuestionAnswer(
            "Quel pays est associé à ce drapeau ?",
            listOf("Tchad", "Andorre", "Roumanie", "Moldavie"),
            3,
            R.drawable.question_2geo
        ),
        QuestionAnswer(
            "Quel pays est associé à ce drapeau ?",
            listOf("Bolivie", "Colombie", "Uruguay", "Vénézuela"),
            2,
            R.drawable.question_3geo
        )
    )
}
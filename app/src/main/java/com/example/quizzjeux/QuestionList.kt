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
        )
    )
}
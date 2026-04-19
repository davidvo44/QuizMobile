package com.example.quizzjeux

data class QuestionAnswer(
    val question: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val image: Int
)

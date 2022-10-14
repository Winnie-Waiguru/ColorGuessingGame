package com.example.colorguessinggame

data class Quiz(
    val id: Int,
    val image: Int,
    val question:String,
    val answerOne: String,
    val answerTwo: String,
    val answerThree: String,
    val answerFour: String,
    val correctAnswer: Int,

        )
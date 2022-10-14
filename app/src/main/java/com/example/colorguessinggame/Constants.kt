package com.example.colorguessinggame

object Constants {

    fun getQuizList(): ArrayList<Quiz>{
        val quizList = ArrayList<Quiz>()

        val questionOne = Quiz(
            1,
            R.drawable.ic_baseline_egg_24,
            "What color is shown above?",
            "Green",
            "Blue",
            "Brown",
            "Purple",
            3
        )
        quizList.add(questionOne)

        val questionTwo = Quiz(
            2,
            R.drawable.ic_baseline_square_24,
            "What color is shown above?",
            "Blue",
            "Red",
            "Orange",
            "Black",
            1
        )
        quizList.add(questionTwo)

        val questionThree = Quiz(
            3,
            R.drawable.ic_baseline_bedtime_24,
            "What color is shown above?",
            "White",
            "Blue",
            "Brown",
            "Orange",
            4
        )
        quizList.add(questionThree)

        val questionFour = Quiz(
            4,
            R.drawable.ic_baseline_star_24,
            "What color is shown above?",
            "Black",
            "Red",
            "Green",
            "Pink",
            2
        )
        quizList.add(questionFour)

        val questionFive = Quiz(
            5,
            R.drawable.ic_baseline_category_24,
            "What color is shown above?",
            "Pink",
            "Blue",
            "Yellow",
            "Purple",
            4
        )
        quizList.add(questionFive)

        val questionSix = Quiz(
            6,
            R.drawable.ic_baseline_circle_24,
            "What color is show above?",
            "Green",
            "Pink",
            "Yellow",
            "Brown",
            1
        )
        quizList.add(questionSix)


        return quizList

    }
}
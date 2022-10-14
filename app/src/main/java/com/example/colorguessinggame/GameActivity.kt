package com.example.colorguessinggame

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.colorguessinggame.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity(), View.OnClickListener{
    lateinit var binding: ActivityGameBinding

    private var newCurrentPosition: Int = 1
    private var theQuizList: ArrayList<Quiz>? = null
    private var selectedAnswerPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        theQuizList = Constants.getQuizList()

        allocateQuestion()

        binding.tvAnswerOne.setOnClickListener(this)
        binding.tvAnswerTwo.setOnClickListener(this)
        binding.tvAnswerThree.setOnClickListener(this)
        binding.tvAnswerFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)


    }

    private fun allocateQuestion(){


        val quiz = theQuizList!![newCurrentPosition - 1]

        if (newCurrentPosition == theQuizList!!.size){
            binding.btnSubmit.text = "FINISH"
        }
        else{
            binding.btnSubmit.text = "SUBMIT"
        }

        binding.ivFigure.setImageResource(quiz.image)
        binding.tvInstructions.text = quiz!!.question
        binding.tvAnswerOne.text = quiz.answerOne
        binding.tvAnswerTwo.text = quiz.answerTwo
        binding.tvAnswerThree.text = quiz.answerThree
        binding.tvAnswerFour.text = quiz.answerFour
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0?.id) {
                R.id.tvAnswerOne -> {
                    selectedAnswer(binding.tvAnswerOne, 1)
                }
                R.id.tvAnswerTwo -> {
                    selectedAnswer(binding.tvAnswerTwo, 2)
                }
                R.id.tvAnswerThree -> {
                    selectedAnswer(binding.tvAnswerThree, 3)
                }
                R.id.tvAnswerFour -> {
                    selectedAnswer(binding.tvAnswerFour, 4)
                }
                R.id.btnSubmit -> {
                    if (selectedAnswerPosition == 0) {
                        newCurrentPosition++

                        when {
                            newCurrentPosition <= theQuizList!!.size -> {
                                allocateQuestion()

                            }
                            else -> {
                                Toast.makeText(
                                    this, "Congratulations!! You have completed the quiz.",
                                    Toast.LENGTH_SHORT
                                ).show()
                                val intent = Intent(this, HomeActivity::class.java)
                                startActivity(intent)
                            }
                        }

                    } else {
                        val quiz = theQuizList?.get(newCurrentPosition - 1)
                        if (quiz!!.correctAnswer != selectedAnswerPosition) {
                            answerView(
                                selectedAnswerPosition,
                                R.drawable.incorrect_border_background
                            )

                        }
                        answerView(quiz.correctAnswer, R.drawable.correct_border_background)
                        Toast.makeText(this, "Green button answer is Correct", Toast.LENGTH_SHORT)
                            .show()

                        if (newCurrentPosition == theQuizList!!.size) {
                            binding.btnSubmit.text = "FINISH"
                        } else {
                            binding.btnSubmit.text = "NEXT QUESTION"
                        }
                        selectedAnswerPosition = 0
                    }
                }
            }

        }
    }

    private fun answerView(answer: Int, colorShow: Int){
        when(answer){
            1 ->{
                binding.tvAnswerOne.background = ContextCompat.getDrawable(this, colorShow)
            }
            2 ->{
                binding.tvAnswerTwo.background = ContextCompat.getDrawable(this, colorShow)
            }
            3 ->{
                binding.tvAnswerThree.background = ContextCompat.getDrawable(this, colorShow)
            }
            4 ->{
                binding.tvAnswerFour.background = ContextCompat.getDrawable(this, colorShow)
            }
        }
    }

    private fun selectedAnswer(choice: TextView, selectedAnswerNumber:Int){

        selectedAnswerPosition = selectedAnswerNumber

        choice.setTextColor(Color.parseColor("#AAA883"))
            choice.setTypeface(choice.typeface, Typeface.BOLD)
        choice.background = ContextCompat.getDrawable(this, R.drawable.selected_border_background)

    }
}
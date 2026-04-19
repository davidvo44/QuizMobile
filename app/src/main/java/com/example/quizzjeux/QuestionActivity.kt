package com.example.quizzjeux

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizzjeux.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionBinding

    private lateinit var questionList: List<QuestionAnswer>


    private var currentQuestionIndex = 0
    private var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val category = intent.getStringExtra("CATEGORY")
        if (category == "GAME"){
            questionList = QuestionList.questions
        } else {
            questionList = QuestionList.questionsGeo
        }
        displayQuestion()

        binding.response1Button.setOnClickListener {
            checkAnswer(0)
        }
        binding.response2Button.setOnClickListener {
            checkAnswer(1)
        }
        binding.response3Button.setOnClickListener {
            checkAnswer(2)
        }
        binding.response4Button.setOnClickListener {
            checkAnswer(3)
        }
        binding.restartButton.setOnClickListener {
            restartQuiz()
        }
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun correctButtonColors(buttonIndex: Int){
        when(buttonIndex){
            0 -> binding.response1Button.setBackgroundColor(Color.GREEN)
            1 -> binding.response2Button.setBackgroundColor(Color.GREEN)
            2 -> binding.response3Button.setBackgroundColor(Color.GREEN)
            3 -> binding.response4Button.setBackgroundColor(Color.GREEN)
        }
    }

    private fun wrongButtonColors(buttonIndex: Int){
        when (buttonIndex){
            0 -> binding.response1Button.setBackgroundColor(Color.RED)
            1 -> binding.response2Button.setBackgroundColor(Color.RED)
            2 -> binding.response3Button.setBackgroundColor(Color.RED)
            3 -> binding.response4Button.setBackgroundColor(Color.RED)
        }
    }

    private fun resetButtonColors(){
        binding.response1Button.setBackgroundColor(Color.rgb(50,59,96))
        binding.response2Button.setBackgroundColor(Color.rgb(50,59,96))
        binding.response3Button.setBackgroundColor(Color.rgb(50,59,96))
        binding.response4Button.setBackgroundColor(Color.rgb(50,59,96))
    }

    private fun showResults(){
        Toast.makeText(this, "Your score: $score out of ${questionList.size}", Toast.LENGTH_LONG).show()
        binding.restartButton.isEnabled = true
    }

    private fun displayQuestion(){
        binding.ImageQuestion.setImageResource(questionList[currentQuestionIndex].image)
        binding.QuestionText.text = questionList[currentQuestionIndex].question
        binding.response1Button.text = questionList[currentQuestionIndex].options[0]
        binding.response2Button.text = questionList[currentQuestionIndex].options[1]
        binding.response3Button.text = questionList[currentQuestionIndex].options[2]
        binding.response4Button.text = questionList[currentQuestionIndex].options[3]
        resetButtonColors()
    }

    private fun checkAnswer(selectedAnswerIndex: Int){
        val correctAnswerIndex = questionList[currentQuestionIndex].correctAnswerIndex

        if (selectedAnswerIndex == correctAnswerIndex){
            score++
            correctButtonColors(selectedAnswerIndex)
        } else {
            wrongButtonColors(selectedAnswerIndex)
            correctButtonColors(correctAnswerIndex)
        }
        if (currentQuestionIndex < questionList.size - 1){
            currentQuestionIndex++
            binding.QuestionText.postDelayed({displayQuestion()}, 1000)
        } else {
            showResults()
        }
    }

    private fun restartQuiz(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
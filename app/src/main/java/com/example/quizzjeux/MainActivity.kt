package com.example.quizzjeux

import android.R
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizzjeux.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val questions = arrayOf(
        "Que fait 1 + 1?",
        "Que fait 2*2?")

    private val options = arrayOf(
        arrayOf("1", "2", "3"),
        arrayOf("2", "4", "8"))

    private val correctAnswers = arrayOf(1,1)

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

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
        binding.restartButton.setOnClickListener {
            restartQuiz()
        }
    }

    private fun correctButtonColors(buttonIndex: Int){
        when(buttonIndex){
            0 -> binding.response1Button.setBackgroundColor(Color.GREEN)
            1 -> binding.response2Button.setBackgroundColor(Color.GREEN)
            2 -> binding.response3Button.setBackgroundColor(Color.GREEN)
        }
    }

    private fun wrongButtonColors(buttonIndex: Int){
        when (buttonIndex){
            0 -> binding.response1Button.setBackgroundColor(Color.RED)
            1 -> binding.response2Button.setBackgroundColor(Color.RED)
            2 -> binding.response3Button.setBackgroundColor(Color.RED)
        }
    }

    private fun resetButtonColors(){
        binding.response1Button.setBackgroundColor(Color.rgb(50,59,96))
        binding.response2Button.setBackgroundColor(Color.rgb(50,59,96))
        binding.response3Button.setBackgroundColor(Color.rgb(50,59,96))
    }

    private fun showResults(){
        Toast.makeText(this, "Your score: $score out of ${questions.size}", Toast.LENGTH_LONG).show()
        binding.restartButton.isEnabled = true
    }

    private fun displayQuestion(){
        binding.QuestionText.text = questions[currentQuestionIndex]
        binding.response1Button.text = options[currentQuestionIndex][0]
        binding.response2Button.text = options[currentQuestionIndex][1]
        binding.response3Button.text = options[currentQuestionIndex][2]
        resetButtonColors()
    }

    private fun checkAnswer(selectedAnswerIndex: Int){
        val correctAnswerIndex = correctAnswers[currentQuestionIndex]

        if (selectedAnswerIndex == correctAnswerIndex){
            score++
            correctButtonColors(selectedAnswerIndex)
        } else {
            wrongButtonColors(selectedAnswerIndex)
            correctButtonColors(correctAnswerIndex)
        }
        if (currentQuestionIndex < questions.size - 1){
            currentQuestionIndex++
            binding.QuestionText.postDelayed({displayQuestion()}, 1000)
        } else {
            showResults()
        }
    }

    private fun restartQuiz(){
        currentQuestionIndex = 0
        score = 0
        displayQuestion()
        binding.restartButton.isEnabled = false
    }
}
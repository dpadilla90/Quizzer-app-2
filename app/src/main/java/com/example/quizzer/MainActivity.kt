package com.example.quizzer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.quizzer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //The ActivityMainBinding class is generated from the layout file (activity_main.xml)
    private lateinit var binding: ActivityMainBinding
    private var currentQuestionIndex = 0

    private val questions = listOf(
        R.string.question_france,
        R.string.question_planet,
        R.string.question_art


    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        //This makes the views defined in activity_main.xml accessible
        //for the UI of this activity
        setContentView(binding.root)


        binding.trueButton.setOnClickListener {
            Toast.makeText(
                this,
                R.string.correct_toast,
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.falseButton.setOnClickListener {
            Toast.makeText(
                this,
                R.string.incorrect_toast,
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.nextButton.setOnClickListener {
            currentQuestionIndex = (currentQuestionIndex +1) % questions.size
            //0 -> 1  % 3 = 1
            //1 -> 2  % 3 = 2
            //2 -> 3  % 3 = 0
            binding.questionTextView.setText(questions[currentQuestionIndex])
        }

        binding.previousButton.setOnClickListener {
            currentQuestionIndex = (currentQuestionIndex - 1 + questions.size) % questions.size
            // 0 -> -1 + 3 = 2 % 3 = 2
            // 1 ->  0 + 3 = 3 % 3 = 0
            // 2 ->  1 + 3 = 4 % 3 = 1
            binding.questionTextView.setText(questions[currentQuestionIndex])
        }

    }


}
package com.csibtn.quizapp
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.csibtn.quizapp.databinding.ActivityQuizQuestionsBinding


class QuizQuestionsActivity : AppCompatActivity() {


    private lateinit var tvProgress : TextView
    private lateinit var progressBar : ProgressBar
    private lateinit var  imageView : ImageView
    private lateinit var  tvQuestion: TextView


    private lateinit var firstOption : TextView
    private lateinit var secondOption : TextView
    private lateinit var thirdOption : TextView
    private lateinit var fourthOption : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindingQuiz = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(bindingQuiz.root)

        tvProgress = bindingQuiz.tvProgress
        progressBar = bindingQuiz.progressBar
        imageView = bindingQuiz.imImage
        tvQuestion = bindingQuiz.tvQuestion
        firstOption = bindingQuiz.firstOption
        secondOption = bindingQuiz.secondOption
        thirdOption = bindingQuiz.thirdOption
        fourthOption = bindingQuiz.fourthOption

        val questions = Constants.getQuestions()

        var currentPosition = 1
        val question = questions[currentPosition - 1]
        progressBar.progress = currentPosition
        tvProgress.text = "$currentPosition/${progressBar.max}"
        tvQuestion.text = question.question
        imageView.setImageResource(question.image)
        firstOption.text = question.firstOption
        secondOption.text = question.secondOption
        thirdOption.text = question.thirdOption
        fourthOption.text = question.fourthOption
    }
}
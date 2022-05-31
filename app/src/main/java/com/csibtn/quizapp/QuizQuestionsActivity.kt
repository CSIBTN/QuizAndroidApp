package com.csibtn.quizapp
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.csibtn.quizapp.databinding.ActivityQuizQuestionsBinding


class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var currentPosition : Int = 1
    private lateinit var questions : MutableList<Question>
    private var selectedOptionPosition = 0
    private lateinit var tvProgress : TextView
    private lateinit var progressBar : ProgressBar
    private lateinit var  imageView : ImageView
    private lateinit var  tvQuestion: TextView

    private lateinit var firstOption : TextView
    private lateinit var secondOption : TextView
    private lateinit var thirdOption : TextView
    private lateinit var fourthOption : TextView

    private lateinit var btnSubmit : Button

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
        btnSubmit = bindingQuiz.btnSubmit

        firstOption.setOnClickListener(this)
        secondOption.setOnClickListener(this)
        thirdOption.setOnClickListener(this)
        fourthOption.setOnClickListener(this)

        btnSubmit.setOnClickListener(this)
        questions = Constants.getQuestions()

        setQuestion()
    }

    private fun setQuestion() {
        defaultOptionsView()
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

    private fun defaultOptionsView(){
        val options = mutableListOf<TextView>()
        options.add(firstOption)
        options.add(secondOption)
        options.add(thirdOption)
        options.add(fourthOption)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.option_background)
        }
    }
    private fun selectedOptionView(tv : TextView, selectedOptNum: Int){
        defaultOptionsView()
        selectedOptionPosition = selectedOptNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_borderr_bg)
    }



    override fun onClick(view: View?) {
        when(view?.id){
            firstOption.id -> selectedOptionView(firstOption,1)
            secondOption.id -> selectedOptionView(secondOption,2)
            thirdOption.id -> selectedOptionView(thirdOption,3)
            fourthOption.id -> selectedOptionView(fourthOption,4)
            btnSubmit.id -> {
                if (selectedOptionPosition == 0){
                    selectedOptionPosition++
                    when{
                        currentPosition <= questions.size -> setQuestion()
                        else -> {

                        }
                    }
                } else {
                    val question = questions[currentPosition-1]
                    if(question.correctAnswer != selectedOptionPosition){
                        answerView(selectedOptionPosition,R.drawable.wrong_option_background)
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_background)
                    if(currentPosition == questions.size){
                        btnSubmit.text = "FINISH"
                    }else{
                        btnSubmit.text = "GO TO THE NEXT QUESTION"
                    }
                    selectedOptionPosition = 0
                    currentPosition++
                }
            }
        }
    }
    private fun answerView(answer : Int, drawableView : Int){
        when(answer){
            1 -> firstOption.background = ContextCompat.getDrawable(this,drawableView)
            2 -> secondOption.background = ContextCompat.getDrawable(this,drawableView)
            3 -> thirdOption.background = ContextCompat.getDrawable(this,drawableView)
            4 -> fourthOption.background = ContextCompat.getDrawable(this,drawableView)
        }
    }
}
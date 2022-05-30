package com.csibtn.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.csibtn.quizapp.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    lateinit var binder : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binder = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binder.root)

        val startButton = binder.btnStart

        startButton.setOnClickListener{
            val name = binder.etName.text.toString()
            if(name.isNotEmpty()){
                  Intent(this,QuizQuestionsActivity::class.java).also {
                    startActivity(it)
                }

            }
        }
    }
}
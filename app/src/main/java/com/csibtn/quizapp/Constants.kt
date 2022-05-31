package com.csibtn.quizapp

object Constants {

    fun getQuestions():MutableList<Question>{
        val questionsList = mutableListOf<Question>()
        val question1 = Question(
            1,
            "Which country is represented by this flag?",
             R.drawable.flag_of_north_macedonia,
             "Macedonia",
            "Great Britain",
            "Australia",
            "Ukraine",
            1
        )
        val question2 = Question(
            2,
            "Which continent is the driest?",
            R.drawable.driest,
            "Antarctica",
            "Australia",
            "Eurasia",
            "South America",
            1
        )
        val question3 = Question(
            3,
            "What is the most deadly animal on Earth?",
            R.drawable.deadly,
            "White Shark",
            "Black Mamba",
            "Golden Tree Frog",
            "Black Scorpion",
            3
        )
        val question4 = Question(
            4,
            "What is the fastest animal on Earth?",
            R.drawable.fastest,
            "Lion",
            "Horse",
            "Bold Eagle",
            "Cheetah",
            4
        )
        val question5 = Question(
            5,
            "What is the biggest animal in the world?",
            R.drawable.biggest,
            "Antarctic blue whale",
            "Narwhal",
            "African Elephant",
            "Rhino",
            1
        )
        val question6 = Question(
            6,
            "What is the most dangerous liquid in the world?",
            R.drawable.liquids,
            "Ricin",
            "Botulinum toxin",
            "Batrachotoxin",
            "Maitotoxin",
            2
        )
        val question7 = Question(
            7,
            "What is the closest galaxy to the Milky Way?",
            R.drawable.galaxies,
            "Draco II",
            "Canis Major Dwarf",
            "Andromeda",
            "Tucana III",
            3
        )
        val question8 = Question(
            8,
            "What is the highest building in the world?",
            R.drawable.scyscrapers,
            "Merdeka 118",
            "Lotte World Tower",
            "Shanghai Tower",
            "Burj Khalifa",
            4
        )
        questionsList.add(question1)
        questionsList.add(question2)
        questionsList.add(question3)
        questionsList.add(question4)
        questionsList.add(question5)
        questionsList.add(question6)
        questionsList.add(question7)
        questionsList.add(question8)

        return questionsList
    }
}
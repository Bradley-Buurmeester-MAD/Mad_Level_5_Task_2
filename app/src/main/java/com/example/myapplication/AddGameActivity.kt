package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.Game
import com.example.myapplication.ui.GameViewModel
import kotlinx.android.synthetic.main.activity_add_game.*
import java.util.*
import kotlin.math.log

class AddGameActivity : AppCompatActivity() {
    private val viewModel: GameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_game)

        initViews()
    }

    private fun initViews(){
        SaveGameButton.setOnClickListener {
            onSaveGame()
        }
    }

    private fun onSaveGame() {
        val gameTitle = etTitle.text.toString()
        val gamePlatform = etPlatform.text.toString()
        val gameDay = etDay.text.toString().toInt()
        val gameMonth = etMonth.text.toString().toInt()
        val gameYear = etYear.text.toString().toInt()

        val date = Date(gameYear, gameMonth, gameDay)
        val game = Game(gameTitle, gamePlatform, date)

        viewModel.insertGame(game)

        finish()
    }

}
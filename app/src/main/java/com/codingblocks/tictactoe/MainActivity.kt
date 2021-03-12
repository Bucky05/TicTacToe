package com.codingblocks.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
     var player1 = ""
     var player2 = ""
    var player = true
    var turnCount = 0
    var boardStatus = Array(3){IntArray(3)}
    lateinit var board : Array<Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

player1 = intent.getStringExtra(pl1).toString()
        player2 = intent.getStringExtra(pl2).toString()

        board = arrayOf(
            arrayOf(btn00,btn01,btn02),
            arrayOf(btn10,btn11,btn12),
            arrayOf(btn20,btn21,btn22)
        )

        reset.setOnClickListener {

            turnCount=0
            player=true
            initializeBoard()
        }

        for(i:Array<Button> in board)
        {
            for(button:Button in i)
            {
                button.setOnClickListener(this) ////??????????????????????????
            }
        }
initializeBoard()





    }
    private fun  initializeBoard()
    {
        for(i in 0..2)
        {
            for(j in 0..2)
            {
                boardStatus[i][j] = -1

            }
        }
        for(i: Array<Button> in board)
        {
            for(button in i)
            {
                button.isEnabled = true
                button.text=""
            }
        }
        updateDisplay("$player1 Start")
    }

    override fun onClick(v: View) {
      when(v.id)
    {
        R.id.btn00->{
        UpdateValue(row = 0, col = 0, player = player)

    }
        R.id.btn01->{
        UpdateValue(row = 0, col = 1, player = player)

    }
        R.id.btn02->{
        UpdateValue(row = 0, col = 2, player = player)
    }
        R.id.btn10->{
        UpdateValue(row = 1, col = 0, player = player)
    }
        R.id.btn11->{
        UpdateValue(row = 1, col = 1, player = player)
    }
        R.id.btn12->{
        UpdateValue(row = 1, col = 2, player = player)
    }
        R.id.btn20->{
        UpdateValue(row = 2, col = 0, player = player)
    }
        R.id.btn21->{
        UpdateValue(row = 2, col = 1, player = player)
    }
        R.id.btn22->{
        UpdateValue(row = 2, col = 2, player = player)
    }}

        turnCount++;
        player  = !player
        if(player)
        {
            updateDisplay("${this.player1}'s Turn")

      }
        else {
            updateDisplay("${this.player2}'s  Turn")
        }
        if(turnCount == 9)
        {
            updateDisplay("Draw")
        }
        checkWinner()
    }
        private fun UpdateValue(row: Int,col:Int,player:Boolean)
        {
            val text:String = if(player) "X" else "O"
            val value:Int= if(player) 1 else 0
            board[row][col].apply{
                isEnabled = false
                setText(text)
            }
            boardStatus[row][col] = value




        }

    private fun checkWinner()
    {
        //Horizontal
        for(i in 0..2)
        {
            if(boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][2] == boardStatus[i][1]){
                if(boardStatus[i][0] == 1)
                {

                   updateDisplay("${this.player1} is Winner")

                 //disable()   break
                }
                else if(boardStatus[i][0] == 0){
                    updateDisplay("${this.player2}' is Winner")
                    //disable()
                    break
                }
            }
        }
        for(i in 0..2)
        {
            if(boardStatus[0][i] == boardStatus[1][i] && boardStatus[2][i] == boardStatus[1][i]){
                if(boardStatus[1][i] == 1)
                {
                    updateDisplay("${this.player1} is Winner")
                   // disable()
                    break
                }
                else if(boardStatus[1][i] == 0){
                    updateDisplay("${this.player2}' is Winner")
                   // disable()
                    break
                }
            }
        }

        if(boardStatus[0][0] == boardStatus[1][1] && boardStatus[2][2] == boardStatus[1][1])
        {
            if(boardStatus[1][1] == 1)
            {
                updateDisplay("${this.player1} is Winner")
                // disable()

            }
            else if(boardStatus[1][1] == 0){
                updateDisplay("${this.player2} is Winner")
                // disable()

            }
        }
        if(boardStatus[0][2] == boardStatus[1][1] && boardStatus[2][0] == boardStatus[1][1])
        {
            if(boardStatus[1][1] == 1)
            {
                updateDisplay("${this.player1} is Winner")
                // disable()
             
            }
            else if(boardStatus[1][1] == 0){
                updateDisplay("${this.player2} is Winner")
                // disable()

            }
        }
    }

    private fun disable()
    {
        for(i in 0..2)
        {
            for(j in 0..2)
            {
                board[i][j].isEnabled=false
            }
        }
    }
    private fun updateDisplay(textw:String)
    {
        displayTv.text= textw
        if(textw.contains("Winner"))
        {
            disable()
        }
    }}


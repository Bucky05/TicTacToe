package com.codingblocks.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*
const val pl1 ="Player1"
const val pl2 ="Player 2"

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn.setOnClickListener{
            val i = Intent(this,MainActivity::class.java)
           var  p1 = e1.text.toString()
           var p2 = e2.text.toString()
            i.putExtra(pl1,p1)
            i.putExtra(pl2,p2)
            startActivity(i)
            finish()

        }

    }


}
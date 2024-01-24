package com.example.android_assignment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var userInput : EditText
    lateinit var passInput : EditText
    lateinit var button : Button
    lateinit var progressBar : ProgressBar

    override fun onResume() {
        super.onResume()
        userInput.setVisibility(View.VISIBLE)
        passInput.setVisibility(View.VISIBLE)
        progressBar.setVisibility(View.GONE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userInput = findViewById(R.id.userInput)
        passInput = findViewById(R.id.passInput)
        button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)

        button.setOnClickListener(){
            Log.e("APPLOG","Hello")
            userInput.setVisibility(View.GONE)
            passInput.setVisibility(View.GONE)
            progressBar.setVisibility(View.VISIBLE)

            val username = userInput.text.toString()
            val password = passInput.text.toString()

            Log.e("APPLOG",username + " " + password)


            val handler = Handler()
            handler.postDelayed(Runnable{
//                userInput.setVisibility(View.VISIBLE)
//                passInput.setVisibility(View.VISIBLE)
//                progressBar.setVisibility(View.GONE)
                if(username=="bob" && password=="1234"){
                    //SUCCESS
                    val intent = Intent(applicationContext, SuccessActivity::class.java)
                    intent.putExtra("username", username)
                    startActivity(intent)
                }else{
                    //FAILURE
                    val intent = Intent(applicationContext, FailureActivity::class.java)
                    startActivity(intent)
                }
            }, 3000)
        }

    }




}
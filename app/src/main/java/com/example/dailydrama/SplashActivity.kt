package com.example.dailydrama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

      supportActionBar!!.hide()

        var handler= Handler()
        handler.postDelayed({

          var intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },6000)
    }
}
package com.dimas.wargoose.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.dimas.wargoose.R


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        timer = object : CountDownTimer(2000, 2000) {
            override fun onTick(p0: Long) {

            }
            override fun onFinish() {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            }
        }.start()
    }


    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }
}
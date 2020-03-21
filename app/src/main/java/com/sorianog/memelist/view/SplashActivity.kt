package com.sorianog.memelist.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.sorianog.memelist.R

class SplashActivity : AppCompatActivity() {

    private val handler = Handler()
    private val SPLASHTIMEOUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handler.postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, SPLASHTIMEOUT)
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}

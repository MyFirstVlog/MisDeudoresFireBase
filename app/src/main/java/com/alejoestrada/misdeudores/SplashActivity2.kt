package com.alejoestrada.misdeudores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)


        val timer = Timer()

        //hay que colocar tiempo en el splash
        timer.schedule(
            timerTask {
                goToLoginActivity()

            }, 1000

        )
    }

      fun goToLoginActivity() {
        //intent disparo de actvidades
        val intent = Intent(this, LogInActivity2::class.java)
        //start activity
        startActivity(intent)
         finish()
      }


}
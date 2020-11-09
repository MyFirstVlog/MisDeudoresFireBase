package com.alejoestrada.misdeudores.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alejoestrada.misdeudores.R
import com.alejoestrada.misdeudores.ui.botton.BottonActivity
import com.alejoestrada.misdeudores.ui.login.LogInActivity2
import com.google.firebase.auth.FirebaseAuth
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
                val auth = FirebaseAuth.getInstance()
                if(auth.uid==null){
                    goToLoginActivity()
                }else{
                    goToBottonActivity()
                }

            }, 1000

        )
    }

      fun goToLoginActivity() {
        //intent disparo de actvidades
        val intent = Intent(this, LogInActivity2::class.java)
        //start activity
        startActivity(intent)
         finish() // destruyo parte interior
      }
      fun goToBottonActivity(){
          val intent = Intent(this, BottonActivity::class.java)
          startActivity(intent)
          finish()
      }


}
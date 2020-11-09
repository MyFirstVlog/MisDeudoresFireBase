package com.alejoestrada.misdeudores.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_log_in2.*
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.alejoestrada.misdeudores.R
import com.alejoestrada.misdeudores.ui.botton.BottonActivity
import com.alejoestrada.misdeudores.ui.registro.RegistroActivity
import com.google.firebase.auth.FirebaseAuth

class LogInActivity2 : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val TAG = RegistroActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in2)

        auth =FirebaseAuth.getInstance()

        login_button_log.setOnClickListener{

                val correo = correo_edit_text_log.text.toString()
                val contrasena = contrasena_edit_text_log.text.toString()

                loginWithFirebase(correo, contrasena)

            }


        button_registrar.setOnClickListener {
            val intent=  Intent(this, RegistroActivity::class.java)
            intent.putExtra("numero", 1 )
            startActivity(intent)

        }


    }


    private fun loginWithFirebase(correo:String, contrasena: String){
        auth.createUserWithEmailAndPassword(correo, contrasena)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(RegistroActivity.TAG, "createUserWithEmail:success")
                    val user = auth.currentUser


                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(RegistroActivity.TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }

                // ...
            }
    }

    private fun goToBottonActivity(){
        val intent = Intent(this, BottonActivity::class.java)
        startActivity(intent)
        finish()

    }
}
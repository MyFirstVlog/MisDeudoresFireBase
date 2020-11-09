package com.alejoestrada.misdeudores.ui.registro

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import com.alejoestrada.misdeudores.R
import com.alejoestrada.misdeudores.ui.login.LogInActivity2
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registro.*
import java.util.*

class RegistroActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    companion object {
        private const val EMPTY= ""
        private const val SPACE= " "
        val TAG = RegistroActivity::class.simpleName

    }
    var datedenaissance=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        var datosrecibidos= intent.extras
        val numeroEnviado= datosrecibidos?.getInt("numero")
        Toast.makeText(this, "El numero enviado es $numeroEnviado", Toast.LENGTH_SHORT).show()

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        lafecha_PICKER.setOnClickListener {
            val dpd= DatePickerDialog(this, DatePickerDialog.OnDateSetListener {view: DatePicker, mYear: Int, mMonth: Int, mDay : Int ->
                val monthn= mMonth+1
                datedenaissance =  "" + mDay + "/" + monthn + "/" + mYear

            }, year, month, day)
            dpd.show()


        }

        registrar_button.setOnClickListener {



            val nombre = nombre_edit_view.text.toString()
            val correo= correo_edit_text.text.toString()
            val telefono= telefono_edit_text.text.toString()
            val contrasena= contrasena_edit_text.text.toString()
            val repcontrasena= repetircontra_edit_text.text.toString()
            var genero = if (masculino_radiobutton.isChecked) getString(R.string.masculino) else getString(
                R.string.femenino
            )



            var pasatiempos =
                EMPTY
            if (gym_checkbox.isChecked) pasatiempos += getString(R.string.gym) + SPACE
            if (comer_checkbox.isChecked) pasatiempos += getString(R.string.comer) + SPACE
            if (estudiar_checkbox.isChecked) pasatiempos += getString(R.string.study) + SPACE
            if (series_checkbox.isChecked) pasatiempos += getString(R.string.series)

            val ciudadNacimiento = ciudades_nacimiento.selectedItem

             if ( contrasena == "" && repcontrasena =="" || contrasena != repcontrasena){
            textView3.text = "Contraseñas no coinciden, vuleva a intentar // Passwords don't match, please check "
              }
             else if (contrasena == repcontrasena ) {
                textView3.text = getString(
                    R.string.respuesta,
                    nombre,
                    correo,
                    telefono,
                    genero,
                    pasatiempos,
                    ciudadNacimiento,
                    datedenaissance
                )
              }

            registroEnFirebase(correo, contrasena)

            val intent = Intent(this, LogInActivity2::class.java )
            intent.putExtra("correo",correo)
            intent.putExtra("contraseña",contrasena)
            startActivity(intent)
            finish()


        }
    }

    private fun registroEnFirebase(correo: String, contrasena: String) {

        auth.createUserWithEmailAndPassword(correo, contrasena)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    goToLoginActivity()

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }

                // ...
            }

    }

    private fun goToLoginActivity() {
       onBackPressed()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, LogInActivity2::class.java )
        startActivity(intent)
        finish()
    }

    override fun onResume() {
        super.onResume()
        Log.d("Metodo","onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Metodo","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Metodo","onDestroy")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Metodo","onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Metodo","onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Metodo","onRestart")
    }


}
package com.alejoestrada.misdeudores

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_registro.*
import java.util.*

class RegistroActivity : AppCompatActivity() {


    companion object {
        private const val EMPTY= ""
        private const val SPACE= " "

    }
    var datedenaissance=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
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
            var genero = if (masculino_radiobutton.isChecked) getString(R.string.masculino) else getString(R.string.femenino)

            var pasatiempos = EMPTY
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


        }
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
package com.alejoestrada.misdeudores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_log_in2.*
import kotlinx.android.synthetic.main.activity_registro.*
import android.content.Intent
class LogInActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in2)

        button_registrar.setOnClickListener {
            val intent=  Intent(this, RegistroActivity::class.java)
            intent.putExtra("numero", 1 )
            startActivity(intent)
            finish()
        }
    }
}
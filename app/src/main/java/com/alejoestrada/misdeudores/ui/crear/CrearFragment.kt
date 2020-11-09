package com.alejoestrada.misdeudores.ui.crear

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alejoestrada.misdeudores.MisDeudores
import com.alejoestrada.misdeudores.R
import com.alejoestrada.misdeudores.data.database.dao.DeudorDAO
import com.alejoestrada.misdeudores.data.database.entities.Deudor
import com.alejoestrada.misdeudores.databinding.FragmentCrearBinding
import kotlinx.android.synthetic.main.fragment_crear.*
import java.sql.Types.NULL


class CrearFragment : Fragment() {
    private lateinit var binding: FragmentCrearBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crear, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentCrearBinding.bind(view)

        binding.guardarButton.setOnClickListener{
            val nombre= binding.nombreEditText.text.toString()
            val telefono= binding.telefonoEditText.text.toString()
            val valor= binding.valorEditText.text.toString().toLong()

            val deudor = Deudor(NULL, nombre,telefono, valor)  //el nulo es del id

            val deudorDAO: DeudorDAO= MisDeudores.database.DeudorDAO()

            deudorDAO.insertDeudor(deudor)

        }


       /* guardar_button.setOnClickListener{
           /* val nombre = nombre_edit_text.text.toString()
            val telefono = telefono_edit_text.text.toString()
            val valor= valor_edit_text.text.toString().toLong()
            */
            //instanciamos objeto
           // val deudor=Deudor(nombre,telefono,valor)
           // Log.d("nombre", deudor.nombre)
           /*
            si variable es null, debo hacer
            deudor2.telefono?.Let {telefono ->
                Log.d("valor",telefono)
            }*/
        }*/
    }

    companion object {

    }
}
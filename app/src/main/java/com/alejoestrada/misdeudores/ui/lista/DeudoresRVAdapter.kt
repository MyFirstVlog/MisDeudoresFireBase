package com.alejoestrada.misdeudores.ui.lista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alejoestrada.misdeudores.R
import com.alejoestrada.misdeudores.data.database.entities.Deudor
import com.alejoestrada.misdeudores.databinding.DeudoresItemBinding

class DeudoresRVAdapter(var deudoresList: ArrayList<Deudor>) :
    RecyclerView.Adapter<DeudoresRVAdapter.DeudoresViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeudoresViewHolder {
        // se creera el item view y se enviara all view holder

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.deudores_item, parent, false)
        return DeudoresViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DeudoresViewHolder, position: Int) {
        val deudor= deudoresList[position]
        holder.bindDeudor(deudor)
    }

    override fun getItemCount(): Int {
        return deudoresList.size
    }

    class DeudoresViewHolder(itemView : View) : RecyclerView.ViewHolder (itemView){

        private val binding = DeudoresItemBinding.bind(itemView)

        fun bindDeudor(deudor: Deudor){
            binding.nombreTextView.text = deudor.nombre
            binding.valorTextView.text= deudor.valor.toString()
        }
    }


}
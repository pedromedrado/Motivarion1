package com.example.motivation1.view.viewholder

import android.content.DialogInterface
import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.motivation1.R
import com.example.motivation1.databinding.RowGuestBinding
import com.example.motivation1.model.GuestModel
import com.example.motivation1.view.listener.OnGuestListener

class GuestViewHolder(private val binding: RowGuestBinding, private val listener: OnGuestListener) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(guest: GuestModel) {
        binding.txtName.text = guest.name
        binding.txtName.setOnClickListener {
            listener.onClick(guest.id)
        }
        binding.txtName.setOnLongClickListener {

            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção de Convidado")
                .setMessage("Tem certeza que deseja remover convidado? ")
                .setPositiveButton("SIM", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        listener.onDelete(guest.id)

                    }

                })
                .setNegativeButton("NÃO", null)

                .create()
                .show()

                 true

        }
    }

}
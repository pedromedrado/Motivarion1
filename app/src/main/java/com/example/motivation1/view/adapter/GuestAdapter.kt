package com.example.motivation1.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.recyclerview.widget.RecyclerView.inflate
import com.example.motivation1.databinding.RowGuestBinding
import com.example.motivation1.model.GuestModel
import com.example.motivation1.view.listener.OnGuestListener
import com.example.motivation1.view.viewholder.GuestViewHolder

class GuestAdapter : RecyclerView.Adapter<GuestViewHolder>() {

    private  var guestList : List<GuestModel> = listOf()
    private lateinit var listener : OnGuestListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {

       val item = RowGuestBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  GuestViewHolder(item,listener)

    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {

        holder.bind(guestList[position])
    }

    override fun getItemCount(): Int {

      return guestList.count()
    }

    fun updateGuests(list : List<GuestModel>) {
        guestList = list
        notifyDataSetChanged()
    }
    fun attachListener(guestListener: OnGuestListener) {
        listener = guestListener
    }
}
package com.example.motivation1.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.motivation1.constants.DataBaseConstants
import com.example.motivation1.databinding.FragmentAbsentBinding
import com.example.motivation1.view.adapter.GuestAdapter
import com.example.motivation1.view.listener.OnGuestListener
import com.example.motivation1.viewmodel.GuestViewModel


class AbsentFragment : Fragment() {

    private var _binding: FragmentAbsentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: GuestViewModel
    private val adapter = GuestAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {

        viewModel = ViewModelProvider(this).get(GuestViewModel::class.java)
        _binding = FragmentAbsentBinding.inflate(inflater,container,false)

        binding.recyclerAbsents.layoutManager = LinearLayoutManager(context)
        //adpater
        binding.recyclerAbsents.adapter = adapter


        val listener = object : OnGuestListener {

            override fun onClick(id: Int) {
                val intent = Intent(context, GuestFormActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(DataBaseConstants.GUEST.ID, id)
                intent.putExtras(bundle)

                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                viewModel.delete(id)
                viewModel.getAbsent()
            }

        }
        adapter.attachListener(listener)



        observe()

        return binding.root
    }


    override fun onResume() {
        super.onResume()
        viewModel.getAbsent()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe() {
        viewModel.guest.observe(viewLifecycleOwner) {
            adapter.updateGuests(it)
        }
    }
}
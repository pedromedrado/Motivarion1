package com.example.motivation1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.motivation1.model.GuestModel
import com.example.motivation1.R
import com.example.motivation1.constants.DataBaseConstants
import com.example.motivation1.databinding.ActivityGuestFormBinding
import com.example.motivation1.viewmodel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewModel

    private var guestId = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        binding.radioPresent.isChecked = true
        binding.buttonSave.setOnClickListener(this)

        observe()

        loadData()
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.button_save) {

            val name = binding.editName.text.toString()
            val presencepresent = binding.radioPresent.isChecked

            val model = GuestModel(guestId, name, presencepresent)

            viewModel.save(model)
            finish()

        }
    }



    private fun observe() {
        viewModel.guest.observe(this, Observer {
            binding.editName.setText(it.name)
            if (it.presence) {
                binding.radioPresent.isChecked = true
            } else {
                binding.radioAbsents.isChecked = true
            }
        })

        viewModel.saveGuest.observe(this, Observer {


            if (it.sucess) {
                Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT)
                    .show()
                finish()
            }
        })

    }

    private fun loadData() {
        val bundle = intent.extras
        if (bundle != null) {
            guestId = bundle.getInt(DataBaseConstants.GUEST.ID)
            viewModel.get(guestId)
        }

    }


}
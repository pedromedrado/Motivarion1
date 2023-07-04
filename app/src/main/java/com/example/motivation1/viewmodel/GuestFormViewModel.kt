package com.example.motivation1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.motivation1.constants.DataBaseConstants
import com.example.motivation1.model.GuestModel
import com.example.motivation1.model.SucessFailure
import com.example.motivation1.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    private val guestModel = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = guestModel

    private val _saveGuest = MutableLiveData<SucessFailure>()
    val saveGuest: LiveData<SucessFailure> = _saveGuest


    fun save(guest: GuestModel) {
        val sucessFailure = SucessFailure(true,"")


        if (guest.id == 0) {
            sucessFailure.sucess = repository.insert(guest)
        }else{

            sucessFailure.sucess = repository.update(guest)
        }
    }




fun get(id: Int) {
    guestModel.value = repository.get(id)
}
}
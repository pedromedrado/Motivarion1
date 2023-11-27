package com.example.motivation1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData
import com.example.motivation1.model.GuestModel
import com.example.motivation1.repository.GuestRepository

class GuestViewModel(application: Application) : AndroidViewModel(application) {
    private  val repository = GuestRepository.getInstance(application.applicationContext)

    private val listAllGuests = MutableLiveData<List<GuestModel>>()
    val guest: LiveData<List<GuestModel>> = listAllGuests

    fun getAll() {
        listAllGuests.value = repository.getAll()
    }

    fun getAbsent() {
        listAllGuests.value = repository.getAbsent()
    }
    fun getPresent() {
        listAllGuests.value = repository.getPresent()
    }


    fun delete(id: Int) {
    repository.delete(id)
    }
}
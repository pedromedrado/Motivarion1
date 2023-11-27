package com.example.motivation1.repository


import android.content.Context

import com.example.motivation1.model.GuestModel

class GuestRepository(context: Context) {
// Acessando a camada DAO
    private val guestDataBase = GuestDatabase.getDatabase(context).guestDAO()

  companion object {

        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if (!Companion::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }

    }

    fun insert(guest: GuestModel): Boolean {
        return guestDataBase.insert(guest) > 0
    }

    fun update(guest: GuestModel): Boolean {
        return guestDataBase.update(guest) > 0
    }

    fun delete(id: Int) {
        val guest = get(id)
        guestDataBase.delete(guest)
    }

    fun get(id: Int): GuestModel {
        return guestDataBase.get(id)
    }

    fun getAll(): List<GuestModel> {

        return guestDataBase.getAll()
    }

    fun getPresent(): List<GuestModel> {

        return guestDataBase.getPresent()
    }

    fun getAbsent(): List<GuestModel> {

        return guestDataBase.getAbsent()
    }

}
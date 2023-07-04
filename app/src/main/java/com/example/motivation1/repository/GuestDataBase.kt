package com.example.motivation1.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.motivation1.constants.DataBaseConstants

class GuestDataBase(context: Context) : SQLiteOpenHelper(context, NAME,null, VERSION) {

    companion object {
        private  const val  NAME = "gustdb"
        private  const val  VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        
        db.execSQL("create table "+  DataBaseConstants.GUEST.TABLE_NAME+"(" +

                DataBaseConstants.GUEST.COLUMNS.ID+"id integer primary key autoincrement,"+
                DataBaseConstants.GUEST.COLUMNS.NAME + " text," +
                DataBaseConstants.GUEST.COLUMNS.PRESENCE +  "presence integer);")
        
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        
        
    }


}


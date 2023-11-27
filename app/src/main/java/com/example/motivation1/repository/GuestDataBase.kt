package com.example.motivation1.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.motivation1.constants.DataBaseConstants
import com.example.motivation1.model.GuestModel

//class GuestDataBase(context: Context) : SQLiteOpenHelper(context, NAME,null, VERSION) {

// criando banco com ROOM/ inicializacao

@Database(entities = [GuestModel::class], version = 1)

abstract class GuestDatabase : RoomDatabase() {

    abstract fun guestDAO(): GuestDAO

    companion object {
        private lateinit var INSTANCE: GuestDatabase

        fun getDatabase(context: Context): GuestDatabase {
            if (!::INSTANCE.isInitialized) {
                synchronized(GuestDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context, GuestDatabase::class.java, "guestDB")
                        .addMigrations(MIGRATION_1_2)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        /**
         * Atualização de versão de banco de dados
         */
        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("DELETE FROM Guest")
            }
        }

    }
}


//    companion object {
//        private  const val  NAME = "guestDB"
//        private  const val  VERSION = 1
//    }
//
//    override fun onCreate(db: SQLiteDatabase) {
//
//        db.execSQL("create table "+  DataBaseConstants.GUEST.TABLE_NAME+"(" +
//
//                DataBaseConstants.GUEST.COLUMNS.ID+" integer primary key autoincrement,"+
//                DataBaseConstants.GUEST.COLUMNS.NAME + " text," +
//                DataBaseConstants.GUEST.COLUMNS.PRESENCE + " integer);")
//
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//
//
//    }





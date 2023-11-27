package com.example.motivation1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Guest")
 class GuestModel{
//auto generate incremente a chave primaria de auto incremente
 @PrimaryKey(autoGenerate = true)
 //Criacao das colunas com @ColumInfo
 @ColumnInfo(name = "id")
 var id : Int = 0

 @ColumnInfo(name = "name")
 var name:String = ""

 @ColumnInfo(name = "presence")
 var presence : Boolean  = false


}
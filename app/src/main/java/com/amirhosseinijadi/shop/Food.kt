package com.amirhosseinijadi.shop

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_food")
data class Food (
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    val txtsubject:String,
    val txtprice:String,
    val txtdistance:String,
    val txtcity:String,
    val urlimage:String,
    val numofrating:Int,
    val rating:Float


        )

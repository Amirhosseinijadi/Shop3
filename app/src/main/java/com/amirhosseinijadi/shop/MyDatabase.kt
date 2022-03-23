package com.amirhosseinijadi.shop

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(version = 1 , exportSchema = false,entities = [Food::class ])
abstract class MyDatabase:RoomDatabase() {
    abstract val fooddao:FoodDao
companion object{

    private var database:MyDatabase? = null

    fun getdatabase(context:Context):MyDatabase{



        if(database == null){
            database = Room.databaseBuilder(
                context.applicationContext,
                MyDatabase::class.java,
                "myDatabase.db"
            ).allowMainThreadQueries()
                .build()
        }

        return database!!
    }

}



}
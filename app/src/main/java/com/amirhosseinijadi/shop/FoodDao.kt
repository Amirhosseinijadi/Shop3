package com.amirhosseinijadi.shop

import androidx.room.*

@Dao
interface FoodDao {
    @Insert
    fun insert(food : Food)

    @Insert
    fun insertallfood(data:List<Food>)




    @Update
    fun update(food:Food)


    @Delete
    fun delete(food:Food)


    @Query("DELETE FROM table_food")
    fun deleteallfood()




    @Query("SELECT * FROM table_food")
    fun getallfood():List<Food>

    @Query("SELECT * FROM table_food WHERE txtsubject LIKE '%' || :searching ||'%'")
    fun searchfoods(searching:String):List<Food>
}
package com.amirhosseinijadi.shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amirhosseinijadi.shop.databinding.ActivityMainBinding
import com.amirhosseinijadi.shop.databinding.AddItemBinding
import com.amirhosseinijadi.shop.databinding.RemoveItemBinding
import com.amirhosseinijadi.shop.databinding.UpdateItemBinding

class MainActivity : AppCompatActivity(),FoodAdapter.Foodevents {
    lateinit var binding:ActivityMainBinding
    lateinit var myadapter:FoodAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodlist = arrayListOf<Food>(
            Food("Hamburger","15","3","yazd","https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food1.jpg",60,3.5f),
            Food("grilled fish","20","2","tehran","https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food2.jpg",60,4.5f),
            Food("lasania","13","7","paris","https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food3.jpg",60,3f),
            Food("Pizza","17","1.2","isfahan","https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food4.jpg",60,5f),
            Food("sushi","23","2.5","london","https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food5.jpg",60,2.5f),
            Food("roasted fish","18","6","shiraz","https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food6.jpg",60,3.5f),
            Food("fried chicken","8","7","mashhad","https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food7.jpg",60,4f),
            Food("vegetable salad","7","3","bandar abbas","https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food8.jpg",60,3.5f),
            Food("grilled chicken","9","4","istanbul","https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food9.jpg",60,2f),
            Food("beryooni","8","5","gheshm","https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food10.jpg",60,1.5f),
            Food("ghorme sabzi","8","2","stockolm","https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food11.jpg",60,2f),
            Food("Rice","4","4","tabriz","https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food12.jpg",60,3f))

         myadapter = FoodAdapter(foodlist.clone()as ArrayList<Food>,this,this)

        binding.recyclermain.adapter = myadapter
        binding.recyclermain.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        binding.btnAdd.setOnClickListener {
            val dialog = AlertDialog.Builder(this).create()
            val dialogbinding = AddItemBinding.inflate(layoutInflater)
            dialog.setView(dialogbinding.root)
            dialog.setCanceledOnTouchOutside(true)
            dialog.show()

            dialogbinding.btnDone.setOnClickListener {
                if(dialogbinding.foodname.length() > 0
                    && dialogbinding.cityname.length() > 0
                    && dialogbinding.distance.length() > 0
                    && dialogbinding.price.length() > 0
                        ){

                    val imgmain = dialogbinding.foodname.text.toString()
                    val city = dialogbinding.cityname.text.toString()
                    val distance = dialogbinding.distance.text.toString()
                    val price = dialogbinding.price.text .toString()
                    val random:Int = (1 until 12).random()
                    val urlrandom = foodlist[random].urlimage
                    val rating = (1..150).random()
                    val ratingbar:Float = (1..5).random().toFloat()

                    val newfood = Food(imgmain,price,distance,city,urlrandom,rating,ratingbar)

                    myadapter.addnewfood(newfood)

                    binding.recyclermain.scrollToPosition(0)



                    dialog.dismiss()

                }else{
                    Toast.makeText(this, "please fill all boxes!", Toast.LENGTH_SHORT).show()
                }
            }

        }

        binding.edtsearch.addTextChangedListener { edittextinput ->
          if(edittextinput!!.isNotEmpty())  {
              val clonelist = foodlist.clone() as ArrayList<Food>
              val filteredlist = clonelist.filter { it ->
                  it.txtsubject.contains(edittextinput)

              }
              myadapter.setdata(ArrayList(filteredlist))

          }else{
              myadapter.setdata(foodlist.clone() as ArrayList<Food>)
          }

        }







    }

    override fun onfoodclicked(food: Food, position: Int) {

        val dialogupdate = AlertDialog.Builder(this).create()
        val viewupdate = UpdateItemBinding.inflate(layoutInflater)
        dialogupdate.setView(viewupdate.root)
        dialogupdate.setCanceledOnTouchOutside(true)
        dialogupdate.show()

        viewupdate.foodname.setText(food.txtsubject)
        viewupdate.cityname.setText(food.txtcity)
        viewupdate.price.setText(food.txtprice)
        viewupdate.distance.setText(food.txtdistance)



        viewupdate.btnCancleupdate.setOnClickListener {
            dialogupdate.dismiss()
        }
        viewupdate.btnDone.setOnClickListener {
            val imgmain = viewupdate.foodname.text.toString()
            val city = viewupdate.cityname.text.toString()
            val distance = viewupdate.distance.text.toString()
            val price = viewupdate.price.text .toString()
            val newfood = Food(imgmain,price,distance,city,food.urlimage,food.numofrating,food.rating)

            dialogupdate.dismiss()

            myadapter.updatefood(newfood,position)


        }

    }


    override fun onfoodlongclicked(food: Food, pos: Int) {
        val dialogremove = AlertDialog.Builder(this).create()

        val viewremove = RemoveItemBinding.inflate(layoutInflater)
        dialogremove.setView(viewremove.root)
        dialogremove.setCanceledOnTouchOutside(true)
        dialogremove.show()

        viewremove.btnCancle.setOnClickListener {
            dialogremove.dismiss()
        }
        viewremove.btnSure.setOnClickListener {

            dialogremove.dismiss()

            myadapter.removefood(food,pos)

        }

    }



}





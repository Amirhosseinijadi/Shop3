package com.amirhosseinijadi.shop

import android.content.Context
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
const val BASE_URL_IMG = "https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food"
class MainActivity : AppCompatActivity(),FoodAdapter.Foodevents {
    lateinit var binding:ActivityMainBinding
    lateinit var myadapter:FoodAdapter
    lateinit var fooddao:FoodDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fooddao = MyDatabase.getdatabase(this).fooddao

        val sharedperefences = getSharedPreferences("dunifood", Context.MODE_PRIVATE)
         if (sharedperefences.getBoolean("first_run",true)) {
             firstrun()

             sharedperefences.edit().putBoolean("first_run",false).apply()
         }

        showalldata()

        binding.btnAdd.setOnClickListener {
            addnewfood()
        }
    }

    private fun firstrun() {
        val listfood = listOf<Food>(
            Food(txtsubject = "Hamburger",txtprice = "15",txtdistance = "3",txtcity = "yazd",urlimage = "https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food1.jpg",numofrating = 60,rating = 3.5f),
            Food(txtsubject ="grilled fish",txtprice = "20",txtdistance = "2",txtcity ="tehran",urlimage ="https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food2.jpg",numofrating = 60,rating =4.5f),
            Food(txtsubject ="lasania",txtprice = "13",txtdistance = "7",txtcity ="paris",urlimage ="https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food3.jpg",numofrating = 60,rating =3f),
            Food(txtsubject ="Pizza",txtprice = "17",txtdistance = "1.2",txtcity ="isfahan",urlimage ="https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food4.jpg",numofrating = 60,rating =5f),
            Food(txtsubject ="sushi",txtprice = "23",txtdistance = "2.5",txtcity ="london",urlimage ="https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food5.jpg",numofrating = 60,rating =2.5f),
            Food(txtsubject ="roasted fish",txtprice = "18",txtdistance = "6",txtcity ="shiraz",urlimage ="https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food6.jpg",numofrating = 60,rating =3.5f),
            Food(txtsubject ="fried chicken",txtprice = "8",txtdistance = "7",txtcity ="mashhad",urlimage ="https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food7.jpg",numofrating = 60,rating =4f),
            Food(txtsubject ="vegetable salad",txtprice = "7",txtdistance = "3",txtcity ="bandar abbas",urlimage ="https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food8.jpg",numofrating = 60,rating =3.5f),
            Food(txtsubject ="grilled chicken",txtprice = "9",txtdistance = "4",txtcity ="istanbul",urlimage ="https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food9.jpg",numofrating = 60,rating =2f),
            Food(txtsubject ="beryooni",txtprice = "8",txtdistance = "5",txtcity ="gheshm",urlimage ="https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food10.jpg",numofrating = 60,rating =1.5f),
            Food(txtsubject ="ghorme sabzi",txtprice = "8",txtdistance = "2",txtcity ="stockolm",urlimage ="https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food11.jpg",numofrating = 60,rating =2f),
            Food(txtsubject ="Rice",txtprice = "4",txtdistance = "4",txtcity ="tabriz",urlimage ="https://dunijet.ir/YaghootAndroidFiles/DuniFoodSimple/food12.jpg",numofrating = 60,rating =3f))

        fooddao.insertallfood(listfood)
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
            val newfood = Food(txtsubject = imgmain,txtprice = price,txtdistance = distance,txtcity = city,urlimage = food.urlimage,numofrating = food.numofrating,rating = food.rating)

            dialogupdate.dismiss()

            myadapter.updatefood(newfood,position)

            fooddao.update(newfood)


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

            fooddao.delete(food)

            myadapter.removefood(food,pos)

        }



    }








    private fun showalldata(){
       val foodlist =  fooddao.getallfood()
        myadapter = FoodAdapter(ArrayList(foodlist),this,this)

       binding.recyclermain.adapter = myadapter
       binding.recyclermain.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

    }
    private fun addnewfood(){
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
                    val urlrandom = BASE_URL_IMG + random +".jpg"
                    val rating = (1..150).random()
                    val ratingbar:Float = (1..5).random().toFloat()

                    val newfood = Food(txtsubject = imgmain,txtprice = price,txtdistance = distance,txtcity = city,urlimage = urlrandom,numofrating = rating,rating = ratingbar)

                    myadapter.addnewfood(newfood)
                    fooddao.insert(newfood)

                    binding.recyclermain.scrollToPosition(0)



                    dialog.dismiss()

                }else{
                    Toast.makeText(this, "please fill all boxes!", Toast.LENGTH_SHORT).show()
                }
            }


    }
}















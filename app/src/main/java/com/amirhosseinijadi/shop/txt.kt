package com.amirhosseinijadi.shop

//        val foodlist = arrayListOf<Food>(
//

//
//      {
//
//                    val imgmain = dialogbinding.foodname.text.toString()
//                    val city = dialogbinding.cityname.text.toString()
//                    val distance = dialogbinding.distance.text.toString()
//                    val price = dialogbinding.price.text .toString()
//                    val random:Int = (1 until 12).random()
//                    val urlrandom = foodlist[random].urlimage
//                    val rating = (1..150).random()
//                    val ratingbar:Float = (1..5).random().toFloat()
//
//                    val newfood = Food(imgmain,price,distance,city,urlrandom,rating,ratingbar)
//
//                    myadapter.addnewfood(newfood)
//
//                    binding.recyclermain.scrollToPosition(0)
//
//
//
//                    dialog.dismiss()
//
//                }else{
//                    Toast.makeText(this, "please fill all boxes!", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//        }
//
//        binding.edtsearch.addTextChangedListener { edittextinput ->
//          if(edittextinput!!.isNotEmpty())  {
//              val clonelist = foodlist.clone() as ArrayList<Food>
//              val filteredlist = clonelist.filter { it ->
//                  it.txtsubject.contains(edittextinput)
//
//              }
//              myadapter.setdata(ArrayList(filteredlist))
//
//          }else{
//              myadapter.setdata(foodlist.clone() as ArrayList<Food>)
//          }
//
//        }
//
//
//
//
//
//
//
//    }
//
//    override fun onfoodclicked(food: Food, position: Int) {
//



//

//        val foodlist = arrayListOf<Food>(
//

//
//        binding.btnAdd.setOnClickListener {
//            val dialog = AlertDialog.Builder(this).create()
//            val dialogbinding = AddItemBinding.inflate(layoutInflater)
//            dialog.setView(dialogbinding.root)
//            dialog.setCanceledOnTouchOutside(true)
//            dialog.show()
//
//            dialogbinding.btnDone.setOnClickListener {
//                if(dialogbinding.foodname.length() > 0
//                    && dialogbinding.cityname.length() > 0
//                    && dialogbinding.distance.length() > 0
//                    && dialogbinding.price.length() > 0
//                        ){
//
//                    val imgmain = dialogbinding.foodname.text.toString()
//                    val city = dialogbinding.cityname.text.toString()
//                    val distance = dialogbinding.distance.text.toString()
//                    val price = dialogbinding.price.text .toString()
//                    val random:Int = (1 until 12).random()
//                    val urlrandom = foodlist[random].urlimage
//                    val rating = (1..150).random()
//                    val ratingbar:Float = (1..5).random().toFloat()
//
//                    val newfood = Food(imgmain,price,distance,city,urlrandom,rating,ratingbar)
//
//                    myadapter.addnewfood(newfood)
//
//                    binding.recyclermain.scrollToPosition(0)
//
//
//
//                    dialog.dismiss()
//
//                }else{
//                    Toast.makeText(this, "please fill all boxes!", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//        }
//
//        binding.edtsearch.addTextChangedListener { edittextinput ->
//          if(edittextinput!!.isNotEmpty())  {
//              val clonelist = foodlist.clone() as ArrayList<Food>
//              val filteredlist = clonelist.filter { it ->
//                  it.txtsubject.contains(edittextinput)
//
//              }
//              myadapter.setdata(ArrayList(filteredlist))
//
//          }else{
//              myadapter.setdata(foodlist.clone() as ArrayList<Food>)
//          }
//
//        }
//
//
//
//
//
//
//
//    }
//
//    override fun onfoodclicked(food: Food, position: Int) {
//
//        val dialogupdate = AlertDialog.Builder(this).create()
//        val viewupdate = UpdateItemBinding.inflate(layoutInflater)
//        dialogupdate.setView(viewupdate.root)
//        dialogupdate.setCanceledOnTouchOutside(true)
//        dialogupdate.show()
//
//        viewupdate.foodname.setText(food.txtsubject)
//        viewupdate.cityname.setText(food.txtcity)
//        viewupdate.price.setText(food.txtprice)
//        viewupdate.distance.setText(food.txtdistance)
//
//
//
//        viewupdate.btnCancleupdate.setOnClickListener {
//            dialogupdate.dismiss()
//        }
//        viewupdate.btnDone.setOnClickListener {
//            val imgmain = viewupdate.foodname.text.toString()
//            val city = viewupdate.cityname.text.toString()
//            val distance = viewupdate.distance.text.toString()
//            val price = viewupdate.price.text .toString()
//            val newfood = Food(imgmain,price,distance,city,food.urlimage,food.numofrating,food.rating)
//
//            dialogupdate.dismiss()
//
//            myadapter.updatefood(newfood,position)
//
//
//        }
//
//    }
//
//
//    override fun onfoodlongclicked(food: Food, pos: Int) {
//        val dialogremove = AlertDialog.Builder(this).create()
//
//        val viewremove = RemoveItemBinding.inflate(layoutInflater)
//        dialogremove.setView(viewremove.root)
//        dialogremove.setCanceledOnTouchOutside(true)
//        dialogremove.show()
//
//        viewremove.btnCancle.setOnClickListener {
//            dialogremove.dismiss()
//        }
//        viewremove.btnSure.setOnClickListener {
//
//            dialogremove.dismiss()
//
//            myadapter.removefood(food,pos)
//
//        }
//
//    }




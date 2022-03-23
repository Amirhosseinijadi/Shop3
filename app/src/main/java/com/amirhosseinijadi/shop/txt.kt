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





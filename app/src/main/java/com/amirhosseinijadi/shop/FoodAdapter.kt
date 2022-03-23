package com.amirhosseinijadi.shop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FoodAdapter(private val data:ArrayList<Food>,private val contex:Context,private val foodevents: Foodevents):RecyclerView.Adapter<FoodAdapter.Foodviewholder>(){

    inner class Foodviewholder(itemview:View):RecyclerView.ViewHolder(itemview){
        val imgmain = itemview.findViewById<ImageView>(R.id.img_food)
        val txtsubject = itemview.findViewById<TextView>(R.id.txt_main)
        val txtcity = itemview.findViewById<TextView>(R.id.txt_city)
        val txtprice = itemview.findViewById<TextView>(R.id.txt_price)
        val txtdistance = itemview.findViewById<TextView>(R.id.txt_distance)
        val ratingbar = itemview.findViewById<RatingBar>(R.id.ratingBar)
        val numrate = itemview.findViewById<TextView>(R.id.txt_rating)

        fun binddata(position:Int){
            txtsubject.text = data[position].txtsubject
            txtcity.text = data[position].txtcity
            txtprice.text = "$"+ data[position].txtprice + " Vip"
            txtdistance.text = data[position].txtdistance + "miles from you"
            ratingbar.rating = data[position].rating
            numrate.text = "(" + data[position].numofrating.toString() + "Ratings)"


            Glide
                .with(contex)
                .load(data[position].urlimage)
                .into(imgmain)

            itemView.setOnClickListener {
                foodevents.onfoodclicked(data[adapterPosition],adapterPosition)
            }

            itemView.setOnLongClickListener {
                foodevents.onfoodlongclicked(data[adapterPosition],adapterPosition)

                true
            }

        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Foodviewholder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food,parent,false)

        return Foodviewholder(view)



    }

    override fun onBindViewHolder(holder: Foodviewholder, position: Int) {

        holder.binddata(position)

    }

    override fun getItemCount(): Int {


        return data.size

    }
    fun addnewfood(newfood:Food){
        data.add(0,newfood)
        notifyItemInserted(0)
    }

    fun removefood(oldfood:Food,oldposition:Int){
        data.remove(oldfood)
        notifyItemRemoved(oldposition)
    }
    fun setdata(newlist:ArrayList<Food>){
        data.clear()
        data.addAll(newlist)
        notifyDataSetChanged()

    }

    interface Foodevents{
        fun onfoodclicked(food:Food,position:Int)

        fun onfoodlongclicked(food:Food,pos:Int)

    }
    fun updatefood(newfood:Food,position:Int){
        data.set(position,newfood)
        notifyItemChanged(position)

    }


}
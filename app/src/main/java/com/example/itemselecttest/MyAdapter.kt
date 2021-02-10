package com.example.itemselecttest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import kotlinx.android.synthetic.main.viewholder.view.*

class MyAdapter(val context:Context):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var list = listOf<Item>()

    var lastItem :Item? = null

    inner class MyViewholder(itemView:View):RecyclerView.ViewHolder(itemView){
        val tv = itemView.textView
        val imgv = itemView.imageView
        val rootview = itemView.rootview_viewholder


        fun bind(item:Item){
            tv.text = item.name
            Glide.with(context)
                .load(item.photo)
                .transform(CircleCrop())
                .into(imgv)

            if(item.isChecked){
                rootview.isActivated = true
                tv.isActivated = true
            }
            else{
                rootview.isActivated = false
                tv.isActivated = false
            }


            rootview.setOnClickListener {

                //更改所點擊的item樣式
                item.isChecked = true

                //還原上一個點擊的item樣式
                if(lastItem!==null && lastItem!==item){
                    lastItem?.isChecked = false
                }
                lastItem = item
                notifyDataSetChanged()
            }


        }
    }

    override fun getItemCount(): Int  = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layout = inflater.inflate(R.layout.viewholder,parent,false)
        return MyViewholder(layout)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is MyViewholder) holder.bind(list[position])
    }


    fun updateList(list:List<Item>){
        this.list = list
    }
}
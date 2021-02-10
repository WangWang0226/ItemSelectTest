package com.example.itemselecttest

data class Item(
    val name:String,
    val photo:Int,
    var isChecked:Boolean
)

val mList = mutableListOf<Item>()
fun setData(){

    for(i in 0 until 10){
        mList.add(Item("汪汪汪汪汪汪汪",R.drawable.avatar,false))
        mList.add(Item("安安安安安安安",R.drawable.img01,false))
        mList.add(Item("RRRRRRRRRRR",R.drawable.img02,false))
    }
}
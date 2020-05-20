package com.bj.ocean.mygankmeizi.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bj.ocean.mygankmeizi.data.Girl
import com.bj.ocean.mygankmeizi.databinding.ItemContentBinding
import kotlin.random.Random


/**
 * Created by ocean on 2020-05-19
 * @describe:
 */

class MineListAdapter  : ListAdapter<Girl, RecyclerView.ViewHolder>(GirlDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return Holder(ItemContentBinding.inflate( LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as Holder).bind( getItem(position))

    }
    class Holder(private val binging :ItemContentBinding) :
        RecyclerView.ViewHolder(binging.root){
        init {
            binging?.tvContent.setBackgroundColor(Color.argb(getRandomColor(),getRandomColor(),getRandomColor(),getRandomColor()))
        }
        fun bind(g: Girl?) {
           binging.apply {
               girl=g
               executePendingBindings()
           }
        }
        fun getRandomColor():Int{

            val color= (0..255).random()
            return color

        }
    }



}
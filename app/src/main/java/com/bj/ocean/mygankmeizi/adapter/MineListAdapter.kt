package com.bj.ocean.mygankmeizi.adapter

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bj.ocean.mygankmeizi.DetailActivity
import com.bj.ocean.mygankmeizi.data.Girl
import com.bj.ocean.mygankmeizi.databinding.ItemContentBinding


/**
 * Created by ocean on 2020-05-19
 * @describe:
 */

class MineListAdapter : ListAdapter<Girl, RecyclerView.ViewHolder>(GirlDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return Holder(
            ItemContentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as Holder).bind(getItem(position))

    }

    class Holder(private val binding: ItemContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {

            binding.setClickListener {
                binding.girl?.let {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra("girl_id", it.girl_id)
                    itemView.context.startActivity(intent)
                }
            }
            binding?.tvContent.setTextColor(
                Color.rgb(
                    getRandomColor(),
                    getRandomColor(),
                    getRandomColor()
                )
            )

        }

        fun bind(g: Girl?) {
            binding.apply {
                girl = g
                executePendingBindings()
            }
        }

        fun getRandomColor(): Int {

            val color = (0..255).random()
            return color

        }
    }


}
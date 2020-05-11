package com.bj.ocean.mygankmeizi.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bj.ocean.mygankmeizi.DetailActivity
import com.bj.ocean.mygankmeizi.data.Girl
import com.bj.ocean.mygankmeizi.databinding.ItemGirlHomeBinding
import com.google.android.material.snackbar.Snackbar

/**
 * Created by ocean on 2020-05-08
 * @describe:
 */
class GirlAdapter : ListAdapter<Girl, RecyclerView.ViewHolder>(GirlDiffCallBack()) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val girl = getItem(position)

        (holder as GirlViewHolder).bind(girl)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return GirlViewHolder(
            ItemGirlHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    class GirlViewHolder(
        private val binding:
        ItemGirlHomeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener {
                binding.girl?.let {

                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra("girl_id", it.girl_id)
                    itemView.context.startActivity(intent)
                }
            }
        }

        fun bind(item: Girl) {

            binding.apply {
                girl = item
                executePendingBindings()
            }
        }
    }
}

private class GirlDiffCallBack : DiffUtil.ItemCallback<Girl>() {

    override fun areContentsTheSame(oldItem: Girl, newItem: Girl): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: Girl, newItem: Girl): Boolean {
        return oldItem.girl_id == newItem.girl_id
    }
}
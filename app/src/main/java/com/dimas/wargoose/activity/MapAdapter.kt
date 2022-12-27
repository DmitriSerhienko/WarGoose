package com.dimas.wargoose.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dimas.wargoose.R
import com.dimas.wargoose.databinding.MapItemBinding

class MapAdapter: ListAdapter <MapModel, MapAdapter.MapHolder>(Comparator()) {

    class MapHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = MapItemBinding.bind(view)
        fun bind(map: MapModel) = with(binding){
            tvDate.setText(map.time)
            imFire.setImageResource(map.image)
            tvMesto.setText(map.title)
            tvTimes.setText(map.attack)
        }
    }
    class Comparator : DiffUtil.ItemCallback<MapModel>(){
        override fun areItemsTheSame(oldItem: MapModel, newItem: MapModel): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: MapModel, newItem: MapModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.map_item, parent,false)
        return MapHolder(view)
    }

    override fun onBindViewHolder(holder: MapHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
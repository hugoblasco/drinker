package com.example.drinker.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.drinker.databinding.ComponentListGameItemBinding
import com.example.drinker.model.GameDomainModel

class HomeAdapter(private val gameList : List<GameDomainModel>):
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(val binding: ComponentListGameItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GameDomainModel) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        val listItemBinding = ComponentListGameItemBinding.inflate(inflater, parent, false)

        return ViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(gameList[position])
    }

    override fun getItemCount() = gameList.size
}

package com.example.albertsonsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.albertsonsapp.databinding.AcronymItemBinding
import com.example.albertsonsapp.model.Lf

class AcronymAdapter : RecyclerView.Adapter<AcronymAdapter.AcronymViewHolder>() {

    private val meaningList = mutableListOf<Lf>()

    class AcronymViewHolder(
            private var binding: AcronymItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun load(lf: Lf) {
            binding.fullMeaning.text = lf.lf
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            AcronymViewHolder(AcronymItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: AcronymViewHolder, position: Int) =
            holder.load(meaningList[position])

    override fun getItemCount() = meaningList.size

    fun submitList(acronyms: List<Lf>) {
        meaningList.clear()
        meaningList.addAll(acronyms)
        notifyDataSetChanged()
    }
}

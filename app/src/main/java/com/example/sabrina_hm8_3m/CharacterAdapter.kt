package com.example.sabrina_hm8_3m

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sabrina_hm8_3m.databinding.FragmentMainBinding
import com.example.sabrina_hm8_3m.databinding.ItemCharactersBinding

class CharacterAdapter(private val characterList: List<Characters>, val onItemClick:(position:Int) -> Unit): RecyclerView.Adapter<CharacterAdapter.ViewHolder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = characterList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    inner class ViewHolder(private val binding: ItemCharactersBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(characters: Characters){
            binding.apply {
                characters.apply {
                    tvCharactersName.text =name
                    tvIsTheyAlive.text = isHeAlive
                    Glide.with(ivCharactersPicture).load(characters.picture).into(ivCharactersPicture)
                }
            }
            itemView.setOnClickListener{
                onItemClick(adapterPosition)
            }
        }
    }
}
package com.example.sabrina_hm8_3m

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.sabrina_hm8_3m.databinding.FragmentMainBinding
import com.example.sabrina_hm8_3m.databinding.FragmentNextBinding

class NextFragment : Fragment() {

    private lateinit var binding:FragmentNextBinding
    private lateinit var data:Characters
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNextBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data = arguments?.getSerializable("key") as Characters
            binding.apply {
               tvCharacterName.text = data.name
                tvIsHeAlive.text = data.isHeAlive
                Glide.with(ivCharacterPicture).load(data.picture).into(ivCharacterPicture)
            }
    }
}
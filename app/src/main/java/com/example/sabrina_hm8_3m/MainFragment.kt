package com.example.sabrina_hm8_3m

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.sabrina_hm8_3m.databinding.ActivityMainBinding
import com.example.sabrina_hm8_3m.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val characterList = arrayListOf(
        Characters("https://i.pinimg.com/236x/f5/c7/3e/f5c73e1abb81ea3efb42d09d76918184.jpg","Naruto Uzumaki","Alive"),
        Characters("https://static.zerochan.net/Uchiha.Sasuke.full.3260069.png","Sasuke Uchiha","Alive"),
        Characters("https://i.pinimg.com/564x/28/78/f8/2878f85e668293fded6de19c44ad436f.jpg","Sakura Haruno","Alive"),
        Characters("https://i.pinimg.com/originals/cf/c3/5e/cfc35e1a749e163b1a3ddfbcd4b0435f.jpg","Kakashi Hatake","Alive"),
        Characters("https://i.pinimg.com/originals/87/77/ed/8777eda9dbb219d3dd2ba20c861be866.jpg","Hinata huaga","Alive"),
        Characters("https://w0.peakpx.com/wallpaper/941/576/HD-wallpaper-obito-uchiha-electric-blue-art.jpg","Obito Uchiha","Death"),
        Characters("https://i.pinimg.com/564x/75/1c/b1/751cb16901ec4f1fef27de183b9a3d28.jpg","Rin Nohara","Death")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        val adapter = CharacterAdapter(characterList, this:: onClick)
        binding.rvCharacters.adapter = adapter
    }
    private fun onClick(position:Int){
        findNavController().navigate(R.id.nextFragment, bundleOf("key" to characterList[position]))
    }

}
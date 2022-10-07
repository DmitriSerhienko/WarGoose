package com.dimas.wargoose.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.dimas.wargoose.R
import com.dimas.wargoose.databinding.BunkerInFireBinding
import com.dimas.wargoose.databinding.FragmentMapBinding

class MapFrag : Fragment() {


    private lateinit var binding: FragmentMapBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exitFrag()
    }


    private fun exitFrag(){
        binding.bDone.setOnClickListener{
            FragmentManager.setFragment(ActivationGooseFrag.newInstance(), activity as AppCompatActivity)
        }
    }

    companion object {
        fun newInstance() = MapFrag()
    }
}
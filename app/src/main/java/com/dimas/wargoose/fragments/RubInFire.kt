package com.dimas.wargoose.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
import com.dimas.wargoose.databinding.MoscowInFireBinding
import com.dimas.wargoose.databinding.RubInFireBinding
import com.dimas.wargoose.db.MainDb


class RubInFire: Fragment() {

    private lateinit var binding: RubInFireBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = RubInFireBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exitFrag()
    }

    private fun exitFrag(){
        binding.goToMap.setOnClickListener{
            FragmentManager.setFragment(MapFrag.newInstance(), activity as AppCompatActivity)
        }
        binding.imExit.setOnClickListener{
            FragmentManager.setFragment(StartFragment.newInstance(), activity as AppCompatActivity)
        }
    }


    companion object {
        fun newInstance() = RubInFire()
    }
}
package com.dimas.wargoose.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.dimas.wargoose.databinding.StartFragBinding

class StartFragment: Fragment() {

    private lateinit var binding: StartFragBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = StartFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        binding.bDone.setOnClickListener {
            FragmentManager.setFragment(ActivationGooseFrag.newInstance(), activity as AppCompatActivity)
        }
    }




    companion object {
        fun newInstance() = StartFragment()
    }
}
package com.dimas.wargoose.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dimas.wargoose.R
import com.dimas.wargoose.R.color.background
import com.dimas.wargoose.R.color.white
import com.dimas.wargoose.databinding.ActivationGooseBinding


class ActivationGooseFrag: Fragment() {
    private lateinit var binding: ActivationGooseBinding
    private var rub: Boolean = false
    private var moskow: Boolean = false
    private var bunker: Boolean = false
    private var lucash: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = ActivationGooseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startGoose()
        choosePosition()
        exitFrag()
    }

    private fun choosePosition() {

        binding.moscow.setOnClickListener {
            binding.moskowChoosed.setBackgroundColor(resources.getColor(background))
            binding.imMoscow.setImageResource(R.drawable.mackwa_original)

            binding.bunkerChoosed.setBackgroundColor(resources.getColor(white))
            binding.imBunker.setImageResource(R.drawable.bunker_dark)
            binding.rubChosed.setBackgroundColor(resources.getColor(white))
            binding.imRub.setImageResource(R.drawable.rubl_dark)
            binding.dedChoosed.setBackgroundColor(resources.getColor(white))
            binding.imDed.setImageResource(R.drawable.chrik_dark)
            rub = false
            moskow = true
            lucash = false
            bunker = false
        }

        binding.bunker.setOnClickListener {
            binding.bunkerChoosed.setBackgroundColor(resources.getColor(background))
            binding.imBunker.setImageResource(R.drawable.bunker_original)

            binding.moskowChoosed.setBackgroundColor(resources.getColor(white))
            binding.imMoscow.setImageResource(R.drawable.mackwa_dark)
            binding.rubChosed.setBackgroundColor(resources.getColor(white))
            binding.imRub.setImageResource(R.drawable.rubl_dark)
            binding.dedChoosed.setBackgroundColor(resources.getColor(white))
            binding.imDed.setImageResource(R.drawable.chrik_dark)
            rub = false
            moskow = false
            lucash = false
            bunker = true
        }

        binding.lucash.setOnClickListener {
            binding.dedChoosed.setBackgroundColor(resources.getColor(background))
            binding.imDed.setImageResource(R.drawable.chrik_original)

            binding.moskowChoosed.setBackgroundColor(resources.getColor(white))
            binding.imMoscow.setImageResource(R.drawable.mackwa_dark)
            binding.rubChosed.setBackgroundColor(resources.getColor(white))
            binding.imRub.setImageResource(R.drawable.rubl_dark)
            binding.bunkerChoosed.setBackgroundColor(resources.getColor(white))
            binding.imBunker.setImageResource(R.drawable.bunker_dark)
            rub = false
            moskow = false
            lucash = true
            bunker = false
        }

        binding.rubl.setOnClickListener {
            binding.rubChosed.setBackgroundColor(resources.getColor(background))
            binding.imRub.setImageResource(R.drawable.rubl_original)

            binding.moskowChoosed.setBackgroundColor(resources.getColor(white))
            binding.imMoscow.setImageResource(R.drawable.mackwa_dark)
            binding.dedChoosed.setBackgroundColor(resources.getColor(white))
            binding.imDed.setImageResource(R.drawable.chrik_dark)
            binding.bunkerChoosed.setBackgroundColor(resources.getColor(white))
            binding.imBunker.setImageResource(R.drawable.bunker_dark)
            rub = true
            moskow = false
            lucash = false
            bunker = false
        }

    }

    private fun startGoose(){
        binding.goGoose.setOnClickListener {
            when{
                rub -> FragmentManager.setFragment(RubInFire.newInstance(), activity as AppCompatActivity)
                moskow -> FragmentManager.setFragment(MoscowInFire.newInstance(), activity as AppCompatActivity)
                bunker -> FragmentManager.setFragment(BunkerInFire.newInstance(), activity as AppCompatActivity)
                lucash -> FragmentManager.setFragment(DedInFire.newInstance(), activity as AppCompatActivity)
            }
        }
    }

    private fun exitFrag(){
        binding.imExit.setOnClickListener{
            FragmentManager.setFragment(StartFragment.newInstance(), activity as AppCompatActivity)
        }
    }

    companion object {
        fun newInstance() = ActivationGooseFrag()
    }
}
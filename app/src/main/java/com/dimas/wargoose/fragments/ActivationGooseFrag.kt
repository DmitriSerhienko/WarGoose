package com.dimas.wargoose.fragments

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dimas.wargoose.R
import com.dimas.wargoose.R.color.background
import com.dimas.wargoose.R.color.white
import com.dimas.wargoose.activity.MainActivity
import com.dimas.wargoose.databinding.ActivationGooseBinding


class ActivationGooseFrag: Fragment() {
    private lateinit var binding: ActivationGooseBinding
    private lateinit var timer: CountDownTimer
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
            defDed()
            defBunker()
            defRub()
            binding.moskowChoosed.setBackgroundColor(resources.getColor(background))
            binding.imMoscow.setImageResource(R.drawable.mackwa_original)
            moskow = true
        }

        binding.bunker.setOnClickListener {
            binding.bunkerChoosed.setBackgroundColor(resources.getColor(background))
            binding.imBunker.setImageResource(R.drawable.bunker_original)
            defDed()
            defMos()
            defRub()
            bunker = true
        }

        binding.lucash.setOnClickListener {
            binding.dedChoosed.setBackgroundColor(resources.getColor(background))
            binding.imDed.setImageResource(R.drawable.chrik_original)
            lucash = true
            defMos()
            defBunker()
            defRub()
        }

        binding.rubl.setOnClickListener {
            binding.rubChosed.setBackgroundColor(resources.getColor(background))
            binding.imRub.setImageResource(R.drawable.rubl_original)
            rub = true
            defDed()
            defMos()
            defBunker()
        }
    }

    private fun defDed() {
        lucash = false
        binding.dedChoosed.setBackgroundColor(resources.getColor(white))
        binding.imDed.setImageResource(R.drawable.chrik_dark)
    }

    private fun defMos(){
        binding.moskowChoosed.setBackgroundColor(resources.getColor(white))
        binding.imMoscow.setImageResource(R.drawable.mackwa_dark)
        moskow = false
    }

    private fun defBunker(){
        binding.bunkerChoosed.setBackgroundColor(resources.getColor(white))
        binding.imBunker.setImageResource(R.drawable.bunker_dark)
        bunker = false
    }

    private fun defRub(){
        binding.rubChosed.setBackgroundColor(resources.getColor(white))
        binding.imRub.setImageResource(R.drawable.rubl_dark)
        rub = false
    }

    private fun showGoose(){
        binding.gifImageView.visibility = View.VISIBLE
        binding.cardView.visibility = View.GONE
    }

    private fun startGoose(){
        binding.goGoose.setOnClickListener {
            when{
                rub -> {
                    showGoose()
                    timer = object : CountDownTimer(2000, 2000) {
                        override fun onTick(p0: Long) {
                        }
                        override fun onFinish() {
                            FragmentManager.setFragment(RubInFire.newInstance(), activity as AppCompatActivity)
                        }
                    }.start()
                    }
                moskow -> {
                    showGoose()
                    timer = object : CountDownTimer(2000, 2000) {
                        override fun onTick(p0: Long) {
                        }
                        override fun onFinish() {
                            FragmentManager.setFragment(MoscowInFire.newInstance(), activity as AppCompatActivity)
                        }
                    }.start()
                }
                bunker -> {
                    showGoose()
                    timer = object : CountDownTimer(2000, 2000) {
                        override fun onTick(p0: Long) {
                        }
                        override fun onFinish() {
                            FragmentManager.setFragment(BunkerInFire.newInstance(), activity as AppCompatActivity)
                        }
                    }.start()
                }
                lucash -> {
                    showGoose()
                    timer = object : CountDownTimer(2000, 2000) {
                        override fun onTick(p0: Long) {
                        }
                        override fun onFinish() {
                            FragmentManager.setFragment(DedInFire.newInstance(), activity as AppCompatActivity)
                        }
                    }.start()
                }
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
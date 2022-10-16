package com.dimas.wargoose.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dimas.wargoose.R
import com.dimas.wargoose.R.color.background
import com.dimas.wargoose.R.color.white
import com.dimas.wargoose.databinding.ActivationGooseBinding
import com.dimas.wargoose.db.Item
import com.dimas.wargoose.db.MainDb


class ActivationGooseFrag: Fragment() {
    private lateinit var binding: ActivationGooseBinding
    private lateinit var timer: CountDownTimer
    private var rub: Boolean = false
    private var moskow: Boolean = false
    private var bunkers: Boolean = false
    private var lucasha: Boolean = false
   // val db = MainDb.getDb(requireContext().getApplicationContext())

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

    private fun choosePosition() = with(binding) {
        moscow.setOnClickListener {
            defDed()
            defBunker()
            defRub()
            moskowChoosed.setBackgroundColor(resources.getColor(background))
            imMoscow.setImageResource(R.drawable.mackwa_original)
            goGoose.alpha = 1F
            moskow = true
        }

        bunker.setOnClickListener {
            bunkerChoosed.setBackgroundColor(resources.getColor(background))
            imBunker.setImageResource(R.drawable.bunker_original)
            goGoose.alpha = 1F
            defDed()
            defMos()
            defRub()
            bunkers = true
        }

        lucash.setOnClickListener {
            dedChoosed.setBackgroundColor(resources.getColor(background))
            imDed.setImageResource(R.drawable.chrik_original)
            goGoose.alpha = 1F
            lucasha = true
            defMos()
            defBunker()
            defRub()
        }

        rubl.setOnClickListener {
            rubChosed.setBackgroundColor(resources.getColor(background))
            imRub.setImageResource(R.drawable.rubl_original)
            goGoose.alpha = 1F
            rub = true
            defDed()
            defMos()
            defBunker()
        }
    }

    private fun defDed() {
        lucasha = false
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
        bunkers = false
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
//                    var item = Item(+0,
//                    +0, +1,+0)
//                    Thread{
//                        db.getDao().insertItem(item)
//                    }.start()


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
                bunkers -> {
                    showGoose()
                    timer = object : CountDownTimer(2000, 2000) {
                        override fun onTick(p0: Long) {
                        }
                        override fun onFinish() {
                            FragmentManager.setFragment(BunkerInFire.newInstance(), activity as AppCompatActivity)
                        }
                    }.start()
                }
                lucasha -> {
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
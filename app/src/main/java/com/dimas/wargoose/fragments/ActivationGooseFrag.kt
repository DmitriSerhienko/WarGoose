package com.dimas.wargoose.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
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
import com.dimas.wargoose.activity.PREF_CONT
import com.dimas.wargoose.databinding.ActivationGooseBinding
import com.dimas.wargoose.db.Item
import com.dimas.wargoose.db.MainDb

var mosckowPub: Int = 0
var rubPub: Int = 0
var lukashenkoPub: Int = 0
var bunkerPub: Int = 0

class ActivationGooseFrag(): Fragment() {
    private lateinit var binding: ActivationGooseBinding
    private lateinit var timer: CountDownTimer
    private lateinit var sharedMoscow: SharedPreferences
    private lateinit var sharedRub: SharedPreferences
    private lateinit var sharedLuka: SharedPreferences
    private lateinit var sharedBunker: SharedPreferences
    private var rub: Boolean = false
    private var moskow: Boolean = false
    private var bunkers: Boolean = false
    private var lucasha: Boolean = false



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

    @SuppressLint("Range")
    private fun showGoose()= with(binding){
        imGusAttack.visibility = View.VISIBLE
        imGusAttack.alpha = 2F
        imGusAttack.animate().translationY(-3000f).duration = 1900
        //binding.cardView.visibility = View.GONE
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun startGoose() {
        sharedMoscow = this.activity?.getSharedPreferences("mos",Context.MODE_PRIVATE)!!
        sharedLuka = this.activity?.getSharedPreferences("luk",Context.MODE_PRIVATE)!!
        sharedBunker = this.activity?.getSharedPreferences(PREF_CONT,Context.MODE_PRIVATE)!!
        sharedRub = this.activity?.getSharedPreferences(PREF_CONT,Context.MODE_PRIVATE)!!



        binding.goGoose.setOnClickListener {
            when{
                rub -> {

                    showGoose()
                    timer = object : CountDownTimer(1400, 1400) {
                        override fun onTick(p0: Long) {
                        }
                        override fun onFinish() {
                            FragmentManager.setFragment(RubInFire.newInstance(), activity as AppCompatActivity)
                        }
                    }.start()
                    val res = rubPub + 1
                    val mosAt = res.toString()
                    sharedRub.edit().putString("rub", mosAt).apply()
                    rubPub = sharedRub.getString("rub", "0")!!.toInt()


                    val db = MainDb.getDb(requireContext().applicationContext)
                    val item = Item(null, mosckowPub,  0,1,0)
                    Thread{
                        db.getDao().insertItem(item)
                    }.start()

                    }
                moskow -> {
                    showGoose()
                    timer = object : CountDownTimer(1400, 1400) {
                        override fun onTick(p0: Long) {
                        }
                        override fun onFinish() {
                            FragmentManager.setFragment(MoscowInFire.newInstance(), activity as AppCompatActivity)
                        }
                    }.start()
                    val res = mosckowPub + 1
                    val mosAt = res.toString()
                    sharedMoscow.edit().putString("mos", mosAt).apply()
                    mosckowPub = sharedMoscow.getString("mos", "0")!!.toInt()

                    val db = MainDb.getDb(requireContext().applicationContext)
                    val item = Item(null, mosckowPub,  0,0,0)
                    Thread{
                        db.getDao().insertItem(item)
                    }.start()
                }
                bunkers -> {
                    showGoose()
                    timer = object : CountDownTimer(1400, 1400) {
                        override fun onTick(p0: Long) {
                        }
                        override fun onFinish() {
                            FragmentManager.setFragment(BunkerInFire.newInstance(), activity as AppCompatActivity)
                        }
                    }.start()
                    val res = bunkerPub + 1
                    val mosAt = res.toString()
                    sharedBunker.edit().putString("bun", mosAt).apply()
                    bunkerPub = sharedBunker.getString("bun", "0")!!.toInt()

                    val db = MainDb.getDb(requireContext().applicationContext)
                    val item = Item(null, mosckowPub,  0,0,0)
                    Thread{
                        db.getDao().insertItem(item)
                    }.start()
                }
                lucasha -> {
                    showGoose()
                    timer = object : CountDownTimer(1400, 1400) {
                        override fun onTick(p0: Long) {
                        }
                        override fun onFinish() {
                            FragmentManager.setFragment(DedInFire.newInstance(), activity as AppCompatActivity)
                        }
                    }.start()
                    val res = lukashenkoPub + 1
                    val mosAt = res.toString()
                    sharedLuka.edit().putString("luk", mosAt).apply()
                    lukashenkoPub = sharedLuka.getString("luk", "0")!!.toInt()

                    val db = MainDb.getDb(requireContext().applicationContext)
                    val item = Item(null, mosckowPub,  0,0,1)
                    Thread{
                        db.getDao().insertItem(item)
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



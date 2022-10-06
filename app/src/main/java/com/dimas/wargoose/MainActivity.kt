package com.dimas.wargoose


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dimas.wargoose.fragments.FragmentManager
import com.dimas.wargoose.fragments.StartFragment


class MainActivity : AppCompatActivity() {
    //private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FragmentManager.setFragment(StartFragment.newInstance(), this)
       // FragmentManager.setFragment(StartFragment.newInstance(), this)
    }

//    override fun onBackPressed() {
//        if(FragmentManager.currentFragment is DaysFragment) super.onBackPressed()
//        else FragmentManager.setFragment(DaysFragment.newInstance(),this)
//    }
}
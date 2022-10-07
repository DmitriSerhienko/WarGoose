package com.dimas.wargoose.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dimas.wargoose.R
import com.dimas.wargoose.fragments.ActivationGooseFrag
import com.dimas.wargoose.fragments.FragmentManager
import com.dimas.wargoose.fragments.StartFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FragmentManager.setFragment(StartFragment.newInstance(), this)
    }

    override fun onBackPressed() {
        if(FragmentManager.currentFragment is ActivationGooseFrag) super.onBackPressed()
        else FragmentManager.setFragment(ActivationGooseFrag.newInstance(),this)
    }
}
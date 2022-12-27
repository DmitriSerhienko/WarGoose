package com.dimas.wargoose.activity


import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dimas.wargoose.R
import com.dimas.wargoose.fragments.ActivationGooseFrag
import com.dimas.wargoose.fragments.FragmentManager
import com.dimas.wargoose.fragments.StartFragment


const val PREF_CONT = "PREF_COUNT"

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //preferences = getSharedPreferences(APP_PREF, Context.MODE_PRIVATE)

        setContentView(R.layout.activity_main)
        FragmentManager.setFragment(StartFragment.newInstance(), this)
    }

    override fun onBackPressed() {
        if(FragmentManager.currentFragment is ActivationGooseFrag) super.onBackPressed()
        else FragmentManager.setFragment(ActivationGooseFrag.newInstance(),this)
    }
}

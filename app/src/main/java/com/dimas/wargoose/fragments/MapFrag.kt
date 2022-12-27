package com.dimas.wargoose.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dimas.wargoose.R
import com.dimas.wargoose.activity.MapAdapter
import com.dimas.wargoose.activity.MapModel
import com.dimas.wargoose.databinding.FragmentMapBinding
import java.text.SimpleDateFormat
import java.util.*


class MapFrag : Fragment() {
    private lateinit var binding: FragmentMapBinding
    private lateinit var adapter: MapAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init()=with(binding){
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = MapAdapter()
        rcView.adapter = adapter
        val list = listOf(
            MapModel(getCurTime(),R.string.na_moskow,R.drawable.mackwa_gus, mosckowPub.toString()),
            MapModel(getCurTime(),R.string.na_lukasha,R.drawable.chrik_gus, lukashenkoPub.toString()),
            MapModel(getCurTime(),R.string.na_bunker, R.drawable.bunker_gus, bunkerPub.toString()),
            MapModel(getCurTime(),R.string.na_rubl,R.drawable.rubl_gues, rubPub.toString()))
        adapter.submitList(list)

        bDone.setOnClickListener{
            FragmentManager.setFragment(ActivationGooseFrag.newInstance(), activity as AppCompatActivity)
        }



    }

    private fun getCurTime(): String {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("kk:mm dd.MM", Locale.getDefault())
        return formatter.format(time)
    }

    companion object {
        fun newInstance() = MapFrag()
    }
}
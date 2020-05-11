package com.bj.ocean.mygankmeizi.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bj.ocean.mygankmeizi.R

/**
 * Created by ocean on 2020-05-06
 * @describe:
 */
class MineFragment :Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.fragment_mine,container,false)
        initView(view)
        return view
    }

    private fun initView(view: View?) {



    }


}
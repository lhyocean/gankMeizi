package com.bj.ocean.mygankmeizi.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bj.ocean.mygankmeizi.R
import com.bj.ocean.mygankmeizi.adapter.GirlAdapter
import com.bj.ocean.mygankmeizi.util.InjectUtils
import com.bj.ocean.mygankmeizi.viewmodel.GirlListViewModel
/**
 * Created by ocean on 2020-05-06
 * @describe:
 */
class HomeFragment : Fragment() {

    var flagIsFavor: Boolean? = false

    private val viewModel by viewModels<GirlListViewModel> {
        InjectUtils.providerGirlListViewModelFactory(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        initView(view)
        return view
    }
    private fun initView(view: View) {

        if (arguments!=null){
            flagIsFavor=arguments?.getBoolean("isFavor")
        }

       var rec_view=view?.findViewById<RecyclerView>(R.id.rec_view)
        rec_view.layoutManager = StaggeredGridLayoutManager(2,RecyclerView.VERTICAL)
        val adapter =GirlAdapter()
        rec_view.adapter=adapter
        subscribeUi(adapter)
    }

    private fun subscribeUi(girlAdapter: GirlAdapter) {
       if (true==flagIsFavor){
           viewModel.favor.observe(viewLifecycleOwner){
               girlAdapter.submitList(it)
           }
       }else{
           viewModel.girls.observe(viewLifecycleOwner){
               girlAdapter.submitList(it)
           }
       }


    }


}
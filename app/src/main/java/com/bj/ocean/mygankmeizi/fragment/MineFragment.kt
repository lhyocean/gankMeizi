package com.bj.ocean.mygankmeizi.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bj.ocean.mygankmeizi.R
import com.bj.ocean.mygankmeizi.adapter.GirlAdapter
import com.bj.ocean.mygankmeizi.adapter.MineListAdapter
import com.bj.ocean.mygankmeizi.util.InjectUtils
import com.bj.ocean.mygankmeizi.viewmodel.GirlListViewModel

/**
 * Created by ocean on 2020-05-06
 * @describe:
 */
class MineFragment :Fragment(){

    private val viewModel by viewModels<GirlListViewModel> {
        InjectUtils.providerGirlListViewModelFactory(requireContext())
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.fragment_mine,container,false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        var rec=view?.findViewById<RecyclerView>(R.id.rec)
        rec.layoutManager = StaggeredGridLayoutManager(1, RecyclerView.VERTICAL)
        val adapter = MineListAdapter()
        rec.adapter=adapter
        subscribeUi(adapter)
    }
    private fun subscribeUi(adapter: MineListAdapter) {
        viewModel.girls.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

    }


}
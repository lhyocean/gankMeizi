package com.bj.ocean.mygankmeizi.fragment

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bj.ocean.mygankmeizi.R
import com.bj.ocean.mygankmeizi.adapter.GirlAdapter
import com.bj.ocean.mygankmeizi.adapter.MineListAdapter
import com.bj.ocean.mygankmeizi.util.InjectUtils
import com.bj.ocean.mygankmeizi.viewmodel.GirlListViewModel
import kotlinx.android.synthetic.main.fragment_mine.*

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

    private fun toUriScheme(scheme: String) {

        Log.e("dada---", scheme)

        if (scheme.isNullOrEmpty()) return
        try {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = Uri.parse(scheme)
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    private fun initView(view: View) {
        var rec=view?.findViewById<RecyclerView>(R.id.rec)


        rec.layoutManager = MyStaggeredGridLayoutManager(2, RecyclerView.VERTICAL)

        val adapter = MineListAdapter()
        rec.adapter=adapter
        subscribeUi(adapter)

        var tv_title=view?.findViewById<TextView>(R.id.tv_title)
        tv_title.setOnClickListener{

           toUriScheme("gomepaydemo://?sdaas=sd")
        }

    }

    class MyStaggeredGridLayoutManager(spanCount: Int, orientation: Int) :
        StaggeredGridLayoutManager(spanCount, orientation) {
        override fun canScrollVertically(): Boolean {
            return false
        }
    }

    private fun subscribeUi(adapter: MineListAdapter) {
        viewModel.girls.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

    }


}
package com.bj.ocean.mygankmeizi

import android.graphics.Color
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import androidx.navigation.findNavController
import com.bj.ocean.mygankmeizi.adapter.bindFavor
import com.bj.ocean.mygankmeizi.adapter.bindImageFromUrl
import com.bj.ocean.mygankmeizi.data.AppDataBase
import com.bj.ocean.mygankmeizi.data.Girl
import com.bj.ocean.mygankmeizi.data.GirlDao
import com.bj.ocean.mygankmeizi.util.InjectUtils
import com.bj.ocean.mygankmeizi.viewmodel.GirlDetailViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.lay_content.*

class DetailActivity : AppCompatActivity() {

    private var girl_id: String? = null
    val instance by lazy { this }

    private var girl: Girl? = null


    private var girlDetailViewModel: GirlDetailViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)

        girl_id = intent?.getStringExtra("girl_id")
        girl_id?.apply {

            girlDetailViewModel = ViewModelProvider(
                instance, InjectUtils.providerGirlDetailViewModelFractory(instance, this)
            ).get(GirlDetailViewModel::class.java)

            updateUI()

        }
        toolbar.setNavigationOnClickListener {
            finish()
        }


        toolbar_layout.setExpandedTitleColor(Color.parseColor("#ffffff"))
        toolbar_layout.setCollapsedTitleTextColor(Color.parseColor("#111111"))


        fab.setOnClickListener {
            girl?.run {

                if (this.isFavor == 1) {
                    girlDetailViewModel?.girlCancelFavor()
                    Snackbar.make(it, "取消收藏成功", Snackbar.LENGTH_SHORT).show()
                } else {
                    girlDetailViewModel?.addGirlToFavor()
                    Snackbar.make(it, "添加收藏成功", Snackbar.LENGTH_SHORT).show()
                }

            }
        }

        img_favor.setOnClickListener {

            if (girl?.isFavor == 1)
                girlDetailViewModel?.girlCancelFavor()

        }

    }

    private fun hideAppBarFab(fab: FloatingActionButton) {
        val params = fab.layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior as FloatingActionButton.Behavior
        behavior.isAutoHideEnabled = false
        fab.hide()

    }


    private fun showAppBarFab(fab: FloatingActionButton) {
        val params = fab.layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior as FloatingActionButton.Behavior
        behavior.isAutoHideEnabled = true
        fab.show()

    }

    private fun updateUI() {
        girlDetailViewModel?.girl?.observe(instance, Observer {
            if (it != null)
                upDataUi(it)
        })
    }

    private fun upDataUi(it: Girl) {
        if (it.isFavor==1){
            fab.setImageResource(R.drawable.ic_like)
        }else{
            fab.setImageResource(R.drawable.ic_like_not)
        }
        girl = it
        bindImageFromUrl(detail_image, it.url)
        Log.e("adasdasd", "dad" + it.toString())
        tv_create_time.setText("创建时间：" + it.createdAt)
        tv_publish_time.setText("创建时间：" + it.publishedAt)
        tv_desc.setText("" + it.desc)
        tv_scan.setText("浏览量：" + it.views)
        tv_title.setText("" + it.title)
        bindFavor(img_favor, it.isFavor)

    }

}

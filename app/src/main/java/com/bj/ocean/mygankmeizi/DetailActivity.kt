package com.bj.ocean.mygankmeizi

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
import com.bj.ocean.mygankmeizi.adapter.bindImageFromUrl
import com.bj.ocean.mygankmeizi.data.AppDataBase
import com.bj.ocean.mygankmeizi.data.Girl
import com.bj.ocean.mygankmeizi.data.GirlDao
import com.bj.ocean.mygankmeizi.util.InjectUtils
import com.bj.ocean.mygankmeizi.viewmodel.GirlDetailViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_scrolling.*

class DetailActivity : AppCompatActivity() {

    private var girl_id: String? = null
    val instance by lazy { this }


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


            girlDetailViewModel?.girl?.observe(instance, Observer {
                if (it != null)
                    upDataUi(it)

            })

        }
        toolbar.setNavigationOnClickListener {
            finish()
        }

        fab.setOnClickListener {

            girl_id?.apply {

                girlDetailViewModel?.addGirlToFavor()
                hideAppBarFab(fab)
            }
        }
    }

    private fun hideAppBarFab(fab: FloatingActionButton) {
        val params = fab.layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior as FloatingActionButton.Behavior
        behavior.isAutoHideEnabled = false
        fab.hide()

    }

    private fun upDataUi(it: Girl) {

        bindImageFromUrl(detail_image, it.url)
        if (1 == it.isFavor) {
            fab.visibility = View.GONE
        } else {
            fab.visibility = View.VISIBLE
        }


    }

}

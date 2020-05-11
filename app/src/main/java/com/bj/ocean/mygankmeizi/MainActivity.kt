package com.bj.ocean.mygankmeizi

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bj.ocean.mygankmeizi.fragment.HomeFragment
import com.bj.ocean.mygankmeizi.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private var fragmentList = arrayListOf<Fragment>()
    init {

        fragmentList.run {
            var homeFragment = HomeFragment()
            var bundle = Bundle()
            bundle.putBoolean("isFavor", false)
            homeFragment.arguments = bundle
            add(homeFragment)

            bundle = Bundle()
            bundle.putBoolean("isFavor", true)
            var favor = HomeFragment()
            favor.arguments = bundle
            add(favor)

            add(MineFragment())
        }
    }


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                view_pager.currentItem=0
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {

                view_pager.currentItem=1
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                view_pager.currentItem=2
                return@OnNavigationItemSelectedListener true
            }
        }
        return@OnNavigationItemSelectedListener false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        view_pager.adapter=object :FragmentStateAdapter(this){
            override fun getItemCount()=fragmentList.size
            override fun createFragment(position: Int): Fragment =fragmentList[position]

        }
        view_pager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                when(position){
                    0  ->nav_view.selectedItemId=R.id.navigation_home
                    1 ->nav_view.selectedItemId=R.id.navigation_dashboard
                    2 ->nav_view.selectedItemId=R.id.navigation_notifications
                }

            }
        })
        nav_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}

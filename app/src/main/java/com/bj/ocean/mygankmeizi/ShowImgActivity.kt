package com.bj.ocean.mygankmeizi

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.bj.ocean.mygankmeizi.adapter.bindImageFromUrl
import kotlinx.android.synthetic.main.activity_show_img.*

class ShowImgActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_img)

        val img=intent?.getStringExtra("shareImg");

        img?.run {
            bindImageFromUrl(img_bg,img)
        }
        img_back.setOnClickListener{

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                finishAfterTransition()
            }else
            onBackPressed()
        }


    }
}

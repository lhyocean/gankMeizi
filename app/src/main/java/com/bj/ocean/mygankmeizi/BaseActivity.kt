package com.bj.ocean.mygankmeizi

import androidx.appcompat.app.AppCompatActivity

/**
 * Created by ocean on 2020-05-22
 * @describe:
 */
public abstract class BaseActivity : AppCompatActivity(){
    val instance by lazy { this }

}
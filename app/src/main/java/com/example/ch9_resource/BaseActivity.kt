package com.example.ch9_resource

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context?) {
        Log.i("MIN","set attachBaseContext")
        super.attachBaseContext(newBase?.let { LocaleWrapper.wrap(it) })
    }
}
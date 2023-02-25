package com.example.ch9_resource

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ch9_resource.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var localCode:String = "ko"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.radioButton.setOnClickListener {
            localCode = "ko"
            setLocate()
        }
        binding.radioButton2.setOnClickListener {
            localCode = "en"
            setLocate()
        }
    }

    fun setLocate(){

        val locale = Locale(localCode)
        Locale.setDefault(locale)

        val config = Configuration()
        config.setLocale(locale)

        //baseContext.resources.updateConfiguration(config,baseContext.resources.displayMetrics)
        baseContext.createConfigurationContext(config)

        val intent = baseContext.packageManager.getLaunchIntentForPackage(baseContext.packageName)
        intent!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent!!.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        finish()
        startActivity(intent)

    }
}
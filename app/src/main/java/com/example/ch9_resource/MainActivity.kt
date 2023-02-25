package com.example.ch9_resource

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ch9_resource.databinding.ActivityMainBinding
import java.util.*

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private var localCode:String = "ko"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        Log.i("MIN","set onCreate")
        setContentView(binding.root)
        binding.radioButton.setOnClickListener {
            localCode = "ko"
            setLocate()
        }
        binding.radioButton2.setOnClickListener {
            localCode = "en"
            setLocate()
        }

        binding.button.setOnClickListener {
            val nextIntent = Intent(this, Setting::class.java)
            startActivity(nextIntent)
        }
    }

    private fun setLocate(){
        LocaleWrapper.setLocale(localCode)
        recreate()
    }



}
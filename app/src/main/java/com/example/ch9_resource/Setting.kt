package com.example.ch9_resource

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ch9_resource.databinding.ActivitySettingBinding

class Setting : BaseActivity() {
    private lateinit var binding: ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar) //툴바 적용
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // setDisplayHomeAsUpEnabled true설정으로 액션바 나오게 함.
    }

}
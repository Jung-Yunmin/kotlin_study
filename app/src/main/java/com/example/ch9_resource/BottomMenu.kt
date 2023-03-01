package com.example.ch9_resource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.ch9_resource.databinding.ActivityBottomMenuBinding
import com.example.ch9_resource.fragment.OneFragment
import com.example.ch9_resource.fragment.ThreeFragment
import com.example.ch9_resource.fragment.TwoFragment

class BottomMenu : BaseActivity() {

    private lateinit var binding: ActivityBottomMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //첫 화면을 보여줌.
        /*
        with(supportFragmentManager.beginTransaction()){
            changeFragment(OneFragment())
        }
        */
        changeFragment(OneFragment())

        binding.bottomNavigation.setOnItemSelectedListener { item->
            when (item.itemId){
                R.id.tab1 ->{
                    changeFragment(OneFragment())
                }
                R.id.tab2 ->{
                    changeFragment(TwoFragment())
                }
                R.id.tab3 ->{
                    changeFragment(ThreeFragment())
                }
            }
            true
        }

    }

    private fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(binding.container.id, fragment)
            .commit()
    }
}
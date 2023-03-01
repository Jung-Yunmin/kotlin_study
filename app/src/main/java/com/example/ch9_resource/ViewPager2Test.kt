package com.example.ch9_resource

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ch9_resource.databinding.ActivityViewPager2TestBinding
import com.example.ch9_resource.databinding.ItemMainBinding
import com.example.ch9_resource.fragment.OneFragment
import com.example.ch9_resource.fragment.ThreeFragment
import com.example.ch9_resource.fragment.TwoFragment

class ViewPager2Test : AppCompatActivity() {
    private lateinit var binding: ActivityViewPager2TestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPager2TestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var datas = mutableListOf<String>()
        for(i in 1..10){
            datas.add("Item $i")
        }

        //binding.viewpager.adapter = MyPagerAdapter(datas)
        binding.viewpager.adapter = MyFragmentPagerAdapter(this)
    }

    /*
        ViewPager2의 어댑터를 리사이클러 뷰를 이용한 예제

    class MyPagerViewHolder(val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root)
    class MyPagerAdapter(val datas: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            //viewpager2에서 inflate의 width, height 값이 match_parent가 아니면
            //Pages must fill the whole ViewPager2 (use match_parent) Error 오류가 나옴.
            return MyPagerViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val binding = (holder as MyPagerViewHolder).binding

            binding.itemData.text = datas[position]
            when (position % 3) {
                0 -> binding.itemData.setBackgroundColor(Color.RED)
                1 -> binding.itemData.setBackgroundColor(Color.BLUE)
                2 -> binding.itemData.setBackgroundColor(Color.GREEN)
            }
        }
        override fun getItemCount(): Int {
            return datas.size
        }
    }
    */

    //프래그먼트 어댑터는 getItemCount(), createFragment()를 필수 구현해야 함.
    class MyFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity){
        val fragment: List<Fragment>
        init {
            fragment= listOf(OneFragment(), TwoFragment(), ThreeFragment())
        }
        override fun getItemCount(): Int {
            return fragment.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragment[position]
        }
    }
}
package com.example.ch9_resource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ch9_resource.databinding.ActivityRecyclerTestBinding
import com.example.ch9_resource.databinding.ItemMainBinding

class RecyclerTest : BaseActivity() {
    private lateinit var binding: ActivityRecyclerTestBinding
    private lateinit var datas: MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerTestBinding.inflate(layoutInflater)

        setContentView(binding.root)
        datas = mutableListOf<String>()
        for(i in 1..10){
            datas.add("Item $i")
        }

        /*
            recyclerView 가로배치
            val layoutManger = LinearLayoutManager(this)
            layoutManger.orientation = LinearLayoutManager.HORIZONTAL
            binding.recyclerView.layoutManager = layoutManger
         */


        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.recyclerView.adapter = MyAdapter(datas)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))

    }
    class MyViewHoler(val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root)

    //리싸이클 어댑터는 onCreateViewHolder, onBindViewHolder, getItemCount를 필수로 구현해야 함.
    class MyAdapter(val datas: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

        // 항목의 뷰를 가지는 뷰 홀더를 준비하려고 자동으로 호출됨.

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            Log.i("MIN","onCreateViewHolder")
           return  MyViewHoler(ItemMainBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }

        //뷰 홀더의 뷰에 데이터를 출력하려고 자동으로 호출 됨.
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            Log.i("MIN","onBindViewHolder")
            val binding = (holder as MyViewHoler).binding

            //뷰에 데이터
            var itemText = datas[position]
            binding.itemData.text = itemText
            binding.itemRoot.setOnClickListener {
                Log.i("MIN","list click $itemText")
            }
        }

        //항목 개수를 판단하려고 자동으로 호출 됨. 이 함수가 반환한 숫자만큼 onBindViewHolder를 호출 함.
        override fun getItemCount(): Int {
            Log.i("MIN","getItemCount")
            return datas.size
        }
    }
}
package com.example.ch9_resource

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context?) {
        Log.i("MIN","set attachBaseContext")
        super.attachBaseContext(newBase?.let { LocaleWrapper.wrap(it) })
    }

    /* 액션바 업 버튼 설정
       뒤로가기 전 처리할 로직이 있으면 사용

       매니페스트 파일에서 설정시
       <activity
            android:name=".Setting"
            android:parentActivityName = ".MainActivity"></activity>
     */
    override fun onSupportNavigateUp(): Boolean {
        Log.i("MIN","onSupportNavigateUp")
        finish()
        return super.onSupportNavigateUp()
    }

}
package com.example.ch9_resource

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.util.Log
import java.util.*

class LocaleWrapper {


    companion object{
        var locale: Locale = Locale("ko")

        fun setLocale(lang: String){
            locale = Locale(lang)
        }

        fun wrap(baseContext: Context) : Context{
            Log.i("MIN","call wrap locale : "+locale)
            if(locale == null){
                return baseContext;
            }

            val config = Configuration()
            var context: Context = baseContext

            config.setLocale(locale)
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                Log.i("MIN","set CreateConfigurationContext")
                context = baseContext.createConfigurationContext(config)
            }else{
                Log.i("MIN","set updateConfiguration")
                baseContext.resources.updateConfiguration(config,baseContext.resources.displayMetrics)
            }

            return context
        }
    }
}
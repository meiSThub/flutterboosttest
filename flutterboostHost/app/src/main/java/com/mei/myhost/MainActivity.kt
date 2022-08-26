package com.mei.myhost

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.idlefish.flutterboost.FlutterBoost
import com.idlefish.flutterboost.FlutterBoostRouteOptions


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun go2Flutter(view: View) {
        // 通过 flutterboost 的api 跳转flutter 页面
        val options = FlutterBoostRouteOptions.Builder()
            .pageName("/")
            .arguments(emptyMap())
            .requestCode(1111)
            .build()
        FlutterBoost.instance().open(options)
    }
}
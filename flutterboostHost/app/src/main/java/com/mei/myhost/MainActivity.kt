package com.mei.myhost

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.idlefish.flutterboost.FlutterBoost
import com.idlefish.flutterboost.FlutterBoostRouteOptions
import com.mei.myhost.channel.event.EventChannelHelper


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observerNetwork()
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

    /**
     * 模拟网络环境，每个1s，发送一次
     */
    fun observerNetwork() {
        val handler = Handler()
        var netValue = 1
        handler.postDelayed(object : Runnable {
            override fun run() {
                EventChannelHelper.eventSink?.success(netValue++)
                handler.postDelayed(this, 2000)
            }
        }, 500)
    }
}
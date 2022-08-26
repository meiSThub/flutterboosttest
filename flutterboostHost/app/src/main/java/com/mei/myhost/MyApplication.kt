package com.mei.myhost

import android.app.Application
import com.mei.myhost.flutterboost.FlutterBoostInit

/**
 * @date 2022/8/22
 * @author mxb
 * @desc
 * @desired
 */
class MyApplication : Application() {
    companion object {
        lateinit var application: MyApplication
    }

    override fun onCreate() {
        super.onCreate()
        FlutterBoostInit.init(this)
        application = this
    }
}
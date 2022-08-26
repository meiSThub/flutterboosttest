package com.mei.myhost

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.mei.myhost.flutterboost.FlutterBoostInit
import com.mei.myhost.utils.ActivityUtils

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
        registerActivityLifecycleCallbacks(object :ActivityLifecycleCallbacks{
            override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                ActivityUtils.push(p0)
            }

            override fun onActivityStarted(p0: Activity) {
            }

            override fun onActivityResumed(p0: Activity) {
            }

            override fun onActivityPaused(p0: Activity) {
            }

            override fun onActivityStopped(p0: Activity) {
            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
            }

            override fun onActivityDestroyed(p0: Activity) {
                ActivityUtils.pop()
            }
        })
    }
}
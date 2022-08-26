package com.mei.myhost.flutterboost

import android.app.Application
import android.content.Intent
import com.idlefish.flutterboost.FlutterBoost
import com.idlefish.flutterboost.FlutterBoostDelegate
import com.idlefish.flutterboost.FlutterBoostRouteOptions
import com.idlefish.flutterboost.containers.FlutterBoostActivity
import com.mei.myhost.channel.BasicChannelHelper
import com.mei.myhost.channel.MethodChannelHelper
import io.flutter.embedding.android.FlutterActivityLaunchConfigs
import io.flutter.embedding.engine.FlutterEngine


/**
 * @date 2022/8/22
 * @author mxb
 * @desc Flutter Boost 初始化
 * @desired
 */
class FlutterBoostInit {
    companion object {
        fun init(application: Application) {
            FlutterBoost.instance().setup(application, object : FlutterBoostDelegate {
                override fun pushNativeRoute(options: FlutterBoostRouteOptions) {
                    //这里根据options.pageName来判断你想跳转哪个页面，这里简单给一个
                    // val intent = Intent(FlutterBoost.instance().currentActivity(),
                    //     YourTargetAcitvity::class.java
                    // )
                    // FlutterBoost.instance().currentActivity()
                    //     .startActivityForResult(intent, options.requestCode())
                }

                override fun pushFlutterRoute(options: FlutterBoostRouteOptions) {
                    val intent: Intent =
                        FlutterBoostActivity.CachedEngineIntentBuilder(FlutterBoostActivity::class.java)
                            .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
                            .destroyEngineWithActivity(false)
                            .uniqueId(options.uniqueId())
                            .url(options.pageName())
                            .urlParams(options.arguments())
                            .build(FlutterBoost.instance().currentActivity())
                    FlutterBoost.instance().currentActivity().startActivity(intent)
                }
            }) { engine: FlutterEngine? ->
                // 在这里可以初始化 Channel，因为这个时候 FlutterEngine 对象才创建完成
                MethodChannelHelper.initMethodHandler()
                BasicChannelHelper.initMethodHandler()
            }
        }
    }
}
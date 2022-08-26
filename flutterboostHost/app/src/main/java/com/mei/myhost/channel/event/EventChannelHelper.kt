package com.mei.myhost.channel.event

import com.idlefish.flutterboost.FlutterBoost
import io.flutter.plugin.common.EventChannel

/**
 * @date 2022/8/22
 * @author mxb
 * @desc 事件通道，继续广播，通常用于native 端 向 flutter端 上报事件，如：手机电量变化，网络连接变化，陀螺仪，传感器等;
 * @desired
 */
object EventChannelHelper {
    private const val FLUTTER_EVENT_CHANNEL = "flutter.event.channel"

    private val channel: EventChannel by lazy {
        EventChannel(FlutterBoost.instance().engine.dartExecutor, FLUTTER_EVENT_CHANNEL)
    }

}
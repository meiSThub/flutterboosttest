package com.mei.myhost.channel.message

import com.idlefish.flutterboost.FlutterBoost
import com.mei.myhost.channel.BasicChannelHelper
import io.flutter.plugin.common.BasicMessageChannel
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.common.StringCodec

/**
 * @date 2022/8/22
 * @author mxb
 * @desc    字符串消息通道
 * @desired
 */
class BasicMessageStandChannel : IMessageChannel<Any> {
    companion object {
        private const val FLUTTER_BASIC_MESSAGE_STAND = "flutter.channel.basic_message_stand"
    }

    override val channelName = FLUTTER_BASIC_MESSAGE_STAND

    /**
     * 传递 任意对象 类型消息的通道
     */
    private val channel: BasicMessageChannel<Any> by lazy {
        BasicMessageChannel(
            FlutterBoost.instance().engine.dartExecutor,
            channelName,
            StandardMessageCodec.INSTANCE
        )
    }

    /**
     * 初始化消息处理器
     */
    override fun initMessageHandler() {
        channel.setMessageHandler(this)
    }

    /**
     * native 接收到 flutter 消息
     * @param message
     * @param reply
     */
    override fun onMessage(message: Any?, reply: BasicMessageChannel.Reply<Any>) {
    }

    override fun send(message: Any?, callback: BasicMessageChannel.Reply<Any>?) {
        channel.send(message, callback)
    }

}
package com.mei.myhost.channel.message

import com.idlefish.flutterboost.FlutterBoost
import com.mei.myhost.channel.BasicChannelHelper
import io.flutter.plugin.common.BasicMessageChannel
import io.flutter.plugin.common.StringCodec

/**
 * @date 2022/8/22
 * @author mxb
 * @desc    字符串消息通道
 * @desired
 */
class BasicMessageStringChannel : IMessageChannel<String> {
    companion object {
        private const val FLUTTER_BASIC_MESSAGE_STRING = "flutter.channel.basic_message_string"
    }

    override val channelName = FLUTTER_BASIC_MESSAGE_STRING

    /**
     * 传递 String 类型消息的通道
     */
    private val channel: BasicMessageChannel<String> by lazy {
        BasicMessageChannel(
            FlutterBoost.instance().engine.dartExecutor,
            channelName,
            StringCodec.INSTANCE
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
    override fun onMessage(message: String?, reply: BasicMessageChannel.Reply<String>) {

    }

    override fun send(message: String?, callback: BasicMessageChannel.Reply<String>?) {
    }

}
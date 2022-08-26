import 'package:flutter/services.dart';

class MethodChannelHelper {
  static const String flutterMethodChannel = "flutter.channel.common.method";

  final MethodChannel _channel = const MethodChannel(flutterMethodChannel);

  MethodChannelHelper._internal();

  static late final MethodChannelHelper _instance =
      MethodChannelHelper._internal();

  factory MethodChannelHelper() => _instance;

  /// 获取手机电量
  Future<String> getBatteryLevel() async {
    String battery = await _channel.invokeMethod("getBatteryLevel");
    return battery;
  }
}

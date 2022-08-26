import 'package:flutter/material.dart';
import 'package:flutter_boost/flutter_boost.dart';
import 'package:myflutter/pages/home/home_page.dart';
import 'package:myflutter/pages/message/message_list_page.dart';
import 'package:myflutter/routes/page_num.dart';

/// 路由表
class RouteMap {
  static Map<String, FlutterBoostRouteFactory> routerMap = {
    PageNum.homePage: (settings, uniqueId) {
      return PageRouteBuilder<dynamic>(
          settings: settings, pageBuilder: (_, __, ___) => const HomePage());
    },
    PageNum.messageListPage: (settings, uniqueId) {
      return PageRouteBuilder(
        settings: settings,
        pageBuilder: (_, __, ___) => MessageListPage(
          arguments: settings.arguments,
        ),
      );
    }
  };
}

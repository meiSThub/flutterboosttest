import 'package:flutter/material.dart';
import 'package:flutter_boost/flutter_boost.dart';
import 'package:myflutter/base/base_page_widget.dart';
import 'package:myflutter/channel/method_channel.dart';
import 'package:myflutter/routes/page_num.dart';

/// 首页
class HomePage extends BasePageWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  State<BasePageWidget> getState() => HomePageState();
}

class HomePageState extends BasePageState {
  @override
  String? pageTitle = "首页";

  // 显示结果
  String result = "结果";

  @override
  Widget buildContent(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.only(left: 10, right: 10),
      child: ListView(
        children: [
          Padding(
            padding: const EdgeInsets.all(10),
            child: Text(
              result,
              style: const TextStyle(
                fontSize: 20,
                color: Colors.red,
              ),
            ),
          ),
          ElevatedButton(
            onPressed: () async {
              String battery = await MethodChannelHelper().getBatteryLevel();
              print('battery=$battery');
              setState(() {
                result = battery;
              });
            },
            child: const Text("调用native方法，获取电量"),
          ),
          ElevatedButton(
            onPressed: () {
              // name	          页面在路由表中的名字
              // withContainer	是否需伴随原生容器弹出
              // arguments	    携带到下一页面的参数
              // opaque	        页面是否透明(下面会再次提到)
              BoostNavigator.instance.push(
                PageNum.messageListPage,
                withContainer: false,
                arguments: {"name": "消息列表"},
                opaque: false,
              );

              /// 或者
              /// Navigator.of(context).pushNamed('simplePage', arguments: {'data': _controller.text});
            },
            child: const Text("不开启新容器，跳转页面"),
          ),
          ElevatedButton(
            onPressed: () {
              BoostNavigator.instance.push(
                PageNum.messageListPage,
                withContainer: true,
                arguments: {"name": "消息列表"},
                opaque: false,
              );
            },
            child: const Text("开启新容器的方式进行页面跳转"),
          ),
        ],
      ),
    );
  }
}

package cn.edu.hhit.service.ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/2117:37
 */
public class Test {
    public static void main(String[] args) {
        //定义一个痴迷玩家陈浩
        IGamePlayer gamePlayer = new GamePlayer_chenhao("陈浩");
        //将代理者传入动态代理类
        InvocationHandler handler = new GamePlayIH(gamePlayer);

        IGamePlayer proxyInstance = (IGamePlayer) Proxy.newProxyInstance(handler.getClass().getClassLoader(),new Class[]{IGamePlayer.class},handler);
        proxyInstance.login("陈浩","123456");
        proxyInstance.upgrade();
    }



}

package cn.edu.hhit.service.ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/2117:34
 */
public class GamePlayIH implements InvocationHandler {
    // 被代理者
    Object obj = null;
    // 被代理者实例
    Class clz = null;

    public GamePlayIH(Object obj) {
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equalsIgnoreCase("login")){
            System.out.println("有人用我的账号登陆");
        }
        if(method.getName().equalsIgnoreCase("upgrade")){
            System.out.println("代理通知升级了");
        }
        method.invoke(obj,args);
        if(method.getName().equalsIgnoreCase("upgrade")){
            System.out.println("代理通知升级了2");
        }
        return null;
    }
}

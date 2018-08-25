package cn.edu.hhit.service.ObserverPattern;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/250:07
 */
public class ObserverZS implements IObserver {
    @Override
    public void update(String message, String name) {
        System.out.println("张三说："+"被观察者名称:"+name+",他说了："+message);
    }
}

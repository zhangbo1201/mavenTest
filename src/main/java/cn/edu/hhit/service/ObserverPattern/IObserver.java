package cn.edu.hhit.service.ObserverPattern;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/250:06
 */
//观察者接口
public interface IObserver {
    //观察者行动
    void update(String message,String name);
}

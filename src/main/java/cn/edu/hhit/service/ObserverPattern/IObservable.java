package cn.edu.hhit.service.ObserverPattern;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/250:12
 */
//被观察者接口
public interface IObservable {
    void addObserver(IObserver observer);
    void deleteObserver(IObserver observer );
    void notifyObserver(String message);
}

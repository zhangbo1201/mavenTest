package cn.edu.hhit.service.ObserverPattern;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/250:31
 */
public class Client {
    public static void main(String[] args) {
        //定义三个观察者;
        IObserver observer1 = new ObserverZS();
        IObserver observer2 = new ObserverLS();
        IObserver observer3 = new ObserverWW();
        //定义两个被观察者
        IObservable observable1 = new Observable_huairen1("熊大");
        IObservable observable2 = new Observable_huairen2("熊二");

        observable1.addObserver(observer1);
        observable1.addObserver(observer2);
        observable1.addObserver(observer3);

        observable2.addObserver(observer1);
        observable2.addObserver(observer2);
        observable2.addObserver(observer3);

        observable1.notifyObserver("吃树");
        ((Observable_huairen2) observable2).notifyObserver();
        observable2.notifyObserver("喝药");
    }
}

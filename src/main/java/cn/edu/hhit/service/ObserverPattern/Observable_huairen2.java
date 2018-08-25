package cn.edu.hhit.service.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/250:22
 */
public class Observable_huairen2 implements IObservable {
    private List<IObserver> observers = new ArrayList<IObserver>();

    String name = "";

    public Observable_huairen2(String name){
        this.name =name;
    }

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String message) {
        for (int i = 0; i < observers.size(); i++) {
            IObserver iObserver =  observers.get(i);
            iObserver.update(message,name);
        }
    }
    public void notifyObserver() {
        System.out.println("打印名称不执行任何操作！");
    }
}
